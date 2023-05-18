package graphics

import godot.Camera2D
import godot.Node2D
import godot.annotation.RegisterClass
import godot.annotation.RegisterFunction
import godot.core.Vector2

/**
 * Custom camera that smoothly interpolates to a target position and zoom
 */
@RegisterClass
open class SmoothCamera : Camera2D() {
	protected var target: Node2D? = null
	internal var targetZoom: Vector2 = Vector2.ONE

	@RegisterFunction
	override fun _physicsProcess(delta: Double) {
		zoom = zoom.linearInterpolate(targetZoom, ZOOM_INTERP_FACTOR)
		target?.run {
			position = position.linearInterpolate(position, INTERP_FACTOR)
			forceUpdateScroll()
		}
	}

	companion object {
		/**
		 * The interpolation factor for moving to a target position. The difference curve with respect
		 * to time will decay at most as fast as the function exp(-at), where "a" is the factor.
		 */
		const val INTERP_FACTOR: Double = 0.082

		/**
		 * Same as above, but for zooming.
		 */
		const val ZOOM_INTERP_FACTOR: Double = 0.100
	}
}
