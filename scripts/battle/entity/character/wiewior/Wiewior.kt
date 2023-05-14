package battle.entity.character.wiewior

import battle.entity.character.AbstractCharacter

/**
 *
 */
class Wiewior : AbstractCharacter<WiewiorNode>(WiewiorNode()) {
	init {
		maxHealth = 40.0
		health = 40.0
		maxShield = 10.0
		shield = 10.0
	}

	override fun sustainDamage(damage: Double): Double {
		TODO("Not yet implemented")
	}
}