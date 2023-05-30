package utils.helpers.math

import godot.core.Vector2

/**
 * Modifies each component of the vector to linearly interpolate to a new vector.
 * This method mutates the vector instead of returning a new one.
 *
 * @param v The vector to interpolate to
 * @param t The interpolating factor. Accepts any real number value
 */
internal fun Vector2.lerpTo(v: Vector2, t: Double) {
	x += t * (v.x - x)
	y += t * (v.y - y)
}

/**
 * Modifies each component of the vector to linearly interpolate to new x and y values.
 * This method mutates the vector instead of returning a new one.
 *
 * @param u The value to interpolate the x component to
 * @param v The value to interpolate the y component to
 * @param t The interpolating factor. Accepts any real number value
 */
internal fun Vector2.lerpTo(u: Double, v: Double, t: Double) {
	x += t * (u - x)
	y += t * (v - y)
}

/**
 * Scales an arbitrary vector to have a magnitude of [s]
 *
 * @param s The target magnitude
 */
internal fun Vector2.scaleTo(s: Double) = normalized() * s

/**
 * Adds two vectors by mutating the original vector instead of returning a new one
 *
 * @param v The addend vector
 */
internal operator fun Vector2.plusAssign(v: Vector2) {
	x += v.x
	y += v.y
}

/**
 * Subtract two vectors by mutating the original vector instead of returning a new one
 *
 * @param v The subtrahend vector
 */
internal operator fun Vector2.minusAssign(v: Vector2) {
	x -= v.x
	y -= v.y
}