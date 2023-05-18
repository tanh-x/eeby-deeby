package battle

import EngineSingletons.singleton
import battle.entity.AbstractEntityNode
import battle.entity.Vulnerable
import battle.entity.enemy.AbstractEnemy
import battle.entity.enemy.AbstractEnemyNode
import battle.entity.enemy.EnemiesEnum
import character.AbstractCharacter
import character.AbstractCharacterNode
import character.MemberCharacter
import game.GameManager
import godot.Node2D
import godot.Timer
import godot.annotation.RegisterClass
import godot.annotation.RegisterFunction
import godot.core.Vector2
import graphics.BattleCamera
import ui.PrimaryUI
import utils.helpers.node
import utils.helpers.toScreenSpace

/**
 * Handles the graphical aspect and communication with the engine for battles. The relevant calculations
 * and functionality of the battle is delegated to a [BattleManager] object (this also helps with building
 * the solver engine later on)
 */
@RegisterClass
class BattleScene : Node2D() {
	private lateinit var gameManager: GameManager

	private lateinit var camera: BattleCamera

	internal lateinit var ui: PrimaryUI

	internal var params: BattleParams? = null

	private lateinit var manager: BattleManager

	internal val characters: LinkedHashSet<AbstractCharacter<out AbstractCharacterNode>> = linkedSetOf()

	internal val enemies: LinkedHashSet<AbstractEnemy<out AbstractEnemyNode>> = linkedSetOf()

	private val initialTimer: Timer = Timer().apply {
		connect("timeout", this@BattleScene, "play_starting_animation")
		waitTime = 0.5
		oneShot = true
		autostart = false
	}

	init {
		System.gc()
	}

	@RegisterFunction
	override fun _ready() {
		gameManager = singleton("GameManager")
		params = gameManager.battleParams
		camera = node("BattleCamera")
		ui = node("CanvasLayer/PrimaryUI")
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
			MemberCharacter[characterID].instantiate().also { character: AbstractCharacter<out AbstractCharacterNode> ->
				// Add the child to the scene immediately so _ready() is called before we adjust the node
				addChild(character.node)

				// Modify the scale and position of the character and distribute them to equally spaced positions
				with(character.node) {
					sprite.scale = DEFAULT_CHARACTER_SCALE
					position = characterPlacements[characterIDs.size][idx].toScreenSpace()
				}
			}
//			characters.add(when (characterID) {
//				1 -> Aj()
//				3 -> Peek()
//				5 -> Jad()
//				6 -> Kew()
//				7 -> Wiewior()
//				9 -> Dogman()
//				else ->
////				else -> throw IllegalArgumentException("Illegal argument: $characterID does not match with any character")
//			}
		}

		params.opponents.forEach { enemyID: Int ->
			val e: EnemiesEnum = EnemiesEnum[enemyID]
			val ent: AbstractEnemy<out AbstractEnemyNode> = e.instantiate()
			enemies.add(ent)
			addChild(ent.node)

			// Does whatever operation needed after initialization
			e.applyOnInit(ent)
		}

		distributePlacement(enemies.map { it.node })

		// Add everything as a child of the scene.
		// Comment out cause already done this in @forEachIndexed/@AbstractCharacter<*>.also lambda above
//		characters.forEach { ent -> addChild(ent.node) }
//		opponents.forEach { ent -> addChild(ent.node) }

		characters.forEach { ent -> ent.node.overlay.attachEntity(ent) }
		enemies.forEach { ent -> if (ent is Vulnerable) ent.node.overlay.attachEntity(ent) }


		// We are complete with the initialization.
		manager = BattleManager()

		// Reset the battle parameters back to null to prevent it from interfering with other things
		this.params = null

		// Start the timer for the animation
		initialTimer.start()
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

	private fun distributePlacement(ents: List<AbstractEntityNode>) {
		ents.forEach { n: AbstractEntityNode ->
			n.position = Vector2(0.21, 0.2).toScreenSpace()
		}
	}


	companion object {
		@JvmStatic
		val DEFAULT_CHARACTER_SCALE: Vector2 = Vector2(0.285, 0.285)

		@JvmStatic
		val characterPlacements: Array<Array<Vector2>> = arrayOf(
			/* For 0 characters:*/ arrayOf(),
			/* 1: */ arrayOf(Vector2(-0.22, 0.2)),
			/* 2: */ arrayOf(Vector2(-0.18, 0.1), Vector2(-0.26, 0.3)),
			/* 3: */ arrayOf(Vector2(-0.17, 0.08), Vector2(-0.27, 0.2), Vector2(-0.195, 0.33))
		)
	}
}