package character.jad

import character.AbstractCharacter

/**
 *
 */
class Jad : AbstractCharacter<JadNode>(JadNode()) {
	init {
		maxHealth = 40.0
		health = 40.0
		maxShield = 12.0
		shield = 12.0
	}

	override fun sustainDamage(damage: Double): Double {
		return super.sustainDamage(damage)
	}
}