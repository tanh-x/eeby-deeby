package utils.helpers

import godot.AnimationTree
import godot.core.Vector2

fun AnimationTree.getBlendPositionOf(space: String): Vector2 = this["parameters/$space/blend_position"]
fun AnimationTree.setBlendPositionOf(space: String, vec: Vector2) {
	this["parameters/$space/blend_position"] = vec
}