package battle.entity.character

import battle.entity.AbstractEntity
import battle.entity.Vulnerable


abstract class AbstractCharacter<N : AbstractCharacterNode>(node: N) : AbstractEntity<N>(node), Vulnerable {
	override var maxHealth: Double = 1.0
		set(value) {
			field = value.coerceAtLeast(0.0)
			if (node.isReady) node.overlay.updateAll()
		}

	override var health: Double = 1.0
		set(value) {
			field = value.coerceAtLeast(0.0)
			if (node.isReady) node.overlay.updateAll()
		}

	override var shield: Double = 1.0
		set(value) {
			field = value.coerceAtLeast(0.0)
			if (node.isReady) node.overlay.updateAll()
		}

	override var maxShield: Double = 1.0
		set(value) {
			field = value.coerceAtLeast(0.0)
			if (node.isReady) node.overlay.updateAll()
		}

	override fun sustainDamage(damage: Double): Double {
		health -= damage
		node.overlay.spawnDamageNumber(number = damage)
		return damage
	}
}