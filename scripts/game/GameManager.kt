package game

import godot.Node
import godot.annotation.RegisterClass
import godot.annotation.RegisterFunction
import godot.global.GD

@RegisterClass
class GameManager : Node() {
	@RegisterFunction
	override fun _ready() {
		val status: String = if (godot.OS.isDebugBuild()) " [-] DEVELOPMENT" else " [-] PRODUCTION    "
		GD.print(
			"┌───────────────────┬────────────────────┐\n" +
			"│ EEBY DEEBY v0.0   │${status.padEnd(20)}│\n" +
			"├───────────────────┴────────────────────┤\n" +
			"│ Global game manager instantiated       │\n" +
			"└────────────────────────────────────────┘"
		)
	}

	@RegisterFunction
	override fun _process(delta: Double) {

	}

	@RegisterFunction
	override fun _physicsProcess(delta: Double) {

	}
}