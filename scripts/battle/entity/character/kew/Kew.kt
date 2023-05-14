package battle.entity.character.kew

import battle.entity.character.AbstractCharacter

/**
 *
 */
class Kew : AbstractCharacter<KewNode>(KewNode()) {
	init {
		maxHealth = 33.0
		health = 33.0
		maxShield = 17.0
		shield = 17.0
	}

	override fun sustainDamage(damage: Double): Double {
		return super.sustainDamage(damage)
	}
}
