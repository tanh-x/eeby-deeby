package battle.entity.character

import battle.core.Action
import battle.core.ActionType.*
import battle.core.BattleManager
import battle.entity.AbstractEntity
import battle.entity.Attacking
import battle.entity.Vulnerable
import battle.entity.enemy.AbstractEnemy
import battle.entity.enemy.AbstractEnemyNode
import core.MemberCharacter
import utils.helpers.math.ramp
import java.lang.IllegalArgumentException


internal abstract class AbstractCharacter<N : AbstractCharacterNode>
internal constructor(
    factory: MemberCharacter,
    node: N,
    playerSide: Boolean = true,
) : AbstractEntity<N>(node, playerSide),
    Vulnerable,
    Attacking {
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
        set(value) {
            field = ramp(value)
        }

    internal var psijuEfficacy: Double = factory.psijuEfficacy
        set(value) {
            field = ramp(value)
        }

    override var isDisabled: Boolean = false

    override fun sustainDamage(damage: Double): Double {
        return super.sustainDamage(damage).also { node.overlay.spawnDamageNumber(it) }
    }

    protected open fun selfAction(action: Action, battleState: BattleManager) {

    }

    protected open fun offenseAction(action: Action, battleState: BattleManager) {

    }

    protected open fun supportAction(action: Action, battleState: BattleManager) {

    }

    protected open fun specialAction(action: Action, battleState: BattleManager) {

    }

    internal fun dispatchAction(action: Action, battleState: BattleManager) {
        when (action.type) {
            SELF    -> selfAction(action, battleState)
            OFFENSE -> offenseAction(action, battleState)
            SUPPORT -> supportAction(action, battleState)
            SPECIAL -> specialAction(action, battleState)
        }
    }
}