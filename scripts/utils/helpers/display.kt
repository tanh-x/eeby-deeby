package utils.helpers

import godot.ProjectSettings.getSetting
import godot.core.Vector2

private const val WIDTH_SETTING_PATH: String = "display/window/size/width"
private const val HEIGHT_SETTING_PATH: String = "display/window/size/height"

val gameWindowSize: Vector2 = Vector2(
	x = getSetting(WIDTH_SETTING_PATH) as Long,
	y = getSetting(HEIGHT_SETTING_PATH) as Long
)

internal fun Vector2.toScreenSpace(): Vector2 = this * gameWindowSize

internal fun toScreenSpace(x: Double, y: Double) = Vector2(
	x = x * gameWindowSize.x,
	y = y * gameWindowSize.y
)

