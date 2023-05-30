package utils.helpers.math

import godot.core.Vector2
import kotlin.math.cos
import kotlin.math.max
import kotlin.math.sin

/**
 * Converts a radian value to its corresponding unit vector
 */
internal fun Double.radianToVector2(): Vector2 = Vector2(cos(this), sin(this))

/**
 * Coerces a number to be nonnegative
 */
internal fun ramp(x: Double): Double = max(0.0, x)

/**
 * Creates a list of [num] evenly spaced numbers over the interval [start, stop]
 */
internal fun linspace(start: Double, stop: Double, num: Int, includeStop: Boolean = true): List<Double> {
	val d: Double = (stop - start) / (num - includeStop.toInt())
	return (0 until num).map { i -> i * d + start }
}

/**
 * @return Whether the given number is within the range (exclusive on both ends)
 */
internal fun Double.isWithin(lowerBound: Double, upperBound: Double): Boolean =
	this > lowerBound && this < upperBound

/**
 * Converts the [Boolean] into 0 or 1
 */
internal fun Boolean.toInt(): Int = if (this) 1 else 0