package character.maves

import character.AbstractCharacter
import character.MemberCharacter

class Maves : AbstractCharacter<MavesNode>(MemberCharacter.MAVES, MavesNode()) {
    override fun sustainDamage(damage: Double): Double {
        return super.sustainDamage(damage)
    }
}