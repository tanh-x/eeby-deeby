package battle.entity.character.peek

import battle.entity.character.AbstractCharacter

/**
 *
 */
class Peek : AbstractCharacter<PeekNode>(PeekNode()) {
	init {
		maxHealth = 62.0
		health = 62.0
		maxShield = 17.0
		shield = 17.0
	}

	override fun sustainDamage(damage: Double): Double {
		return super.sustainDamage(damage)
	}
}