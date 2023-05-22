package battle.core

internal data class AbilityDescription(
    internal val abilityName: String,
    internal val description: String,
) {
    companion object {
        @JvmStatic
        internal fun emptyAbility(): AbilityDescription = AbilityDescription("N/A", "N/A")
    }
}
