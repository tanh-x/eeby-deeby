package utils.helpers

import godot.AnimationTree
import godot.core.Vector2

/**
 * Helper method to get the blend space position of an [AnimationTree]
 */
fun AnimationTree.getBlendPositionOf(space: String): Vector2 = this["parameters/$space/blend_position"]

/**
 * Helper method to set the blend space position of an [AnimationTree]
 */
fun AnimationTree.setBlendPositionOf(space: String, vec: Vector2) {
	this["parameters/$space/blend_position"] = vec
}