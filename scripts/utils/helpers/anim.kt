package utils.helpers

import godot.AnimationTree
import godot.PropertyTweener
import godot.SceneTreeTween
import godot.Tween.EaseType
import godot.Tween.EaseType.EASE_OUT
import godot.Tween.TransitionType
import godot.Tween.TransitionType.TRANS_CUBIC
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
internal fun godot.Node.sceneTreeTweener(): SceneTreeTween = getTree()!!.createTween()!!

internal fun PropertyTweener.setCurve(trans: TransitionType = TRANS_CUBIC, ease: EaseType = EASE_OUT) {
	this.setTrans(trans.id)
	this.setEase(ease.id)
}