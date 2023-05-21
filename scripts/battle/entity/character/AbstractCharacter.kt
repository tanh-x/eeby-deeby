package battle.entity.character

import battle.entity.AbstractEntity
import battle.entity.Attacking
import battle.entity.Vulnerable
import core.MemberCharacter
import utils.helpers.math.ramp


abstract class AbstractCharacter<N : AbstractCharacterNode>
internal constructor(
    factory: MemberCharacter, node: N
) : AbstractEntity<N>(node), Vulnerable, Attacking {
    override var maxHealth: Double = factory.health
        set(value) {
            field = ramp(value)
            if (node.isReady) node.overlay.updateAll()
        }

    override var health: Double = factory.health
        set(value) {
            field = ramp(value)
            if (node.isReady) node.overlay.updateAll()
        }

    override var shield: Double = factory.shield
        set(value) {
            field = ramp(value)
            if (node.isReady) node.overlay.updateAll()
    }

    override var maxShield: Double = factory.shield
        set(value) {
            field = ramp(value)
            if (node.isReady) node.overlay.updateAll()
        }

    override var power: Double = factory.power
        set(value) {
            field = ramp(value)
        }

    override var agility: Double = factory.agility
        set(value) {
            field = ramp(value)
        }

    internal var psijuPotency: Double = factory.psijuPotency

    internal var psijuEfficacy: Double = factory.psijuEfficacy

    override var isDisabled: Boolean = false

    override fun sustainDamage(damage: Double): Double {
        health -= damage
        node.overlay.spawnDamageNumber(number = damage)
        return damage
    }
}