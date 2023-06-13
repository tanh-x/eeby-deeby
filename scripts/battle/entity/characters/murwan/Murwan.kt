package battle.entity.characters.murwan

import battle.core.Action
import battle.core.BattleManager
import battle.entity.Vulnerable
import battle.entity.characters.AbstractCharacter
import battle.entity.enemy.AbstractEnemy
import battle.entity.enemy.AbstractEnemyNode
import core.PlayerCharacter

internal class Murwan : AbstractCharacter<MurwanNode>(PlayerCharacter.MURWAN, MurwanNode()) {
	override fun offenseAction(action: Action, battleState: BattleManager) {
		action.target as AbstractEnemy<out AbstractEnemyNode>
		action.target as Vulnerable
	}
}