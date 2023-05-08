package battle

import EngineSingletons.singleton
import battle.entity.AbstractEntity
import battle.entity.AbstractEntityNode
import battle.entity.Entity
import game.GameManager
import godot.Node2D
import godot.Timer
import godot.annotation.RegisterClass
import godot.annotation.RegisterFunction
import graphics.BattleCamera
import utils.helpers.node

/**
 * Handles the graphical aspect and communication with the engine for battles. The relevant calculations
 * and functionality of the battle is delegated to a [BattleManager] object (this also helps with building
 * the solver engine later on)
 */
@RegisterClass
class BattleScene() : Node2D() {
	private lateinit var gameManager: GameManager

	private lateinit var camera: BattleCamera

	internal lateinit var params: BattleParams

	private lateinit var manager: BattleManager

	private val characters: HashMap<Entity<out AbstractEntityNode>, Node2D> = hashMapOf()

	private val opponents: HashMap<AbstractEntity<out AbstractEntityNode>, Node2D> = hashMapOf()

	private val initialTimer: Timer = Timer().apply {
		connect("timeout", this@BattleScene, "play_starting_animation")
		waitTime = 1.0
		oneShot = true
		autostart = false
	}

	@RegisterFunction
	override fun _ready() {
		this.gameManager = singleton("GameManager")
		this.params = gameManager.battleParams
		this.camera = node("BattleCamera")
		addChild(initialTimer)

		generateBattle()
	}

	/**
	 * Generates the battle based on the [params] instance variable. Will start a timer to call
	 * [playStartingAnimation] after a certain amount of time upon completion
	 */
	private fun generateBattle() {

		// We are complete with the initialization.
		manager = BattleManager(

		)
		// Start the timer for the animation
		initialTimer.start()
	}

	/**
	 * Does everything needed to indicate the start of the battle. Also enables controls to the player.
	 */
	@RegisterFunction
	fun playStartingAnimation() {
		camera.playStartingAnimation()
		initialTimer.queueFree()
	}
}