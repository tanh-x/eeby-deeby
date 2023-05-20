package ui.battle

import godot.*
import godot.GlobalConstants.BUTTON_LEFT
import godot.annotation.RegisterClass
import godot.annotation.RegisterFunction
import godot.global.GD
import utils.helpers.instantiateScene

@RegisterClass
class ActionArrow : Node2D() {
    init {
        name = "ActionArrow"
    }

    @RegisterFunction
    override fun _ready() {
        addChild(instantiateScene<ColorRect>("res://scenes/utils/TestRect.tscn"))
    }

    @RegisterFunction
    override fun _process(delta: Double) {
        globalPosition = getGlobalMousePosition()
    }

    @RegisterFunction
    override fun _input(event: InputEvent) {
        if (event is InputEventMouseButton && event.buttonIndex == BUTTON_LEFT && event.pressed == false) {
            queueFree()
        }
    }
}