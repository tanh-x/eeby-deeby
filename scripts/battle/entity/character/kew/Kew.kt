package battle.entity.character.kew

import battle.entity.character.AbstractCharacter

class Kew : AbstractCharacter<KewNode>(KewNode()) {
	override var maxHealth: Double = 33.0
	override var health: Double = 33.0
	override var maxShield: Double = 17.0
	override var shield: Double = 17.0


	override fun sustainDamage(damage: Double): Double {
		TODO("Not yet implemented")
	}
}
