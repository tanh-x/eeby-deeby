package utils.helpers.math

import godot.core.Vector2


internal fun Vector2.lerpTo(v: Vector2, t: Double) {
	x += t * (v.x - x)
	y += t * (v.y - y)
}

internal fun Vector2.lerpTo(u: Double, v: Double, t: Double) {
	x += t * (u - x)
	y += t * (v - y)
}

internal fun Vector2.scaleTo(s: Double) = normalized() * s

internal operator fun Vector2.plusAssign(v: Vector2) {
	x += v.x
	y += v.y
}