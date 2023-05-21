package battle.entity.character.kew

import battle.entity.character.AbstractCharacter
import core.MemberCharacter

/**
 *
 */
class Kew : AbstractCharacter<KewNode>(MemberCharacter.KEW, KewNode()) {
    override fun sustainDamage(damage: Double): Double {
        return super.sustainDamage(damage)
    }
}
