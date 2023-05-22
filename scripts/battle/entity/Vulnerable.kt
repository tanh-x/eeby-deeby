package battle.entity

internal interface Vulnerable {
    var maxHealth: Double
    var health: Double
    var maxShield: Double
    var shield: Double

    fun sustainDamage(damage: Double): Double {
        var actualDamage: Double = damage
        if (shield > 0) {
            actualDamage = damage.coerceAtMost(shield)
            shield -= actualDamage
        } else {
            health -= actualDamage
        }

        return actualDamage
    }
}