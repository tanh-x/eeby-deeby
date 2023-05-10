package battle.entity.character

/**
 *
 *
 */
class Aj() : AbstractCharacter<AjNode>() {
	internal var maxHealth: Int = 32
	internal var health: Int = 32

	init {
		super.node = AjNode()
	}


	override fun sustainDamage(damage: Double): Double {
		TODO("Not yet implemented")
	}
}

