package ui.battle

import godot.ColorRect
import godot.Control
import godot.annotation.RegisterClass
import godot.annotation.RegisterFunction

@RegisterClass
class Healthbar: Control() {
	internal var maxHealth: Double = 1.0
	internal var health: Double = 1.0

	private lateinit var colorRect: ColorRect

	@RegisterFunction
	override fun _ready() {

	}

	@RegisterFunction
	fun rerender() {

	}
}