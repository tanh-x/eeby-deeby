package battle.core

import battle.ai.BattleState
import battle.ai.DecisionEngine
import battle.entity.Active
import battle.entity.characters.AbstractCharacter
import battle.entity.characters.AbstractCharacterNode
import battle.entity.enemy.AbstractEnemy
import battle.entity.enemy.AbstractEnemyNode

/**
 * Internally computes and manages everything related to the battle. Including stats calculations,
 * move validations, and makes inquiry calls to a delegated external class that handles the enemy AI.
 * This class is self-encapsulated and *mostly* decoupled from the rest of the game.
 *
 * @see BattleScene
 */
class BattleManager internal constructor(
	private val scene: BattleScene,
	private val characters: LinkedHashMap<Int, AbstractCharacter<out AbstractCharacterNode>>,
	private val enemies: LinkedHashMap<Int, AbstractEnemy<out AbstractEnemyNode>>,
) {
	private val playerActions: LinkedHashMap<Active, Action> = LinkedHashMap()
	private val enemyActions: LinkedHashMap<Active, Action> = LinkedHashMap()

	/**
	 * Adds an action into the queue. Also creates a graphical indicator corresponding to the action
	 *
	 * @throws IllegalArgumentException If the action was invalid
	 */
	internal fun addPlayerAction(action: Action) {
		if (action.actor !is AbstractCharacter<*>) {
			throw IllegalArgumentException("Invalid action: actor is not a character")
		}

		if (!action.actor.playerSide) {
			throw IllegalArgumentException("Invalid action: actor not on player side.")
		}

		playerActions[action.actor] = action
	}

	internal fun addEnemyAction(action: Action) {
		if (action.actor.playerSide) {
			throw IllegalArgumentException("Invalid action: actor not opponent player side.")
		}
	}

	internal fun computeEnemyDecisions(engine: DecisionEngine) {
		enemyActions.putAll(engine.decide(toStateData()))
	}

	/**
	 * Happens when the player clicks on "Ready" to indicate that they have already carried out all
	 * the actions they want to happen during the turn. The method will be called by [BattleScene]
	 * upon this happening, and will use the already computed (independent of player actions) enemy
	 * actions to calculate the outcome of this turn.
	 */
	internal fun computeTurn() {
		val actions: List<Pair<Active, Action>> = (playerActions + enemyActions)
			.toList()
			.sortedByDescending { pair: Pair<Active, Action> -> pair.first.agility }

		actions.forEach { (actor: Active, action: Action) ->
			when (action.type) {
				ActionType.SELF    -> actor.selfAction(action, this)
				ActionType.OFFENSE -> actor.offenseAction(action, this)
				ActionType.SUPPORT -> actor.supportAction(action, this)
				ActionType.SPECIAL -> actor.specialAction(action, this)
				ActionType.PSIONIC -> actor.psionicAction(action, this)
			}
		}

		playerActions.clear()
		enemyActions.clear()
	}

	private fun toStateData(): BattleState {
		return BattleState(characters.values.toHashSet(), enemies.values.toHashSet())
	}
}
