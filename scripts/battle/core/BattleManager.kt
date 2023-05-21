package battle.core

import battle.entity.AbstractEntity
import battle.entity.AbstractEntityNode
import battle.entity.enemy.AbstractEnemy
import battle.entity.enemy.AbstractEnemyNode
import battle.entity.character.AbstractCharacter
import battle.entity.character.AbstractCharacterNode

/**
 * Internally computes and manages everything related to the battle. Including stats calculations,
 * move validations, and makes inquiry calls to a delegated external class that handles the enemy AI.
 * This class is self-encapsulated and *mostly* decoupled from the rest of the game.
 *
 * @see BattleScene
 */
internal class BattleManager(
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
    internal fun queuePlayerAction(actor: AbstractCharacter<*>, action: Action) {
        if (actor != action.actor) throw IllegalArgumentException("Invalid action: actor doesn't match action's data")
        if (!actor.playerSide) throw IllegalArgumentException("Invalid action: actor not on player side.")

        playerActions[actor] = action
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
