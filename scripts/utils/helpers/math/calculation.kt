package utils.helpers.math

import godot.core.Vector2
import kotlin.math.cos
import kotlin.math.max
import kotlin.math.sin

/**
 * Converts a radian value to its corresponding unit vector
 */
fun Double.radianToVector2(): Vector2 = Vector2(cos(this), sin(this))

/**
 * Coerces a number to be nonnegative
 */
fun ramp(x: Double): Double = max(0.0, x)

fun linspace(start: Double, stop: Double, num: Int): List<Double> {
    val d: Double = (stop - start) / (num - 1)
    return (0 until num).map { i -> i * d + start }
}
