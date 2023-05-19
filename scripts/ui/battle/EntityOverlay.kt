package ui.battle

import battle.entity.AbstractEntity
import battle.entity.Vulnerable
import godot.*
import godot.annotation.RegisterClass
import godot.annotation.RegisterFunction
import godot.core.Vector2
import godot.global.GD
import utils.helpers.instantiateScene
import utils.helpers.node
import kotlin.random.Random

@RegisterClass
open class EntityOverlay : Control() {
    internal lateinit var entity: AbstractEntity<*>

    private var entIsVulnerable: Boolean = false

    private lateinit var healthbar: Healthbar

    @RegisterFunction
    override fun _ready() {
        healthbar = node("Healthbar")
    }

    @RegisterFunction
    fun canDropData(position: Vector2, data: Any?): Boolean {
        return data == "attack"
    }

    @RegisterFunction
    fun dropData(position: Vector2, data: Any?) {
        GD.print("successful attack")
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
