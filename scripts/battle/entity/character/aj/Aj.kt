package battle.entity.character.aj

import battle.entity.character.AbstractCharacter

/**
 *
 *
 */
class Aj : AbstractCharacter<AjNode>(AjNode()) {
	init {
		maxHealth = 20.0
		health = 16.0
		maxShield = 62.0
		shield = 62.0
	}

	override fun sustainDamage(damage: Double): Double {
		TODO("Not yet implemented")
	}
}

