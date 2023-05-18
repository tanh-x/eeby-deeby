package character.wiewior

import character.AbstractCharacter
import character.MemberCharacter

/**
 *
 */
class Wiewior : AbstractCharacter<WiewiorNode>(MemberCharacter.WIEWIOR, WiewiorNode()) {
    override fun sustainDamage(damage: Double): Double {
        return super.sustainDamage(damage)
    }
}