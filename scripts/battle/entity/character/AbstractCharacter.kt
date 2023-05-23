package battle.entity.character

import battle.core.Action
import battle.core.ActionType.*
import battle.core.BattleManager
import battle.entity.AbstractEntity
import battle.entity.Active
import battle.entity.Vulnerable
import core.MemberCharacter
import utils.helpers.math.ramp

internal abstract class AbstractCharacter<N : AbstractCharacterNode>
internal constructor(
	factory: MemberCharacter,
	node: N,
	playerSide: Boolean = true,
) : AbstractEntity<N>(node, playerSide),
	Vulnerable,
	Active {
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
		return super.sustainDamage(damage).also {
			node.overlay.spawnDamageNumber(it)
			println("$this took $it damage")
		}
	}

	override fun dispatchAction(action: Action, battleState: BattleManager) {
		when (action.type) {
			SELF    -> selfAction(action, battleState)
			OFFENSE -> offenseAction(action, battleState)
			SUPPORT -> supportAction(action, battleState)
			SPECIAL -> specialAction(action, battleState)
		}
	}
}