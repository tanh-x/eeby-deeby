package battle.ai

import battle.core.Action
import battle.entity.Active

internal sealed interface DecisionMaker {
	fun decide(state: BattleState): Map<Active, Action>
}