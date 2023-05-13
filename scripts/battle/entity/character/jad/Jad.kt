package battle.entity.character.jad

import battle.entity.character.AbstractCharacter

class Jad : AbstractCharacter<JadNode>(JadNode()) {
	override var maxHealth: Double = 40.0
	override var health: Double = 40.0
	override var maxShield: Double = 12.0
	override var shield: Double = 12.0

	override fun sustainDamage(damage: Double): Double {
		TODO("Not yet implemented")
	}
}