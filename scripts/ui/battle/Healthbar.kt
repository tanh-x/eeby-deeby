package ui.battle

import battle.entity.Vulnerable
import godot.ColorRect
import godot.Control
import godot.PropertyTweener
import godot.Tween
import godot.annotation.RegisterClass
import godot.annotation.RegisterFunction
import godot.core.NodePath
import utils.helpers.SceneTreeTweener
import utils.helpers.node
import utils.helpers.set

@RegisterClass
class Healthbar : Control() {
	internal lateinit var entity: Vulnerable
	private lateinit var barRect: ColorRect
	private lateinit var healthRect: ColorRect
	private lateinit var damageRect: ColorRect
	private lateinit var healRect: ColorRect

	private var healthBarWidth: Double = 0.0
	private var currentWidth: Double = 0.0

	@RegisterFunction
	override fun _ready() {
		barRect = node("BarColorRect")
		healthRect = barRect.node("HealthColorRect")
		damageRect = barRect.node("DamageColorRect")
		healRect = healthRect.node("HealColorRect")

		healthBarWidth = barRect.rectSize.x
		currentWidth = 0.0
		healthRect["margin_right"] = currentWidth
		damageRect["margin_right"] = currentWidth
		healRect["margin_left"] = 0.0
	}

	@RegisterFunction
	fun rerender() {
		val newWidth: Double = (entity.health / entity.maxHealth * healthBarWidth).coerceAtLeast(0.0)

		healthRect["margin_right"] = newWidth

		val tweener: PropertyTweener? = if (newWidth <= currentWidth) {
			damageRect["margin_right"] = currentWidth
			SceneTreeTweener().tweenProperty(
				_object = damageRect,
				property = NodePath("margin_right"),
				finalVal = newWidth,
				duration = 1.0
			)
		} else {
			damageRect["margin_right"] = newWidth
			healRect["margin_left"] = currentWidth - newWidth
			SceneTreeTweener().tweenProperty(
				_object = healRect,
				property = NodePath("margin_left"),
				finalVal = 0,
				duration = 1.0
			)
		}

		tweener?.setTrans(Tween.TransitionType.TRANS_CUBIC.id)
		tweener?.setEase(Tween.EaseType.EASE_OUT.id)

		currentWidth = newWidth
	}
}
