package battle.core

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import utils.helpers.duplicated

/**
 * Every parameter needed to completely communicate the initial state of the battle.
 *
 * @see [BattleScene.generateBattle]
 */
@Serializable
data class BattleParams(
	@SerialName("stage_name") val stageName: String,
	@SerialName("characters") val characters: Array<Int>,
	@SerialName("opponents") val opponents: Array<Int>,
) {
	fun isValid(): Boolean =
		characters.size in 1..MAX_NUM_CHARACTERS &&
		opponents.size in 1..MAX_NUM_ENEMIES &&
		!characters.duplicated()

	override fun equals(other: Any?): Boolean {
		if (this === other) return true
		if (javaClass != other?.javaClass) return false

		other as BattleParams

		if (stageName != other.stageName) return false
		if (!characters.contentEquals(other.characters)) return false
		return opponents.contentEquals(other.opponents)
	}

	override fun hashCode(): Int =
		961 * stageName.hashCode() +
		31 * characters.contentHashCode() +
		opponents.contentHashCode()

	companion object {
		/**
		 *
		 * @see BattleScene.Companion.characterPlacements
		 */
		const val MAX_NUM_CHARACTERS: Int = 4

		/**
		 *
		 * @see BattleScene.distributePlacement
		 */
		const val MAX_NUM_ENEMIES: Int = 4
	}
}
