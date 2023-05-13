package battle.entity.character

class Kew : AbstractCharacter<KewNode>(KewNode()) {
	override var maxHealth: Int = 33
	override var health: Int = 33
	override var maxShield: Int = 17
	override var shield: Int = 17


	override fun sustainDamage(damage: Double): Double {
		TODO("Not yet implemented")
	}
}
