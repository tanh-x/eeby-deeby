package game

import godot.Camera2D
import godot.Node2D
import godot.annotation.RegisterClass
import godot.annotation.RegisterFunction
import utils.Constants.PLAYER_REF_PATH
import utils.helpers.node

@RegisterClass
class SmoothCamera : Camera2D() {
	private lateinit var target: Node2D

	@RegisterFunction
	override fun _ready() {
		target = node(PLAYER_REF_PATH)
	}

	@RegisterFunction
	override fun _physicsProcess(delta: Double) {
		position = position.linearInterpolate(target.position, INTERP_FACTOR)
		forceUpdateScroll()
	}

	companion object {
		const val INTERP_FACTOR: Double = 0.082
	}
}
