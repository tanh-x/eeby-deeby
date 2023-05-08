package battle.entity

enum class EnemiesEnum(
	val maxHealth: Double,
	val baseDamage: Double,
	val baseDefense: Double,
) {
	GRAPEMAN(
		maxHealth = 50.0,
		baseDamage = 4.0,
		baseDefense = 6.0
	)
}