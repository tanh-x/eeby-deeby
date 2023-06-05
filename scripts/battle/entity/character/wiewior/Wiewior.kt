package battle.entity.character.wiewior

import battle.core.Action
import battle.core.BattleManager
import battle.entity.Vulnerable
import battle.entity.character.AbstractCharacter
import battle.entity.enemy.AbstractEnemy
import battle.entity.enemy.AbstractEnemyNode
import core.MemberCharacter
import kotlin.random.Random

/**
 *
 */
internal class Wiewior : AbstractCharacter<WiewiorNode>(MemberCharacter.WIEWIOR, WiewiorNode()) {
	override fun offenseAction(action: Action, battleState: BattleManager) {
		action.target as AbstractEnemy<out AbstractEnemyNode>
		action.target as Vulnerable

		action.target.sustainDamage(this.power * Random.nextDouble(0.9, 1.1))
	}
}