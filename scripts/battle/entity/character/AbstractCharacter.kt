package battle.entity.character

import battle.entity.AbstractEntity
import battle.entity.Active
import battle.entity.Vulnerable
import core.PlayerCharacter
import utils.helpers.math.ramp

/**
 * A [AbstractCharacter] represents a character in battle. The stats are loaded from the
 * [PlayerCharacter] enum data class. Changing the stat values in this object has no effect
 * on the [PlayerCharacter] data, which is the persistent stat storage of the game.
 *
 * @param playerCharacter The corresponding enum entry in [PlayerCharacter]
 * @param node The character's Node that lives in the scene
 */
internal abstract class AbstractCharacter<N : AbstractCharacterNode>
internal constructor(
	playerCharacter: PlayerCharacter,
	node: N,
) : AbstractEntity<N>(node, true),
	Vulnerable,
	Active {
	/**
	 * The maximum health value of the character. Initializes to the value stored in [PlayerCharacter],
	 * but may change during battle.
	 */
	override var maxHealth: Double = playerCharacter.health
		set(value) {
			field = ramp(value)
			if (node.isReady) node.overlay.updateAll()
		}

	/**
	 * The current health value of the character.
	 */
	override var health: Double = playerCharacter.health
		set(value) {
			field = ramp(value)
			if (node.isReady) node.overlay.updateAll()
		}

	/**
	 * The maximum shield value of the character. Initializes the value stored in [PlayerCharacter],
	 * but may change during battle.
	 */
	override var maxShield: Double = playerCharacter.shield
		set(value) {
			field = ramp(value)
			if (node.isReady) node.overlay.updateAll()
		}

	/**
	 * The current shield value of the character.
	 */
	override var shield: Double = playerCharacter.shield
		set(value) {
			field = ramp(value)
			if (node.isReady) node.overlay.updateAll()
		}

	/**
	 * The current power value of the character.
	 */
	override var power: Double = playerCharacter.power
		set(value) {
			field = ramp(value)
		}

	/**
	 * The current agility value of the character.
	 */
	override var agility: Double = playerCharacter.agility
		set(value) {
			field = ramp(value)
		}

	/**
	 * The current Psiju potency value of the character. Will not be mutated during the battle,
	 * except for potentially during initialization.
	 */
	internal val psijuPotency: Double = playerCharacter.psijuPotency

	/**
	 * The current Psiju efficacy value of the character. Will not be mutated during the battle,
	 * except for potentially during initialization
	 */
	internal val psijuEfficacy: Double = playerCharacter.psijuEfficacy

	/**
	 * Whether the character is incapacitated
	 */
	override var isDisabled: Boolean = false

	override fun sustainDamage(damage: Double): Double {
		return super.sustainDamage(damage).also {
			node.overlay.spawnDamageNumber(it)
			println("$this took $it damage")
		}
	}
}