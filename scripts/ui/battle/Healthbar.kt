package ui.battle

import battle.entity.Vulnerable
import godot.ColorRect
import godot.Control
import godot.Tween
import godot.annotation.RegisterClass
import godot.annotation.RegisterFunction
import godot.core.NodePath
import godot.core.Vector2
import utils.helpers.get
import utils.helpers.node

@RegisterClass
class Healthbar : Control() {
	internal lateinit var entity: Vulnerable
	private lateinit var barRect: ColorRect
	private lateinit var healthRect: ColorRect

	private lateinit var tween: Tween

	@RegisterFunction
	override fun _ready() {
		barRect = node("BarColorRect")
		healthRect = barRect.node("HealthColorRect")
		tween = healthRect.node("Tween")
	}

	@RegisterFunction
	fun rerender() {
		tween.interpolateProperty(
			_object = healthRect,
			property = NodePath("rect_size"),
			initialVal = healthRect["rect_size"],
			finalVal = Vector2(entity.health / entity.maxHealth * barRect.rectSize.x, barRect.rectSize.y),
			duration = 0.6
		)
	}
}