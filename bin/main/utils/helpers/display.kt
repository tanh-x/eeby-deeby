package utils.helpers

import godot.core.Vector2

internal fun Vector2.toScreenSpace(): Vector2 = Vector2(
	x = this.x * godot.ProjectSettings.getSetting("display/window/size/width") as Long,
	y = this.y * godot.ProjectSettings.getSetting("display/window/size/height") as Long
)

internal fun toScreenSpace(x: Double, y: Double) = Vector2(
	x = x * godot.ProjectSettings.getSetting("display/window/size/width") as Long,
	y = y * godot.ProjectSettings.getSetting("display/window/size/height") as Long
)

