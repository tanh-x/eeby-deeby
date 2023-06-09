package battle.entity.enemy

import battle.core.Action
import battle.core.BattleManager
import battle.entity.Active
import battle.entity.Vulnerable
import utils.helpers.math.ramp

internal class BasicEnemy(
	entityName: String,
	override var maxHealth: Double,
	override var maxShield: Double,
	override var power: Double,
	override var agility: Double,
) : AbstractEnemy<BasicEnemyNode>(BasicEnemyNode(entityName)),
	Vulnerable, Active {
	override var health: Double = maxHealth
		set(value) {
			field = ramp(value)
			node.overlay.updateAll()
		}

	override var shield: Double = maxShield
		set(value) {
			field = ramp(value)
			node.overlay.updateAll()
		}

	override var isDisabled: Boolean = false

	init {
		println("Created opponent: $entityName")
	}

	override fun sustainDamage(damage: Double): Double {
		return super.sustainDamage(damage).also {
			node.overlay.spawnDamageNumber(it)
			println("$this took $it damage")
		}
	}

	override fun offenseAction(action: Action, battleState: BattleManager) {
		action.target as Vulnerable
		action.target.sustainDamage(power)
	}
}