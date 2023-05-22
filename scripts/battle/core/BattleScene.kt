package battle.core

import EngineSingletons.getManager
import battle.entity.AbstractEntityNode
import battle.entity.Vulnerable
import battle.entity.character.AbstractCharacter
import battle.entity.character.AbstractCharacterNode
import battle.entity.enemy.AbstractEnemy
import battle.entity.enemy.AbstractEnemyNode
import battle.entity.enemy.EnemiesEnum
import core.MemberCharacter
import godot.Node2D
import godot.Timer
import godot.annotation.RegisterClass
import godot.annotation.RegisterFunction
import godot.core.Vector2
import graphics.camera.BattleCamera
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
	/**
	 * The main camera that runs during a battle
	 */
	private lateinit var camera: BattleCamera

	/**
	 * The UI that is displayed during the battle by default.
	 */
	internal lateinit var ui: PrimaryUI

	/**
	 * The parameter to generate the battle to.
	 * TODO: Refactor this into constructor call and pass as argument to [generateBattle].
	 */
	private var params: BattleParams? = null

	/**
	 * The [BattleManager] object that handles the core gameplay functionality of the battle.
	 */
	private lateinit var manager: BattleManager

	/**
	 * The set of characters present during battle.
	 */
	private val characters: LinkedHashMap<Int, AbstractCharacter<out AbstractCharacterNode>> = LinkedHashMap()
	internal val charactersList: List<AbstractCharacter<out AbstractCharacterNode>>
		get() = characters.values.toList()

	/**
	 * The set of enemies present during battle.
	 */
	private val enemies: LinkedHashMap<Int, AbstractEnemy<out AbstractEnemyNode>> = LinkedHashMap()
	internal val enemiesList: List<AbstractEnemy<out AbstractEnemyNode>>
		get() = enemies.values.toList()

	/**
	 * The timer that runs when the generation is complete
	 */
	private val initialTimer: Timer = Timer().apply {
		connect("timeout", this@BattleScene, "play_starting_animation")
		waitTime = 0.5
		oneShot = true
		autostart = false
	}


	@RegisterFunction
	override fun _ready() {
		// Loads instance variables that holds a godot Node
		params = getManager().battleParams
		camera = node("BattleCamera")
		ui = node("CanvasLayer/PrimaryUI")

		// Adds the timer into the scene. The timer will be started when the generateBattle() call completes
		addChild(initialTimer)

		// Starts the initialization
		generateBattle()

		// We are complete with the initialization.
		manager = BattleManager(this, characters, enemies)

		// Reset the battle parameters back to null to prevent it from interfering with other things
		this.params = null

		// Start the timer for the animation
		initialTimer.start()
	}

	/**
	 * Generates the battle based on the [params] instance variable. Will start a timer to call
	 * [playStartingAnimation] after a certain amount of time upon completion
	 */
	private fun generateBattle() {
		// Constant to shadow the instance variable to use non-null type of mutable variable
		val params: BattleParams = this.params ?: throw NullPointerException("Battle parameters were not instantiated")

		// Create the characters and enemies from the lists of IDs in the given parameter set
		params.characters.map(MemberCharacter::createCharacter).forEach(::addCharacter)
		params.opponents.map(EnemiesEnum::get).forEach(::addEnemy)


		// Carry out initialization operations on the characters
		characters.forEach { (idx: Int, character: AbstractCharacter<out AbstractCharacterNode>) ->
			with(character.node) {
				// Modify the scale and position of the battle.entity.character
				sprite.scale = DEFAULT_CHARACTER_SCALE

				// Distribute them to equally spaced positions according to the number of characters
				position = characterPlacements[characters.size][idx].toScreenSpace()
			}
		}

		// Takes out the list of nodes from the set of enemies, then distribute them.
		distributePlacement(enemies.map { it.value.node })

		characters.forEach { (_: Int, ent: AbstractCharacter<*>) -> ent.node.overlay.attachEntity(ent) }
		enemies.forEach { (_: Int, ent: AbstractEnemy<*>) -> if (ent is Vulnerable) ent.node.overlay.attachEntity(ent) }
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

	private fun addCharacter(character: AbstractCharacter<*>) {
		character.battleId = characters.size

		// This should never happen
		if (character.battleId in characters)
			throw IllegalStateException("Found illegal keys in character map: $characters while adding ${character.battleId}")

		// Add it to the ID LinkedHashMap
		characters[character.battleId] = character

		// Add to scene tree
		addChild(character.node)
	}

	private fun addEnemy(enemyEnum: EnemiesEnum) {
		val enemy: AbstractEnemy<out AbstractEnemyNode> = enemyEnum.instantiate()

		enemy.battleId = enemies.size

		// This should never happen
		if (enemy.battleId in enemies)
			throw IllegalStateException("Found illegal keys in enemy map: $enemies while adding ${enemy.battleId}")

		// Add it to the ID LinkedHashMap
		enemies[enemies.size] = enemy

		// Add to scene tree
		addChild(enemy.node)

		// Does whatever operation needed after initialization
		enemyEnum.applyOnInit(enemy)
	}

	/**
	 * Automatically distributes the placement of enemies so that they are evenly spaced.
	 *
	 * @param ents The list of entities to distribute.
	 */
	private fun distributePlacement(ents: List<AbstractEntityNode>) {
		ents.forEach { n: AbstractEntityNode ->
			n.position = Vector2(0.7, 0.7).toScreenSpace()
		}
	}

	companion object {
		@JvmStatic
		val DEFAULT_CHARACTER_SCALE: Vector2 = Vector2(0.285, 0.285)

		@JvmStatic
		val characterPlacements: Array<Array<Vector2>> = arrayOf(
			/* For 0 characters:*/ arrayOf(),
			/* 1: */ arrayOf(Vector2(0.28, 0.7)),
			/* 2: */ arrayOf(Vector2(0.32, 0.6), Vector2(0.24, 0.8)),
			/* 3: */ arrayOf(Vector2(0.33, 0.58), Vector2(0.23, 0.7), Vector2(0.305, 0.83))
		)
	}
}
