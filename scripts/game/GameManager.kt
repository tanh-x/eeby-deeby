package game

import battle.BattleParams
import battle.BattleScene
import godot.Node
import godot.Viewport
import godot.annotation.RegisterClass
import godot.annotation.RegisterFunction
import godot.global.GD
import utils.helpers.instantiateScene

@RegisterClass
class GameManager : Node() {
	private lateinit var currentScene: Node

	private lateinit var root: Viewport

	/**
	 * For communication with [BattleScene]
	 */
	internal lateinit var battleParams: BattleParams

	@RegisterFunction
	override fun _ready() {
		root = getTree()!!.root ?: throw UnknownError("Root not found")

		currentScene = root.getChild(root.getChildCount() - 1) ?: throw NullPointerException("Root has no children")
		initialPrint()
	}

	@RegisterFunction
	override fun _process(delta: Double) {

	}

	@RegisterFunction
	override fun _physicsProcess(delta: Double) {

	}

	fun switchToBattle(battleParams: BattleParams) {
		this.battleParams = battleParams
		if (currentScene.name != "Main") throw IllegalStateException("Invalid call source")  // TODO: Dangerous
		callDeferred("initialize_battle_scene")
	}

	@RegisterFunction
	fun initializeBattleScene() {
		currentScene.free()
		currentScene = instantiateScene<BattleScene>("res://scenes/core/BattleScene.tscn")
		root.addChild(currentScene)
		getTree()?.currentScene = currentScene
	}

	@RegisterFunction
	fun switchSceneSafely(path: String): Unit = callDeferred("switch_scene", path)

	@RegisterFunction
	fun switchScene(path: String) {
		currentScene.free()
		currentScene = instantiateScene(path)
		root.addChild(currentScene)
		getTree()?.currentScene = currentScene
	}

	companion object {
		@JvmStatic
		private fun initialPrint() {
			val status: String = if (godot.OS.isDebugBuild()) " [-] DEVELOPMENT" else " [-] PRODUCTION    "
			GD.print(
				"┌───────────────────┬────────────────────┐\n" +
				"│ EEBY DEEBY v0.0   │${status.padEnd(20)}│\n" +
				"├───────────────────┴────────────────────┤\n" +
				"│ Global game manager instantiated       │\n" +
				"└────────────────────────────────────────┘"
			)
		}
	}
}