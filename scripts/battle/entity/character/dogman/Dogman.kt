package battle.entity.character.dogman

import battle.entity.character.AbstractCharacter
import core.MemberCharacter

/**
 *
 */
class Dogman : AbstractCharacter<DogmanNode>(MemberCharacter.DOGMAN, DogmanNode()) {
	override fun sustainDamage(damage: Double): Double {
		return super.sustainDamage(damage)
	}
}