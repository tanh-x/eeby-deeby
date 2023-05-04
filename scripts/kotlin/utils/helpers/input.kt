package utils.helpers

import godot.Input
import godot.core.Vector2


internal fun getInputVector(): Vector2 = Vector2(
	x = Input.getActionStrength("ui_right") - Input.getActionStrength("ui_left"),
	y = Input.getActionStrength("ui_down") - Input.getActionStrength("ui_up")
).normalized()