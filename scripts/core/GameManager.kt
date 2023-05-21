package core

import battle.BattleParams
import battle.BattleScene
import godot.Node
import godot.Viewport
import godot.annotation.RegisterClass
import godot.annotation.RegisterFunction
import godot.global.GD
import utils.helpers.instantiateScene


/**
 * This global singleton is autoloaded by the Godot engine and is persistent throughout the game.
 * This handles everything that cannot be localized to a node or scene, such as scene switching,
 * and game state persistence.
 */
@RegisterClass
class GameManager : Node() {
    /**
     * The current scene of the game. Is only updated within this class, and thus is not guaranteed to match.
     */
    private lateinit var currentScene: Node

    /**
     * The root of the scene tree.
     */
    internal lateinit var currentRoot: Viewport
        private set

    /**
     * For communication with [BattleScene]
     */
    internal lateinit var battleParams: BattleParams

    /**
     * The method does everything to initialize the game upon load
     */
    @RegisterFunction
    override fun _ready() {
        currentRoot = getTree()!!.root ?: throw UnknownError("Root not found")

        currentScene = currentRoot.getChild(currentRoot.getChildCount() - 1) ?: throw NullPointerException("Root has no children")

        initialPrint()
    }

    /**
     * Not a lot of functionality goes in here, except for certain global keybinds
     */
//	@RegisterFunction
//	override fun _process(delta: Double) {
//
//	}

//	@RegisterFunction
//	override fun _physicsProcess(delta: Double) {
//
//	}

    /**
     * Only from the "Main" scene, the method switches to a battle, specified by the [battleParams] parameter.
     *
     * @param battleParams The parameters to initialize a new battle to. [BattleScene.generateBattle] handles
     * the actual initialization. Is somewhat guaranteed to be a partial function (same inputs of [battleParams]
     * generates more or less the same battle).
     */
    fun switchToBattle(battleParams: BattleParams) {
        this.battleParams = battleParams
        if (currentScene.name != "Main") throw IllegalStateException("Invalid call source")  // TODO: Dangerous
        callDeferred("initialize_battle_scene")  // Deferred call to free the current scene
    }

    /**
     * Frees the current scene, and replace it with the battle scene.
     */
    @RegisterFunction
    fun initializeBattleScene() {
        currentScene.free()
        updateCurrentScene(instantiateScene<BattleScene>("res://scenes/core/BattleScene.tscn"))
    }

    /**
     * Safely switches to another scene by making a deferred call
     *
     * @param path The path of the scene resource to be passed into [instantiateScene]
     */
    @RegisterFunction
    fun switchSceneSafely(path: String): Unit = callDeferred("switch_scene", path)

    /**
     * Starts the operation of switching the scene, by freeing the current one and replacing it anew
     *
     * @param path The path of the scene resource to be passed into [instantiateScene]
     */
    @RegisterFunction
    fun switchScene(path: String) {
        currentScene.free()
        updateCurrentScene(instantiateScene(path))
    }

    private fun updateCurrentScene(newScene: Node) {
        currentScene = newScene
        currentRoot.addChild(newScene)
        getTree()?.currentScene = newScene
    }

    companion object {
        /**
         * Prints to the console the initial report
         */
        @JvmStatic
        private fun initialPrint() {
            GD.print("\n\n\n\n")
            val status: String = if (godot.OS.isDebugBuild()) " [-] DEVELOPMENT" else " [-] PRODUCTION    "
            GD.print(
                "┌──────────────────────┬────────────────────┐\n" +
                        "│ EEBY DEEBY v0.00.06  │ build 2023-05-19   │\n" +
                        "├──────────────────────┴────────────────────┤\n" +
                        "│ ${status.padEnd(20)}                      │\n" +
                        "└───────────────────────────────────────────┘"
            )
        }
    }
}