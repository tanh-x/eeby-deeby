package character

import battle.entity.AbstractEntity
import battle.entity.Attacking
import battle.entity.Vulnerable


abstract class AbstractCharacter<N : AbstractCharacterNode>
internal constructor(
	associatedCharacter: MemberCharacter, node: N
) : AbstractEntity<N>(node), Vulnerable, Attacking {
	override var maxHealth: Double = associatedCharacter.health
		set(value) {
			field = value.coerceAtLeast(0.0)
			if (node.isReady) node.overlay.updateAll()
		}

	override var health: Double = associatedCharacter.health
		set(value) {
			field = value.coerceAtLeast(0.0)
			if (node.isReady) node.overlay.updateAll()
		}

	override var shield: Double = associatedCharacter.shield
		set(value) {
			field = value.coerceAtLeast(0.0)
			if (node.isReady) node.overlay.updateAll()
		}

	override var maxShield: Double = associatedCharacter.shield
		set(value) {
			field = value.coerceAtLeast(0.0)
			if (node.isReady) node.overlay.updateAll()
		}

	override var isDisabled: Boolean = false
		set(value) {
			field = value
		}

	override var agility: Double = associatedCharacter.shield

	override var power: Double = associatedCharacter.power

	override fun sustainDamage(damage: Double): Double {
		health -= damage
		node.overlay.spawnDamageNumber(number = damage)
		return damage
	}


}