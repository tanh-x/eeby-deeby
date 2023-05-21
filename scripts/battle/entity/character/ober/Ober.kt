package battle.entity.character.ober

import battle.entity.character.AbstractCharacter
import core.MemberCharacter

class Ober : AbstractCharacter<OberNode>(MemberCharacter.OBER, OberNode()) {
    override fun sustainDamage(damage: Double): Double {
        return super.sustainDamage(damage)

    }
}