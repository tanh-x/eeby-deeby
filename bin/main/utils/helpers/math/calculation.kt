package utils.helpers.math

import godot.core.Vector2
import kotlin.math.cos
import kotlin.math.sin

/**
 * Converts a radian value to its corresponding unit vector
 */
internal fun Double.radianToVector2(): Vector2 = Vector2(cos(this), sin(this))