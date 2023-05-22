package battle.entity.enemy

import battle.entity.Active
import battle.entity.Vulnerable

class BasicEnemy(
	entityName: String,
	override var maxHealth: Double,
	override var maxShield: Double,
	override var power: Double,
	override var agility: Double,
) : AbstractEnemy<BasicEnemyNode>(BasicEnemyNode(entityName)),
	Vulnerable, Active {
	override var health: Double = maxHealth
	override var shield: Double = maxShield
	override var isDisabled: Boolean = false

	init {
		println("Created opponent: $entityName")
	}

	override fun sustainDamage(damage: Double): Double {
		return super.sustainDamage(damage).also { node.overlay.spawnDamageNumber(it) }
	}
}