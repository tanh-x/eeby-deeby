package battle.ai

import battle.card.Card
import battle.core.Action
import battle.core.ActionType
import battle.entity.AbstractEntity
import battle.entity.Active
import java.util.Random

internal class RandomDecisionEngine : DecisionEngine {
	val rng: Random = Random()

	override fun decide(state: BattleState): Map<Active, Action> {
		return state.enemies.filterIsInstance<Active>().associateWith { ent ->
			Action(
				actor = ent as AbstractEntity<*>,
				target = state.characters.random() as AbstractEntity<*>,
				card = Card.NONE,
				type = ActionType.OFFENSE
			)
		}
	}
}