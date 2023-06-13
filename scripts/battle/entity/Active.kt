package battle.entity

import battle.core.Action
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


	fun psionicAction(action: Action, battleState: BattleManager) {}
	fun specialAction(action: Action, battleState: BattleManager) {}
}