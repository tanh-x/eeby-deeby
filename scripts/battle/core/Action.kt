package battle.core

import battle.card.Card
import battle.entity.AbstractEntity

/**
 * Represents an action that an entity can carry out in one turn. This includes both
 * player actions and calculated enemy actions. Every property of this object is immutable.
 * This will also be the return type of the opponent AI engine.
 *
 * @param actor The entity that carries out this action.
 * @param target The entity that is the target of this action, which can potentially be
 * the ally or even the actor themselves.
 * @param card The [Card] that was used for this action
 * @param type The type of action, which indicates the relation between [actor] and [target]
 *
 * @throws IllegalArgumentException If the arguments given for the action is not valid.
 *
 * @see BattleManager
 */
internal data class Action internal constructor(
    internal val actor: AbstractEntity<*>,
    internal val target: AbstractEntity<*>,
    internal val card: Card = Card.NONE,
    internal val type: ActionType,
) {
    init {
        if (!validateAction()) throw IllegalArgumentException("Instantiated action is not valid")
    }

    /**
     * @return Validates whether this action is valid.
     */
    private fun validateAction(): Boolean {
        // Checks for validating actor/target relationship
        when (type) {
            ActionType.SELF    -> {
                if (actor != target) return false
            }

            ActionType.SUPPORT -> {
                if (actor == target ||
                    actor.playerSide != target.playerSide
                ) return false
            }

            ActionType.OFFENSE -> {
                if (actor == target ||
                    actor.playerSide == target.playerSide
                ) return false
            }

            ActionType.SPECIAL -> {}
        }
        return true
    }
}