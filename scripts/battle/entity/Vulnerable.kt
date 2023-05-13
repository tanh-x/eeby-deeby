package battle.entity

internal interface Vulnerable {
	var maxHealth: Double
	var health: Double
	var maxShield: Double
	var shield: Double

	fun sustainDamage(damage: Double): Double
}