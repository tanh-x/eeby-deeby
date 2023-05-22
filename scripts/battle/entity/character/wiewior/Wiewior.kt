package battle.entity.character.wiewior

import battle.entity.character.AbstractCharacter
import core.MemberCharacter

/**
 *
 */
internal class Wiewior : AbstractCharacter<WiewiorNode>(MemberCharacter.WIEWIOR, WiewiorNode()) {
    override fun sustainDamage(damage: Double): Double {
        return super.sustainDamage(damage)
    }
}