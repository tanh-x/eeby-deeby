package core

import battle.core.AbilityDescription
import battle.core.ActionType
import battle.entity.character.AbstractCharacter
import battle.entity.character.AbstractCharacterNode
import battle.entity.character.aj.Aj
import battle.entity.character.bnuuy.Bnuuy
import battle.entity.character.cyg.Cyg
import battle.entity.character.dogman.Dogman
import battle.entity.character.jad.Jad
import battle.entity.character.kew.Kew
import battle.entity.character.maves.Maves
import battle.entity.character.murwan.Murwan
import battle.entity.character.ober.Ober
import battle.entity.character.peek.Peek
import battle.entity.character.wiewior.Wiewior
import godot.global.GD
import utils.helpers.math.formatted
import utils.helpers.math.stdev

/**
 * Stores the stats of each player battle.entity.character. Will mutate over the course of gameplay outside of
 * battles, and is immutable within battles.
 */
@Suppress("SpellCheckingInspection")
internal enum class PlayerCharacter(
	/**
	 * The display name of the character.
	 */
	internal var label: String = "default",

	/**
	 * The stats values of this character
	 */
	internal val stats: CharacterStats,

	/**
	 * The descriptions for the abilities of a character
	 */
	internal val abilityDescription: LinkedHashMap<ActionType, AbilityDescription> = LinkedHashMap(
		ActionType.values().associateWith { AbilityDescription.emptyAbility() }
	)

) {
	// Ordinal 0
	BNUUY(
		label = "Bnuuy",
		stats = CharacterStats(
			health = 10.0,
			shield = 2.0,
			power = 3.0,
			agility = 36.0,
			psijuPotency = 1660.0,
			psijuEfficacy = 0.5,
		)
	) {
		override fun instantiate() = Bnuuy()
	},

	// Ordinal 1
	AJ(
		label = "AJ",
		stats = CharacterStats(
			health = 24.0,
			shield = 48.0,
			power = 15.0,
			agility = 3.0,
			psijuPotency = 512.0,
			psijuEfficacy = 5.0,
		),
		abilityDescription = linkedMapOf(
			ActionType.OFFENSE to AbilityDescription(
				abilityName = "Astral Strings",
				description = "tentacles go kill"
			),
			ActionType.SUPPORT to AbilityDescription(
				abilityName = "something support",
				description = "TODO"
			),
			ActionType.SELF to AbilityDescription(
				abilityName = "something something block",
				description = "TODO",
			),
			ActionType.SPECIAL to AbilityDescription(
				abilityName = "big fucking black hole",
				description = "TODO"
			)
		)
	) {
		override fun instantiate() = Aj()
	},

	// Ordinal 2
	MAVES(
		label = "Maves",
		stats = CharacterStats(
			health = 52.0,
			shield = 32.0,
			power = 20.0,
			agility = 3.5,
			psijuPotency = 145.0,
			psijuEfficacy = 16.0,
		),
	) {
		override fun instantiate() = Maves()
	},

	// Ordinal 3
	PEEK(
		label = "Peek",
		stats = CharacterStats(
			health = 100.0,
			shield = 12.0,
			power = 27.0,
			agility = 5.8,
			psijuPotency = 56.0,
			psijuEfficacy = 10.0
		),
	) {
		override fun instantiate() = Peek()
	},

	// Ordinal 4
	CYG(
		label = "Cyg",
		stats = CharacterStats(
			health = 72.0,
			shield = 21.0,
			power = 15.0,
			agility = 11.5,
			psijuPotency = 80.0,
			psijuEfficacy = 21.0,
		),

		) {
		override fun instantiate() = Cyg()
	},

	// Ordinal 5
	JAD(
		label = "Jad",
		stats = CharacterStats(
			health = 65.0,
			shield = 24.0,
			power = 14.0,
			agility = 5.0,
			psijuPotency = 140.0,
			psijuEfficacy = 16.0,
		),
	) {
		override fun instantiate() = Jad()
	},

	// Ordinal 6
	KEW(
		label = "Kew",
		stats = CharacterStats(
			health = 48.0,
			shield = 32.0,
			power = 24.0,
			agility = 4.18,
			psijuPotency = 56.0,
			psijuEfficacy = 50.0,
		),
	) {
		override fun instantiate() = Kew()
	},

	// Ordinal 7
	WIEWIOR(
		label = "Wiewior",
		stats = CharacterStats(
			health = 83.0,
			shield = 20.0,
			power = 16.0,
			agility = 6.2,
			psijuPotency = 100.0,
			psijuEfficacy = 10.0,
		),
	) {
		override fun instantiate() = Wiewior()
	},

	// Ordinal 8
	OBER(
		label = "Ober",
		stats = CharacterStats(
			health = 61.0,
			shield = 35.0,
			power = 8.0,
			agility = 4.0,
			psijuPotency = 155.0,
			psijuEfficacy = 15.0,
		),
	) {
		override fun instantiate() = Ober()
	},

	// Ordinal 9
	DOGMAN(
		label = "Dogman",
		stats = CharacterStats(
			health = 61.0,
			shield = 30.0,
			power = 16.0,
			agility = 5.5,
			psijuPotency = 115.0,
			psijuEfficacy = 14.0,
		),
	) {
		override fun instantiate() = Dogman()
	},

	PLACEHOLDER_10(
		label = "Placeholder",
		stats = CharacterStats(
			health = 40.0,
			shield = 40.0,
			power = 12.0,
			agility = 9.0,
			psijuPotency = 160.0,
			psijuEfficacy = 17.0,
		),
	) {
		override fun instantiate() = TODO()
	},

	MURWAN(
		label = "Murwan",
		stats = CharacterStats(
			health = 48.0,
			shield = 24.0,
			power = 16.0,
			agility = 13.0,
			psijuPotency = 87.0,
			psijuEfficacy = 12.0
		),
	) {
		override fun instantiate() = Murwan()
	};

	/**
	 * Loads the stats from a save file state.
	 */
	internal fun loadStats() {

	}

	protected abstract fun instantiate(): AbstractCharacter<out AbstractCharacterNode>

	companion object {
		@JvmStatic
		internal fun createCharacter(characterId: Int): AbstractCharacter<out AbstractCharacterNode> {
			return characters[characterId].instantiate()
		}

		@JvmStatic
		internal val characters: Array<PlayerCharacter> = PlayerCharacter.values()

		@JvmStatic
		internal operator fun get(id: Int): PlayerCharacter = characters[id]

		@JvmStatic
		internal fun printStatSheet() {
			GD.print(
				"┌───────────────────────────────────────────\n" +
				"│ CHARACTER STAT BALANCING SHEET   \n" +
				"├──────────────┬─────────────────┬──────────\n" +
				"│ Character    │ Str.     z-score│ Psi.     z-score\n" +
				"├──────────────┼─────────────────┼──────────"
			)
			val strHeuristics: List<Double> = characters.map { it.stats.calcStrengthHeuristic() }
			val strMean: Double = strHeuristics.average()
			val strStdev: Double = strHeuristics.stdev()

			val psiHeuristics: List<Double> = characters.map { it.stats.calcPsijuHeuristic() }
			val psiMean: Double = psiHeuristics.average()
			val psiStdev: Double = psiHeuristics.stdev()

			// @formatter:off
			PlayerCharacter.characters.forEachIndexed { i: Int, ch: PlayerCharacter ->
				if (i == 0) return@forEachIndexed
				GD.print(
					"| ${ch.label.padEnd(12)} " +
					"| ${strHeuristics[i].formatted().padEnd(7)} " +
						"${((strHeuristics[i] - strMean) / strStdev).formatted(digits = 4).padStart(7)}σ" +
					"| ${psiHeuristics[i].formatted().padEnd(7)} " +
						"${((psiHeuristics[i] - psiMean) / psiStdev).formatted(digits = 4).padStart(7)}σ" +
					"| ${strHeuristics[i] + psiHeuristics[i]}"
				)
			}
		}
	}
}
