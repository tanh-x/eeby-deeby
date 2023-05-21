package battle.entity.character

import battle.entity.AbstractEntity
import battle.entity.Attacking
import battle.entity.Vulnerable
import core.MemberCharacter
import utils.helpers.math.ramp


abstract class AbstractCharacter<N : AbstractCharacterNode>
internal constructor(
    associatedCharacter: MemberCharacter, node: N
) : AbstractEntity<N>(node), Vulnerable, Attacking {
    override var maxHealth: Double = associatedCharacter.health
        set(value) {
            field = ramp(value)
            if (node.isReady) node.overlay.updateAll()
        }

    override var health: Double = associatedCharacter.health
        set(value) {
            field = ramp(value)
            if (node.isReady) node.overlay.updateAll()
        }

    override var shield: Double = associatedCharacter.shield
        set(value) {
            field = ramp(value)
            if (node.isReady) node.overlay.updateAll()
    }

    override var maxShield: Double = associatedCharacter.shield
        set(value) {
            field = ramp(value)
            if (node.isReady) node.overlay.updateAll()
        }

    override var power: Double = associatedCharacter.power
        set(value) {
            field = ramp(value)
        }

    override var agility: Double = associatedCharacter.agility
        set(value) {
            field = ramp(value)
        }

    internal var psijuPotency: Double = associatedCharacter.psijuPotency

    internal var psijuEfficacy: Double = associatedCharacter.psijuEfficacy

    override var isDisabled: Boolean = false

    override fun sustainDamage(damage: Double): Double {
        health -= damage
        node.overlay.spawnDamageNumber(number = damage)
        return damage
    }
}