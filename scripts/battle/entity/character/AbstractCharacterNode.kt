package battle.entity.character

import battle.entity.AbstractEntityNode
import godot.Sprite
import godot.annotation.RegisterClass
import godot.annotation.RegisterFunction
import godot.core.Vector2
import godot.global.GD
import utils.helpers.toScreenSpace

@RegisterClass
abstract class AbstractCharacterNode : AbstractEntityNode() {
	/**
	 * For characters, the entity name must correspond to the identifier used in assets/characters/
	 * Otherwise, the [createSprite] method must be overridden
	 */
	internal open override val entityName: String = "character"

	@RegisterFunction
	override fun _ready() {
		super._ready()

		println("AbstractChrNode $entityName ready")
	}

	override fun createSprite(): Sprite = Sprite().apply {
		val identifier: String = entityName.lowercase()
		val assetDir = "res://assets/characters/$identifier/"
		texture = GD.load("$assetDir$identifier.png")
	}
}