package battle.entity.character.peek

import battle.entity.character.AbstractCharacter

class Peek : AbstractCharacter<PeekNode>(PeekNode()) {
	override var maxHealth: Int = 62
	override var health: Int = 62
	override var maxShield: Int = 17
	override var shield: Int = 17

	override fun sustainDamage(damage: Double): Double {
		TODO("Not yet implemented")
	}
}