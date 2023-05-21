package battle.core

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

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
	fun isValid(): Boolean = true

	override fun equals(other: Any?): Boolean {
		if (this === other) return true
		if (javaClass != other?.javaClass) return false

		other as BattleParams

		if (stageName != other.stageName) return false
		if (!characters.contentEquals(other.characters)) return false
		return opponents.contentEquals(other.opponents)
	}

	override fun hashCode(): Int {
		var result = stageName.hashCode()
		result = 31 * result + characters.contentHashCode()
		result = 31 * result + opponents.contentHashCode()
		return result
	}

}
