package battle.entity.character.bnuuy

import battle.entity.character.AbstractCharacter
import core.MemberCharacter

internal class Bnuuy : AbstractCharacter<BnuuyNode>(MemberCharacter.BNUUY, BnuuyNode()) {
    override fun sustainDamage(damage: Double): Double {
        return super.sustainDamage(damage)
    }
}