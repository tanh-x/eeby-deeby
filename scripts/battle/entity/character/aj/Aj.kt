package battle.entity.character.aj

import battle.entity.character.AbstractCharacter
import core.MemberCharacter

/**
 *
 */
class Aj : AbstractCharacter<AjNode>(MemberCharacter.AJ, AjNode()) {
    override fun sustainDamage(damage: Double): Double {
        return super.sustainDamage(damage)
    }
}

