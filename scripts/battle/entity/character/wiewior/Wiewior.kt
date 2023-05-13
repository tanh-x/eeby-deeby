package battle.entity.character.wiewior

import battle.entity.character.AbstractCharacter

class Wiewior : AbstractCharacter<WiewiorNode>(WiewiorNode()) {
	override var maxHealth: Double = 40.0
	override var health: Double = 40.0
	override var maxShield: Double = 10.0
	override var shield: Double = 10.0

	override fun sustainDamage(damage: Double): Double {
		TODO("Not yet implemented")
	}
}