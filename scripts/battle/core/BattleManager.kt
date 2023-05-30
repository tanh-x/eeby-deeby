package battle.core

import battle.ai.BattleState
import battle.ai.DecisionEngine
import battle.entity.Active
import battle.entity.character.AbstractCharacter
import battle.entity.character.AbstractCharacterNode
import battle.entity.enemy.AbstractEnemy
import battle.entity.enemy.AbstractEnemyNode
import ui.battle.ActionArrow
import utils.helpers.instantiateScene

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

	private val actionArrows: HashMap<Action, ActionArrow> = HashMap()

	/**
	 * Adds an action into the queue. Also creates a graphical indicator corresponding to the action
	 *
	 * @throws IllegalArgumentException If the action was invalid
	 */
	internal fun addPlayerAction(action: Action) {
		if (action.actor !is AbstractCharacter<*>) throw IllegalArgumentException("Invalid action: actor is not a character")
		if (!action.actor.playerSide) throw IllegalArgumentException("Invalid action: actor not on player side.")

		playerActions[action.actor] = action

		val arrow: ActionArrow = instantiateScene<ActionArrow>(
			path = "res://scenes/ui/battle/ActionArrow.tscn"
		).withAction(action)

		actionArrows[action] = arrow
		scene.addChild(arrow)

		println("Enqueued new player action: $action")
	}

	internal fun addEnemyAction(action: Action) {
		println("Enqueued new enemy action: $action")
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

		for ((actor: Active, action: Action) in actions) {
			println("Carrying out: $action")
			if (actor is AbstractCharacter<*>) {
				actor.dispatchAction(action, this)
			} else if (actor is AbstractEnemy<*>) {
				actor.dispatchAction(action, this)
			}
		}

		playerActions.clear()
		enemyActions.clear()
	}

	internal fun toStateData(): BattleState {
		return BattleState(characters.values.toHashSet(), enemies.values.toHashSet())
	}
}
