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
			waitTime = 1.5
			oneShot = true
			autostart = true
		})
	}

	@RegisterFunction
	fun destructSelf() {
		queueFree()
	}
}
