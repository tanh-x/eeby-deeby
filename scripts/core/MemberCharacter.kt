package core

import battle.entity.character.AbstractCharacter
import battle.entity.character.AbstractCharacterNode
import battle.entity.character.aj.Aj
import battle.entity.character.cyg.Cyg
import battle.entity.character.dogman.Dogman
import battle.entity.character.jad.Jad
import battle.entity.character.kew.Kew
import battle.entity.character.maves.Maves
import battle.entity.character.ober.Ober
import battle.entity.character.peek.Peek
import battle.entity.character.wiewior.Wiewior
import kotlin.Double.Companion.NaN

/**
 * Stores the stats of each player battle.entity.character. Will mutate over the course of gameplay outside of
 * battles, and is immutable within battles.
 */
internal enum class MemberCharacter(
    /**
     * The display name of the battle.entity.character.
     */
    internal var label: String = "default",

    /**
     * The health value.
     * Average is 35-40, low variance.
     */
    internal var health: Double = NaN,

    /**
     * The shield value.
     * Average is around 20, low variance.
     */
    internal var shield: Double = NaN,

    /**
     * The power, which will be used to as scaling for standard attacks.
     * Average is around 20, medium-low variance.
     */
    internal var power: Double = NaN,

    /**
     * The agility, which will affect attack order as well as certain actions.
     * Average is around 5, medium-high variance.
     */
    internal var agility: Double = NaN,

    /**
     * How powerful psiju actions are.
     * Average is 100, medium variance except for special cases.
     */
    internal var psijuPotency: Double = NaN,

    /**
     * How often can psiju actions be used. Can be used to facilitate other battle.entity.character's psiju actions.
     * Average is around 15-20, high variance. Inversely proportional to potency
     */
    internal var psijuEfficacy: Double = NaN,

    ) {
    // Ordinal 0
    BNUUY(
        label = "Bnuuy",
        health = 5.0,
        shield = 2.0,
        power = 3.0,
        agility = 36.0,
        psijuPotency = 1660.0,
        psijuEfficacy = 0.5,
    ) {
        override fun instantiate() = Aj()
    },

    // Ordinal 1
    AJ(
        label = "AJ",
        health = 16.0,
        shield = 64.0,
        power = 15.0,
        agility = 3.0,
        psijuPotency = 325.0,
        psijuEfficacy = 6.0,
    ) {
        override fun instantiate() = Aj()
    },

    // Ordinal 2
    MAVES(
        label = "Maves",
        health = 32.0,
        shield = 17.0,
        power = 13.0,
        agility = 3.5,
        psijuPotency = 200.0,
        psijuEfficacy = 25.0,
    ) {
        override fun instantiate() = Maves()
    },

    // Ordinal 3
    PEEK(
        label = "Peek",
        health = 60.0,
        shield = 18.0,
        power = 26.0,
        agility = 5.8,
        psijuPotency = 50.0,
        psijuEfficacy = 10.0
    ) {
        override fun instantiate() = Peek()
    },

    // Ordinal 4
    CYG(
        label = "Cyg",
        health = 45.0,
        shield = 22.0,
        power = 12.0,
        agility = 11.5,
        psijuPotency = 80.0,
        psijuEfficacy = 22.0,

        ) {
        override fun instantiate() = Cyg()
    },

    // Ordinal 5
    JAD(
        label = "Jad",
        health = 43.0,
        shield = 21.0,
        power = 22.0,
        agility = 4.5,
        psijuPotency = 140.0,
        psijuEfficacy = 20.0,
    ) {
        override fun instantiate() = Jad()
    },

    // Ordinal 6
    KEW(
        label = "Kew",
        health = 36.00,
        shield = 16.0,
        power = 24.0,
        agility = 5.0,
        psijuPotency = 64.0,
        psijuEfficacy = 32.0,
    ) {
        override fun instantiate() = Kew()
    },

    // Ordinal 7
    WIEWIOR(
        label = "Wiewior",
        health = 48.0,
        shield = 20.0,
        power = 16.0,
        agility = 6.2,
        psijuPotency = 100.0,
        psijuEfficacy = 14.0,
    ) {
        override fun instantiate() = Wiewior()
    },

    // Ordinal 8
    OBER(
        label = "Ober",
        health = 35.0,
        shield = 35.0,
        power = 9.0,
        agility = 4.0,
        psijuPotency = 167.0,
        psijuEfficacy = 18.0,
    ) {
        override fun instantiate() = Ober()
    },

    // Ordinal 9
    DOGMAN(
        label = "Dogman",
        health = 38.0,
        shield = 36.0,
        power = 17.0,
        agility = 5.5,
        psijuPotency = 126.0,
        psijuEfficacy = 16.0,
    ) {
        override fun instantiate() = Dogman()
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
        internal val characters: Array<MemberCharacter> = MemberCharacter.values()

        @JvmStatic
        internal operator fun get(id: Int): MemberCharacter = characters[id]
    }
}