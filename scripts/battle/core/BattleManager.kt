package battle.core

import battle.entity.character.AbstractCharacter
import battle.entity.character.AbstractCharacterNode
import battle.entity.enemy.AbstractEnemy
import battle.entity.enemy.AbstractEnemyNode

/**
 * Internally computes and manages everything related to the battle. Including stats calculations,
 * move validations, and makes inquiry calls to a delegated external class that handles the enemy AI.
 * This class is self-encapsulated and *mostly* decoupled from the rest of the game.
 *
 * @see BattleScene
 */
internal class BattleManager internal constructor(
	private val scene: BattleScene,
	private val characters: LinkedHashMap<Int, AbstractCharacter<out AbstractCharacterNode>>,
	private val enemies: LinkedHashMap<Int, AbstractEnemy<out AbstractEnemyNode>>,
) {
	internal val playerActions: LinkedHashMap<AbstractCharacter<out AbstractCharacterNode>, Action> = LinkedHashMap()
	internal val enemyActions: LinkedHashMap<AbstractEnemy<out AbstractEnemyNode>, Action> = LinkedHashMap()

	/**
	 * Adds an action into the queue
	 *
	 * @throws IllegalArgumentException If the action was invalid
	 */
	internal fun addPlayerAction(action: Action) {
		if (action.actor !is AbstractCharacter<*>) throw IllegalArgumentException("Invalid action: actor is not a character")
		if (!action.actor.playerSide) throw IllegalArgumentException("Invalid action: actor not on player side.")

		playerActions[action.actor] = action
		println("Enqueued new player action: $action")
	}

	internal fun addEnemyAction(action: Action) {
		println("Enqueued new enemy action: $action")
	}

	/**
	 * Happens when the player clicks on "Ready" to indicate that they have already carried out all
	 * the actions they want to happen during the turn. The method will be called by [BattleScene]
	 * upon this happening, and will use the already computed (independent of player actions) enemy
	 * actions to calculate the outcome of this turn.
	 */
	internal fun computeTurn() {

	}
}
