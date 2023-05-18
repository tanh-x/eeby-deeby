package character.kew

import character.AbstractCharacter
import character.MemberCharacter

/**
 *
 */
class Kew : AbstractCharacter<KewNode>(MemberCharacter.KEW, KewNode()) {
    override fun sustainDamage(damage: Double): Double {
        return super.sustainDamage(damage)
    }
}
