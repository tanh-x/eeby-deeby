package utils.helpers.math

import godot.core.Vector2
import kotlin.math.cos
import kotlin.math.sin

internal fun Double.radianToVector2(): Vector2 = Vector2(cos(this), sin(this))