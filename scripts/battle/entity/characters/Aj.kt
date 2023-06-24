package battle.entity.characters

import battle.core.Action
import battle.core.BattleManager
import battle.entity.Vulnerable
import battle.entity.characternodes.AjNode
import battle.entity.enemy.AbstractEnemy
import battle.entity.enemy.AbstractEnemyNode
import core.PlayerCharacter
import kotlin.random.Random

/**
 * AYYYYYYYY ABEBARIBA
 */
internal class Aj : AbstractCharacter<AjNode>(PlayerCharacter.AJ, AjNode()) {
	override fun offenseAction(action: Action, battleState: BattleManager) {
		action.target as AbstractEnemy<out AbstractEnemyNode>
		action.target as Vulnerable

		action.target.sustainDamage(this.power * Random.nextDouble(0.9, 1.1))
	}
}

