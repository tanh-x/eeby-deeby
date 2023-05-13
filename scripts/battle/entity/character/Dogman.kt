package battle.entity.character

class Dogman : AbstractCharacter<DogmanNode>(DogmanNode()) {
	override var maxHealth: Int = 36
	override var health: Int = 36
	override var maxShield: Int = 15
	override var shield: Int = 15

	override fun sustainDamage(damage: Double): Double {
		TODO("Not yet implemented")
	}
}