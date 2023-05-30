package utils.helpers.math

import godot.core.Vector2
import godot.global.GD.lerp

/**
 * Evaluates and returns a list of [Vector2] representing a quadratic Bézier curve.
 * Can be optimized by doing lerp on the components instead of the whole vector.
 *
 * @param v The starting endpoint
 * @param w The stopping endpoint
 * @param p The midpoint
 * @param num The number of samples, including both endpoints
 */
fun QuadraticBezier(v: Vector2, w: Vector2, p: Vector2, num: Int): List<Vector2> =
	linspace(0.0, 1.0, num).map { t: Double ->
		lerp(lerp(v, p, t), lerp(p, w, t), t)
	}