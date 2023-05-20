package ui.battle

import godot.ColorRect
import godot.Control
import godot.Node2D
import godot.TextureRect
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
}