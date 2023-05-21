package ui.battle

import EngineSingletons.getManager
import EngineSingletons.singleton
import battle.core.BattleScene
import battle.entity.AbstractEntity
import battle.entity.AbstractEntityNode
import battle.entity.Vulnerable
import godot.*
import godot.annotation.RegisterClass
import godot.annotation.RegisterFunction
import godot.core.Vector2
import godot.global.GD
import gds.DragDrop
import utils.helpers.instantiateScene
import utils.helpers.math.isWithin
import utils.helpers.node
import kotlin.random.Random

@RegisterClass
open class EntityOverlay : Control(), DragDrop {
    internal lateinit var entity: AbstractEntity<out AbstractEntityNode>

    private lateinit var battleScene: BattleScene

    private var entIsVulnerable: Boolean = false

    private lateinit var healthbar: Healthbar

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
    override fun gdGetDragData(position: Vector2): Any? {
        getManager().currentRoot.addChild(ActionArrowPreview(entity, battleScene.enemies.values))
        return "attack"
    }

    @RegisterFunction
    override fun gdCanDropData(position: Vector2, data: Any?): Boolean {
        return true
    }

    @RegisterFunction
    override fun gdDropData(position: Vector2, data: Any?) {
        GD.print("#dropped")
    }

    internal open fun attachEntity(entity: AbstractEntity<out AbstractEntityNode>) {
        this.entity = entity
        if (entity is Vulnerable) {
            healthbar.entity = entity
            entIsVulnerable = true
            healthbar.visible = true
        }
        updateAll()
    }

    @RegisterFunction
    open fun updateAll() {
        if (entIsVulnerable) healthbar.rerender()
    }

    internal fun spawnDamageNumber(number: Double) {
        val label: DamageNumber = instantiateScene("res://scenes/ui/DamageNumber.tscn")
        label.text = number.toInt().toString()
        label.rectRotation = Random.nextDouble() * 60 - 30
        addChild(label)
    }
}
