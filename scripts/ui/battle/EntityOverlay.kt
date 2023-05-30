package ui.battle

import EngineSingletons.singleton
import battle.card.Card
import battle.core.Action
import battle.core.ActionType
import battle.core.BattleScene
import battle.entity.AbstractEntity
import battle.entity.AbstractEntityNode
import battle.entity.Vulnerable
import battle.entity.character.AbstractCharacter
import battle.entity.character.AbstractCharacterNode
import gds.DragDrop
import gds.GodotDataFactory
import godot.Control
import godot.annotation.RegisterClass
import godot.annotation.RegisterFunction
import godot.core.Dictionary
import godot.core.Vector2
import utils.helpers.instantiateScene
import utils.helpers.math.isWithin
import utils.helpers.node
import kotlin.random.Random

@RegisterClass
open class EntityOverlay : Control(), DragDrop {
	internal lateinit var entity: AbstractEntity<out AbstractEntityNode>

	private lateinit var battleScene: BattleScene

	private lateinit var healthbar: Healthbar

	private var arrowPreview: ActionArrowPreview? = null

	@RegisterFunction
	override fun _ready() {
		healthbar = node("Healthbar")
		battleScene = singleton("BattleScene")
	}

	@RegisterFunction
	override fun _hasPoint(point: Vector2): Boolean {
		val localPosition: Vector2 = point - rectGlobalPosition
		val rect: Vector2 = rectSize
		// May have problems if the Control node is scaled
		return localPosition.x.isWithin(0.0, rect.x) && localPosition.y.isWithin(0.0, rect.y)
	}

	@RegisterFunction
	override fun gdGetDragData(position: Vector2): Dictionary<String, Int>? {
		if (!entity.playerSide) return null
		arrowPreview = ActionArrowPreview(entity, battleScene.enemiesList)
		battleScene.addChild(arrowPreview!!)
		return GodotDataFactory.newBattleAction(actor = entity)
	}

	@RegisterFunction
	override fun gdCanDropData(position: Vector2, data: Any?): Boolean {
		return data is Dictionary<*, *> && data.containsKey("actor")
	}

	@RegisterFunction
	override fun gdDropData(position: Vector2, data: Any?) {
		arrowPreview?.queueFree()

		@Suppress("UNCHECKED_CAST")
		data as Dictionary<String, Int>

		val actor: AbstractCharacter<out AbstractCharacterNode> = battleScene.getCharacterById(data["actor"])!!
		battleScene.queueAction(
			Action(
				actor = actor,
				target = entity,
				card = Card.NONE,
				type = if (entity.playerSide)
					if (actor == entity) ActionType.SELF
					else ActionType.SUPPORT
				else ActionType.OFFENSE
			)
		)
	}

	internal open fun attachEntity(entity: AbstractEntity<out AbstractEntityNode>) {
		this.entity = entity
		if (entity is Vulnerable) {
			healthbar.entity = entity
			healthbar.visible = true
		}
		updateAll()
	}

	@RegisterFunction
	open fun updateAll() {
		if (healthbar.visible) healthbar.rerender()
	}

	internal fun spawnDamageNumber(number: Double) {
		val label: DamageNumber = instantiateScene("res://scenes/ui/battle/DamageNumber.tscn")
		label.text = number.toInt().toString()
		label.rectRotation = Random.nextDouble() * 40 - 20
		addChild(label)
	}
}
