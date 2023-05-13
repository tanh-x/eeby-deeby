package battle.entity

internal interface Vulnerable {
	var maxHealth: Int
	var health: Int
	var maxShield: Int
	var shield: Int

	fun sustainDamage(damage: Double): Double
}