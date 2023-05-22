package battle.entity.character.peek

import battle.entity.character.AbstractCharacter
import core.MemberCharacter

/**
 *
 */
internal class Peek : AbstractCharacter<PeekNode>(MemberCharacter.PEEK, PeekNode()) {
	override fun sustainDamage(damage: Double): Double {
		return super.sustainDamage(damage)
	}
}