package character.peek

import character.AbstractCharacter
import character.MemberCharacter

/**
 *
 */
class Peek : AbstractCharacter<PeekNode>(MemberCharacter.PEEK, PeekNode()) {
	override fun sustainDamage(damage: Double): Double {
		return super.sustainDamage(damage)
	}
}