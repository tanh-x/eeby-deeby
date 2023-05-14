package ui.battle

import battle.entity.Vulnerable
import godot.ColorRect
import godot.Control
import godot.PropertyTweener
import godot.Tween
import godot.annotation.RegisterClass
import godot.annotation.RegisterFunction
import godot.core.NodePath
import utils.helpers.node

@RegisterClass
class Healthbar : Control() {
	internal lateinit var entity: Vulnerable
	private lateinit var barRect: ColorRect
	private lateinit var healthRect: ColorRect
	private var healthBarWidth: Int = 0

	@RegisterFunction
	override fun _ready() {
		barRect = node("BarColorRect")
		healthRect = barRect.node("HealthColorRect")
		healthBarWidth = barRect.rectSize.x.toInt()
	}

	@RegisterFunction
	fun rerender() {
		println(entity.health)
		getTree()?.createTween()!!.tweenProperty(
			_object = healthRect,
			property = NodePath("margin_right"),
			finalVal = entity.health / entity.maxHealth * healthBarWidth,

			duration = 1.0
		)?.let { tweener: PropertyTweener ->
			tweener.setTrans(Tween.TransitionType.TRANS_CUBIC.id)
			tweener.setEase(Tween.EaseType.EASE_OUT.id)
		}
	}
}