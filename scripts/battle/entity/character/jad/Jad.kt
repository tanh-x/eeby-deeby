package battle.entity.character.jad

import battle.entity.character.AbstractCharacter
import core.MemberCharacter

/**
 *
 */
class Jad : AbstractCharacter<JadNode>(MemberCharacter.JAD, JadNode()) {
	override fun sustainDamage(damage: Double): Double {
		return super.sustainDamage(damage)
	}
}