package character

import battle.entity.AbstractEntity
import battle.entity.Attacking
import battle.entity.Vulnerable


abstract class AbstractCharacter<N : AbstractCharacterNode>
internal constructor(
	associatedCharacter: MemberCharacter, node: N
) : AbstractEntity<N>(node), Vulnerable, Attacking {
	override var maxHealth: Double = DEFAULT_BOGUS_VALUE
		set(value) {
			field = value.coerceAtLeast(0.0)
			if (node.isReady) node.overlay.updateAll()
		}

	override var health: Double = DEFAULT_BOGUS_VALUE
		set(value) {
			field = value.coerceAtLeast(0.0)
			if (node.isReady) node.overlay.updateAll()
		}

	override var shield: Double = DEFAULT_BOGUS_VALUE
		set(value) {
			field = value.coerceAtLeast(0.0)
			if (node.isReady) node.overlay.updateAll()
		}

	override var maxShield: Double = DEFAULT_BOGUS_VALUE
		set(value) {
			field = value.coerceAtLeast(0.0)
			if (node.isReady) node.overlay.updateAll()
		}

	override var isDisabled: Boolean = false
		set(value) {
			field = value
		}

	override var agility: Double = DEFAULT_BOGUS_VALUE

	override var power: Double = DEFAULT_BOGUS_VALUE

	override fun sustainDamage(damage: Double): Double {
		health -= damage
		node.overlay.spawnDamageNumber(number = damage)
		return damage
	}


}