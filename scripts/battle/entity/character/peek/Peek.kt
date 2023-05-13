package battle.entity.character.peek

import battle.entity.character.AbstractCharacter

class Peek : AbstractCharacter<PeekNode>(PeekNode()) {
	override var maxHealth: Double = 62.0
	override var health: Double = 62.0
	override var maxShield: Double = 17.0
	override var shield: Double = 17.0

	override fun sustainDamage(damage: Double): Double {
		TODO("Not yet implemented")
	}
}