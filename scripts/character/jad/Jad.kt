package character.jad

import character.AbstractCharacter
import character.MemberCharacter

/**
 *
 */
class Jad : AbstractCharacter<JadNode>(MemberCharacter.JAD, JadNode()) {
	override fun sustainDamage(damage: Double): Double {
		return super.sustainDamage(damage)
	}
}