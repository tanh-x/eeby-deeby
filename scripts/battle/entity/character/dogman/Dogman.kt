package battle.entity.character.dogman

import battle.entity.character.AbstractCharacter

/**
 *
 */
class Dogman : AbstractCharacter<DogmanNode>(DogmanNode()) {
	init {
		maxHealth = 36.0
		health = 36.0
		maxShield = 15.0
		shield = 15.0
	}

	override fun sustainDamage(damage: Double): Double {
		TODO("Not yet implemented")
	}
}