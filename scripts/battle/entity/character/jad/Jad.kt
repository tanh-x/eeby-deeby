package battle.entity.character.jad

import battle.entity.character.AbstractCharacter

class Jad : AbstractCharacter<JadNode>(JadNode()) {
	override var maxHealth: Int = 40
	override var health: Int = 40
	override var maxShield: Int = 12
	override var shield: Int = 12

	override fun sustainDamage(damage: Double): Double {
		TODO("Not yet implemented")
	}
}