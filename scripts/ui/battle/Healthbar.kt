package ui.battle

import battle.entity.Vulnerable
import godot.ColorRect
import godot.Control
import godot.ReferenceRect
import godot.annotation.RegisterClass
import godot.annotation.RegisterFunction
import godot.core.NodePath
import utils.helpers.*
import utils.helpers.math.ramp

@RegisterClass
class Healthbar : Control() {
	internal lateinit var entity: Vulnerable
	private lateinit var barRect: ColorRect
	private lateinit var healthRect: ColorRect
	private lateinit var damageRect: ColorRect
	private lateinit var healRect: ColorRect
	private lateinit var shieldRect: ReferenceRect

	private var healthBarWidth: Double = 0.0
	private var currentWidth: Double = 0.0

	@RegisterFunction
	override fun _ready() {
		barRect = node("BarColorRect")
		healthRect = barRect.node("HealthColorRect")
		damageRect = barRect.node("DamageColorRect")
		shieldRect = barRect.node("ShieldRect")
		healRect = healthRect.node("HealColorRect")

		healthBarWidth = barRect.rectSize.x
		currentWidth = 0.0
		healthRect["margin_right"] = currentWidth
		damageRect["margin_right"] = currentWidth
		shieldRect["margin_right"] = currentWidth
		healRect["margin_left"] = 0.0
	}

	@RegisterFunction
	fun rerender() {
		val newWidth: Double = ramp(entity.health / entity.maxHealth * healthBarWidth)

		healthRect["margin_right"] = newWidth

		if (newWidth <= currentWidth) {
			damageRect["margin_right"] = currentWidth
			sceneTreeTweener().tweenProperty(
				_object = damageRect,
				property = NodePath("margin_right"),
				finalVal = newWidth,
				duration = DFLT_ANIM_DURATION
			)?.setCurve()
		} else {
			damageRect["margin_right"] = newWidth
			healRect["margin_left"] = currentWidth - newWidth
			sceneTreeTweener().tweenProperty(
				_object = healRect,
				property = NodePath("margin_left"),
				finalVal = 0.0,
				duration = DFLT_ANIM_DURATION
			)?.setCurve()
		}

		val shieldWidth: Double = ramp(entity.shield / entity.maxShield * healthBarWidth)
		sceneTreeTweener().tweenProperty(
			_object = shieldRect,
			property = NodePath("margin_right"),
			finalVal = shieldWidth,
			duration = DFLT_ANIM_DURATION
		)?.setCurve()
		if (shieldWidth <= 0) {
			sceneTreeTweener().tweenProperty(
				_object = shieldRect,
				property = NodePath("self_modulate"),
				finalVal = 0L.rgba(),
				duration = DFLT_ANIM_DURATION
			)
		}


		currentWidth = newWidth
	}

	companion object {
		const val DFLT_ANIM_DURATION: Double = 1.3333
	}
}
