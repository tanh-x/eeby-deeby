package utils.helpers.math

import godot.core.Vector2
import kotlin.math.*

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
internal fun Double.isWithin(lowerBound: Double, upperBound: Double): Boolean = this > lowerBound && this < upperBound

/**
 * Converts the [Boolean] into 0 or 1
 */
internal fun Boolean.toInt(): Int = if (this) 1 else 0

internal val DEFAULT_PREFIXES: Array<String> = arrayOf(
	"", "k", "M", "B", "T"
)

/**
 * Returns the standard deviation of a [Collection] of [Double]s
 */
internal fun Collection<Double>.stdev(): Double {
	val mean: Double = this.average()
	return sqrt((this.sumOf { (it - mean) * (it - mean) }) / (this.size - 1))
}

/**
 * Converts a [Double] into a metric format
 */
internal fun Double.formatted(
	threshold: Double = 10000.0,
	digits: Int = 2,
	prefixes: Array<String> = DEFAULT_PREFIXES,
	offset: Int = 0,
	base: Double = 10.0
): String {
	// Then simply round and pad zeros
	if (this < threshold) return "%.${digits}f".format(this)

	/*
	* Integer divide the result by 3 to snap to increments of 3, then multiply back.
	* This is done because we want the result in increments (thousands, millions, billions)
	* instead of the pure log10 value.
	* */
	val exponent: Int = log(this, base).toInt() / 3 + offset

	// Return the scientific notation truncated to some number of digits
	if (exponent >= prefixes.size) return "%.${digits}e".format(this)

	val significand: Double = this / base.pow(exponent * 3.0)
	return "%.${digits}f".format(significand) + prefixes[exponent]
}

internal fun Long.formatted(
	threshold: Double = 10000.0,
	digits: Int = 2,
	prefixes: Array<String> = DEFAULT_PREFIXES,
	offset: Int = 0,
	base: Double = 10.0
): String = this.toDouble().formatted(threshold, digits, prefixes, offset, base)

internal fun Int.formatted(
	threshold: Double = 10000.0,
	digits: Int = 2,
	prefixes: Array<String> = DEFAULT_PREFIXES,
	offset: Int = 0,
	base: Double = 10.0
): String = this.toDouble().formatted(threshold, digits, prefixes, offset, base)