package battle

import EngineSingletons.singleton
import battle.entity.AbstractEntity
import battle.entity.AbstractEntityNode
import battle.entity.character.AbstractCharacter
import battle.entity.character.AbstractCharacterNode
import battle.entity.character.Aj
import game.GameManager
import godot.Node2D
import godot.Timer
import godot.annotation.RegisterClass
import godot.annotation.RegisterFunction
import godot.core.Vector2
import graphics.BattleCamera
import utils.helpers.node
import utils.helpers.toScreenSpace

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

		val characterIDs: Collection<Int> = params.characters.toList()
		characterIDs.forEachIndexed { idx: Int, characterID: Int ->
			characters.add(when (characterID) {
				0 -> Aj()
				else -> throw IllegalArgumentException("Illegal argument: $characterID does not match with any character")
			}.also { character: AbstractCharacter<*> ->
				addChild(character.node)  // Add the child to the scene immediately so _ready() is called
				with(character.node.sprite) {
					scale = DEFAULT_CHARACTER_SCALE
					position = characterPlacements[characterIDs.size][idx].toScreenSpace()
				}
			})
		}

//		params.opponents.forEach { enemyID: Int ->
//			val opponent: AbstractEnemy<*> = EnemiesEnum[enemyID].instantiate()
//		}

		// Add everything as a child of the scene.
		// Comment out cause already done this in @forEachIndexed/@AbstractCharacter<*>.also lambda above
//		characters.forEach { ent -> addChild(ent.node) }
//		opponents.forEach { ent -> addChild(ent.node) }


		// We are complete with the initialization.
		manager = BattleManager()

		// Start the timer for the animation
		initialTimer.start()

		// Reset the battle parameters back to null to prevent it from interfering with other things
		this.params = null
	}

	/**
	 * Carries out everything needed to indicate the start of the battle.
	 * Also enables controls to the player.
	 */
	@RegisterFunction
	fun playStartingAnimation() {
		camera.playStartingAnimation()
		initialTimer.queueFree()
	}


	companion object {
		@JvmStatic
		val DEFAULT_CHARACTER_SCALE: Vector2 = Vector2(0.2455, 0.2455)

		@JvmStatic
		val characterPlacements: Array<Array<Vector2>> = arrayOf(
			/* For 0 characters:*/ arrayOf(),
			/* 1: */ arrayOf(Vector2(-0.22, 0)),
			/* 2: */ arrayOf(Vector2(-0.26, 0.1), Vector2(-0.18, -0.1)),
			/* 3: */ arrayOf(Vector2(-0.195, 0.13), Vector2(-0.27, 0.0), Vector2(-0.17, -0.12))
		)
	}
}