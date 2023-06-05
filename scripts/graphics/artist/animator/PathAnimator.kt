package graphics.artist.animator

import godot.core.Vector2
import graphics.artist.Artist2D

internal class PathAnimator(
	artist: Artist2D,
	numFrames: Int,
	private val points: List<Vector2>
) : Animator2D(artist, numFrames) {
	override fun redraw() {
		super.redraw()

		artist.drawPath(
			points = points,
			stopIndex = points.size * elapsedFrames / numFrames
		)

		if (elapsedFrames >= numFrames) super.complete = true
	}
}