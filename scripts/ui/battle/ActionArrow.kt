package ui.battle

import godot.ColorRect
import godot.GlobalConstants.BUTTON_LEFT
import godot.InputEvent
import godot.InputEventMouseButton
import godot.Path2D
import godot.annotation.RegisterClass
import godot.annotation.RegisterFunction
import godot.core.Color
import godot.core.Vector2
import utils.helpers.instantiateScene
import utils.helpers.toScreenSpace

@RegisterClass
class ActionArrow : Path2D() {
    private lateinit var testRect: ColorRect

    init {
        name = "ActionArrow"
    }

    @RegisterFunction
    override fun _ready() {
        testRect = instantiateScene<ColorRect>("res://scenes/utils/TestRect.tscn")
        addChild(testRect)
    }

    @RegisterFunction
    override fun _process(delta: Double) {
        testRect.setGlobalPosition(getGlobalMousePosition())
    }

    @RegisterFunction
    override fun _draw() {
        drawLine(Vector2(520.0, 800.0), Vector2(760.0, 600.0), Color.aqua, 5.0)
        drawLine(Vector2(760.0, 600.0), Vector2(900.0, 760.0), Color.aqua, 5.0)
        drawLine(Vector2(900.0, 760.0), Vector2(1200.0, 460.0), Color.aqua, 5.0)
    }


    @RegisterFunction
    override fun _input(event: InputEvent) {
        if (event is InputEventMouseButton && event.buttonIndex == BUTTON_LEFT && !event.pressed) queueFree()
    }
}