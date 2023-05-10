package battle

import EngineSingletons.singleton
import battle.entity.AbstractEntity
import battle.entity.AbstractEntityNode
import battle.entity.character.AbstractCharacter
import battle.entity.character.AbstractCharacterNode
import battle.entity.character.Aj
import battle.entity.enemy.AbstractEnemy
import battle.entity.enemy.EnemiesEnum
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

	internal var params: BattleParams? = null

	private lateinit var manager: BattleManager

	private val characters: LinkedHashSet<AbstractCharacter<out AbstractCharacterNode>> = linkedSetOf()

	private val opponents: LinkedHashSet<AbstractEntity<out AbstractEntityNode>> = linkedSetOf()

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
		// Constant to shadow the instance variable to prevent any trouble from multiple threads
		val params: BattleParams = this.params ?: throw NullPointerException("Battle parameters was not instantiated")

		params.characters.toSet().forEach { characterID: Int ->
			val character: AbstractCharacter<*> = when (characterID) {
				0    -> Aj()
				else -> throw IllegalArgumentException("Illegal argument: $characterID does not match with any character")
			}
			characters.add(character)
			addChild(character.node)
		}

//		params.opponents.forEach { enemyID: Int ->
//			val opponent: AbstractEnemy<*> = EnemiesEnum[enemyID].instantiate()
//		}

		// We are complete with the initialization.
		manager = BattleManager()

		// Start the timer for the animation
		initialTimer.start()

		// Reset the battle parameters back to null to prevent it from interfering with other things
		this.params = null
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