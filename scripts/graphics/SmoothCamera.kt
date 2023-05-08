package graphics

import godot.Camera2D
import godot.Node2D
import godot.annotation.RegisterClass
import godot.annotation.RegisterFunction
import godot.core.Vector2
import utils.Constants.PLAYER_REF_PATH
import utils.helpers.math.lerpTo
import utils.helpers.node

@RegisterClass
open class SmoothCamera : Camera2D() {
	protected var target: Node2D? = null
	internal var targetZoom: Vector2 = Vector2.ONE

	@RegisterFunction
	override fun _ready() {

	}

	@RegisterFunction
	override fun _physicsProcess(delta: Double) {
		zoom = zoom.linearInterpolate(targetZoom, ZOOM_INTERP_FACTOR)
		target?.run {
			position = position.linearInterpolate(position, INTERP_FACTOR)
			forceUpdateScroll()
		}
	}

	companion object {
		const val INTERP_FACTOR: Double = 0.082
		const val ZOOM_INTERP_FACTOR: Double = 0.100
	}
}
