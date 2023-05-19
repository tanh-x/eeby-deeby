package character.ober

import character.AbstractCharacter
import character.MemberCharacter

class Ober : AbstractCharacter<OberNode>(MemberCharacter.OBER, OberNode()) {
    override fun sustainDamage(damage: Double): Double {
        return super.sustainDamage(damage)

    }
}