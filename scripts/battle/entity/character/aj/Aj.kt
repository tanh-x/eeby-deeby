package battle.entity.character.aj

import battle.entity.character.AbstractCharacter

/**
 *
 *
 */
class Aj : AbstractCharacter<AjNode>(AjNode()) {
	override var maxHealth: Int = 20
	override var health: Int = 20
	override var maxShield: Int = 62
	override var shield: Int = 62

	override fun sustainDamage(damage: Double): Double {
		TODO("Not yet implemented")
	}
}

