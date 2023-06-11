package battle.ai

import battle.core.Action
import battle.entity.Active

/**
 * A DecisionEngine is any class that can calculate a decision for each active enemy entity
 */
internal sealed interface DecisionEngine {
	fun decide(state: BattleState): Map<Active, Action>
}