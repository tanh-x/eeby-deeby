package battle.core

/**
 * A data class that stores the description of an ability, as well as the template
 *
 * @param abilityName The display name of the ability
 * @param description The detailed description of the ability
 */
internal data class AbilityDescription(
	internal val abilityName: String,
	internal val description: String,
) {
	companion object {
		@JvmStatic
		internal fun emptyAbility(): AbilityDescription = AbilityDescription("N/A", "N/A")
	}
}
