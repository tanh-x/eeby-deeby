package battle.entity.character.dogman

import battle.entity.character.AbstractCharacter

class Dogman : AbstractCharacter<DogmanNode>(DogmanNode()) {
	override var maxHealth: Double = 36.0
	override var health: Double = 36.0
	override var maxShield: Double = 15.0
	override var shield: Double = 15.0

	override fun sustainDamage(damage: Double): Double {
		TODO("Not yet implemented")
	}
}