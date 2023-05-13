package battle.entity.character.aj

import battle.entity.character.AbstractCharacter

/**
 *
 *
 */
class Aj : AbstractCharacter<AjNode>(AjNode()) {
	override var maxHealth: Double = 20.0
	override var health: Double = 20.0
	override var maxShield: Double = 62.0
	override var shield: Double = 62.0

	override fun sustainDamage(damage: Double): Double {
		TODO("Not yet implemented")
	}
}

