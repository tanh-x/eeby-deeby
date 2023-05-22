package battle.entity.character.maves

import battle.entity.character.AbstractCharacter
import core.MemberCharacter

internal class Maves : AbstractCharacter<MavesNode>(MemberCharacter.MAVES, MavesNode()) {
    override fun sustainDamage(damage: Double): Double {
        return super.sustainDamage(damage)
    }
}