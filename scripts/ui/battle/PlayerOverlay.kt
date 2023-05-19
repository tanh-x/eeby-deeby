package ui.battle

import battle.entity.AbstractEntity
import character.AbstractCharacter
import character.AbstractCharacterNode
import godot.GlobalConstants.BUTTON_LEFT
import godot.InputEvent
import godot.InputEventMouseButton
import godot.annotation.RegisterClass
import godot.annotation.RegisterFunction
import godot.core.Vector2

@RegisterClass
class PlayerOverlay : EntityOverlay() {
    private lateinit var character: AbstractCharacter<out AbstractCharacterNode>
    private var isDragging: Boolean = false

    @RegisterFunction
    override fun _ready() {
        super._ready()
    }

    @RegisterFunction
    override fun _getDragData(position: Vector2): Any? {
        println("hello")
        if (getRect().hasPoint(position)) return "attack"
        return null
    }

    override fun attachEntity(entity: AbstractEntity<*>) {
        super.attachEntity(entity)
        this.character = entity as AbstractCharacter<out AbstractCharacterNode>
    }
}