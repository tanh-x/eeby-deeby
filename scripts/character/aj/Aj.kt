package character.aj

import character.AbstractCharacter
import character.MemberCharacter

/**
 *
 */
class Aj : AbstractCharacter<AjNode>(MemberCharacter.AJ, AjNode()) {
    override fun sustainDamage(damage: Double): Double {
        return super.sustainDamage(damage)
    }
}

