package battle.entity

import battle.core.Action
import battle.core.ActionType
import battle.core.BattleManager

internal interface Active {
	var power: Double
	var agility: Double
	var isDisabled: Boolean

	fun selfAction(action: Action, battleState: BattleManager) {}

	fun offenseAction(action: Action, battleState: BattleManager) {
		action.target as Vulnerable

		action.target.sustainDamage(this.power)
	}

	fun supportAction(action: Action, battleState: BattleManager) {}

	fun specialAction(action: Action, battleState: BattleManager) {}

	fun dispatchAction(action: Action, battleState: BattleManager) {
		when (action.type) {
			ActionType.SELF    -> selfAction(action, battleState)
			ActionType.OFFENSE -> offenseAction(action, battleState)
			ActionType.SUPPORT -> supportAction(action, battleState)
			ActionType.SPECIAL -> specialAction(action, battleState)
		}
	}
}