package graphics.artist.animator

import godot.Tween.EaseType
import godot.Tween.TransitionType
import godot.core.Vector2
import graphics.artist.Artist2D
import utils.helpers.math.QuadraticBezier

internal sealed class Animator2D protected constructor(
	internal val artist: Artist2D,
	internal val numFrames: Int
) {
	var complete: Boolean = false
		protected set(value) {
			field = field || value
		}

	protected var elapsedFrames: Int = 0
		private set

	protected var easeFunction: EaseType = EaseType.EASE_OUT
		private set

	protected var transitionFunction: TransitionType = TransitionType.TRANS_LINEAR
		private set

	internal open fun redraw() {
		if (!complete) elapsedFrames++
	}

	companion object {
		@JvmStatic
		internal fun <T : Animator2D> T.easing(ease: EaseType): T = apply {
			this.easeFunction = ease
		}

		@JvmStatic
		internal fun <T : Animator2D> T.transition(trans: TransitionType): T = apply {
			this.transitionFunction = trans
		}

		@JvmStatic
		internal fun animatePath(
			artist: Artist2D,
			numFrames: Int,
			points: List<Vector2>,
		): Animator2D = PathAnimator(artist, numFrames, points)

		@JvmStatic
		internal fun animateQuadraticBezier(
			artist: Artist2D,
			numFrames: Int,
			from: Vector2,
			to: Vector2,
			controlPoint: Vector2,
			numPoints: Int
		): Animator2D = animatePath(
			artist, numFrames,
			points = QuadraticBezier(from, to, controlPoint, numPoints)
		)
	}
}

