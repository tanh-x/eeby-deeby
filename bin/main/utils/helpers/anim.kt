package utils.helpers

import godot.AnimationTree
import godot.SceneTreeTween
import godot.core.Vector2

/**
 * Helper method to get the blend space position of an [AnimationTree]
 */
internal fun AnimationTree.getBlendPositionOf(space: String): Vector2 = this["parameters/$space/blend_position"]

/**
 * Helper method to set the blend space position of an [AnimationTree]
 */
internal fun AnimationTree.setBlendPositionOf(space: String, vec: Vector2) {
	this["parameters/$space/blend_position"] = vec
}

/**
 * Creates a new [SceneTreeTween]
 */
internal fun godot.Node.SceneTreeTweener(): SceneTreeTween = getTree()!!.createTween()!!