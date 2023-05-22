package battle.entity.enemy

import battle.entity.Vulnerable

class BasicEnemy(
    entityName: String,
    override var maxHealth: Double,
    override var maxShield: Double,
) : AbstractEnemy<BasicEnemyNode>(BasicEnemyNode(entityName)), Vulnerable {
    override var health: Double = maxHealth
    override var shield: Double = maxShield

    init {
        println("Created opponent: $entityName")
    }

    override fun sustainDamage(damage: Double): Double {
        return super.sustainDamage(damage).also { node.overlay.spawnDamageNumber(it) }
    }
}