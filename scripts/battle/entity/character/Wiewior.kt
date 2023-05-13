package battle.entity.character

class Wiewior: AbstractCharacter<WiewiorNode>(WiewiorNode()) {
	override var maxHealth: Int = 40
	override var health: Int = 40
	override var maxShield: Int = 10
	override var shield: Int = 10

	override fun sustainDamage(damage: Double): Double {
		TODO("Not yet implemented")
	}
}