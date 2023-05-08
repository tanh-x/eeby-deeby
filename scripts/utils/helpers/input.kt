package utils.helpers

import godot.Input
import godot.core.Vector2


/**
 * Gets and returns the directional movement input ("WASD") as a unit vector.
 *
 * @return The input vector
 */
internal fun getInputVector(): Vector2 = Vector2(
	x = Input.getActionStrength("ui_right") - Input.getActionStrength("ui_left"),
	y = Input.getActionStrength("ui_down") - Input.getActionStrength("ui_up")
).normalized()