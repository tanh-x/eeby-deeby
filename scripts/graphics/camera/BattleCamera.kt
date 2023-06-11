package graphics.camera

import godot.GlobalConstants.BUTTON_WHEEL_DOWN
import godot.GlobalConstants.BUTTON_WHEEL_UP
import godot.InputEvent
import godot.InputEventMouseButton
import godot.Viewport
import godot.annotation.RegisterClass
import godot.annotation.RegisterFunction
import godot.core.Vector2
import utils.helpers.toScreenSpace
import kotlin.math.pow

/**
 * Custom camera for [battle.BattleScene]
 */
@RegisterClass
class BattleCamera : SmoothCamera() {
	private val windowCenter: Vector2 = Vector2(0.5, 0.55).toScreenSpace()
	private lateinit var viewport: Viewport

	@RegisterFunction
	override fun _ready() {
		super._ready()
		viewport = getViewport()!!

		zoom = Vector2.ONE * 2.75
		targetZoom = zoom
	}

	@RegisterFunction
	override fun _physicsProcess(delta: Double) {
		super._physicsProcess(delta)

		targetPosition = viewport.getMousePosition().linearInterpolate(
			v = windowCenter,
			t = 1 - CAMERA_FOLLOW_FACTOR - 0.005 * targetZoom.x.pow(-4.25)
		)
	}

	@RegisterFunction
	override fun _input(event: InputEvent) {
		if (event !is InputEventMouseButton) return
		val newZoom: Double = (targetZoom.x + when (event.buttonIndex) {
			BUTTON_WHEEL_UP   -> -1.0
			BUTTON_WHEEL_DOWN -> 1.0
			else              -> 0.0
		} * ZOOM_INCREMENT).coerceIn(MIN_ZOOM, MAX_ZOOM)

		targetZoom.x = newZoom
		targetZoom.y = newZoom
	}

	internal fun playStartingAnimation() {
		targetZoom = Vector2(DFLT_ZOOM_FACTOR, DFLT_ZOOM_FACTOR)
	}

	companion object {
		const val DFLT_ZOOM_FACTOR: Double = 0.8333
		const val CAMERA_FOLLOW_FACTOR: Double = 0.004
		const val ZOOM_INCREMENT: Double = 0.015
		const val MAX_ZOOM: Double = 2.0
		const val MIN_ZOOM: Double = 0.5
	}
}
