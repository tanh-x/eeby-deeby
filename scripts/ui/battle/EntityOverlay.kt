package ui.battle

import battle.entity.AbstractEntity
import battle.entity.Vulnerable
import godot.*
import godot.annotation.RegisterClass
import godot.annotation.RegisterFunction
import godot.core.Vector2
import godot.global.GD
import gds.DragDrop
import utils.helpers.instantiateScene
import utils.helpers.node
import kotlin.random.Random

@RegisterClass
open class EntityOverlay : Control(), DragDrop {
    internal lateinit var entity: AbstractEntity<*>

    private var entIsVulnerable: Boolean = false

    private lateinit var healthbar: Healthbar

    @RegisterFunction
    override fun _ready() {
        healthbar = node("Healthbar")
    }

    @RegisterFunction
    override fun gdGetDragData(position: Vector2): Any? {
        GD.print("#dragging")
        setDragPreview(TextureRect().apply {
            texture = GD.load("res://assets/test.png")
        })
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

    internal open fun attachEntity(entity: AbstractEntity<*>) {
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
