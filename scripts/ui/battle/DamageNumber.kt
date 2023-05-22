package ui.battle

import godot.Label
import godot.Timer
import godot.annotation.RegisterClass
import godot.annotation.RegisterFunction

/**
 *
 */
@RegisterClass
class DamageNumber : Label() {
	@RegisterFunction
	override fun _ready() {
		addChild(Timer().apply {
			connect("timeout", this@DamageNumber, "destruct_self")
			waitTime = 2.0
			oneShot = true
			autostart = true
		})
	}

	@RegisterFunction
	fun destructSelf() {
		queueFree()
	}
}
