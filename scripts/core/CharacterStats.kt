package core

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlin.Double.Companion.NaN

@Serializable
data class CharacterStats(
	/**
	 * The health value.
	 * Average is 35-40, low variance.
	 */
	@SerialName("health")
	internal var health: Double = NaN,

	/**
	 * The shield value.
	 * Average is around 20, low variance.
	 */
	@SerialName("shield")
	internal var shield: Double = NaN,

	/**
	 * The power, which will be used to as scaling for standard attacks.
	 * Average is around 20, medium-low variance.
	 */
	@SerialName("power")
	internal var power: Double = NaN,

	/**
	 * The agility, which will affect attack order as well as certain actions.
	 * Average is around 5, medium-high variance.
	 */
	@SerialName("agility")
	internal var agility: Double = NaN,

	/**
	 * How powerful psiju actions are.
	 * Average is 100, medium variance except for special cases.
	 */
	@SerialName("psiju_potency")
	internal var psijuPotency: Double = NaN,

	/**
	 * How often can psiju actions be used. Can be used to facilitate other battle.entity.character's psiju actions.
	 * Average is around 15, high variance. Inversely proportional to potency
	 */
	@SerialName("psiju_efficacy")
	internal var psijuEfficacy: Double = NaN,
) {
	/**
	 * TODO
	 */
	internal fun calcStrengthHeuristic(): Double =
		1.0 * health +
		1.0 * shield +
		1.75 * power +
		0.8 * agility +
		-65

	internal fun calcPsijuHeuristic(): Double = (psijuEfficacy + 5) * (psijuPotency - 10) / 50
}