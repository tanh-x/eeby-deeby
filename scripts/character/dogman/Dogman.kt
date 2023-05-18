package character.dogman

import character.AbstractCharacter
import character.MemberCharacter

/**
 *
 */
class Dogman : AbstractCharacter<DogmanNode>(MemberCharacter.DOGMAN, DogmanNode()) {
	override fun sustainDamage(damage: Double): Double {
		return super.sustainDamage(damage)
	}
}