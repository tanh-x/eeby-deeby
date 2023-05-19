package character

import character.aj.Aj
import character.cyg.Cyg
import character.dogman.Dogman
import character.jad.Jad
import character.kew.Kew
import character.maves.Maves
import character.peek.Peek
import character.wiewior.Wiewior
import kotlin.Double.Companion.NaN

internal enum class MemberCharacter(
    internal var label: String = "default",
    internal var health: Double = NaN,
    internal var shield: Double = NaN,
    internal var power: Double = NaN,
    internal var agility: Double = NaN,
    internal var psijuPotency: Double = NaN,
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
        psijuEfficacy = 0.0,
    ) {
        override fun instantiate() = Aj()
    },

    // Ordinal 1
    AJ(
        label = "AJ",
        health = 15.0,
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
        health = 30.0,
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
        health = 56.0,
        shield = 18.0,
        power = 25.0,
        agility = 5.5,
        psijuPotency = 50.0,
        psijuEfficacy = 15.0
    ) {
        override fun instantiate() = Peek()
    },

    // Ordinal 4
    CYG(
        label = "Cyg",
        health = 43.0,
        shield = 22.0,
        power = 12.0,
        agility = 10.0,
        psijuPotency = 80.0,
        psijuEfficacy = 27.0,

        ) {
        override fun instantiate() = Cyg()
    },

    // Ordinal 5
    JAD(
        label = "Jad",
        health = 40.0,
        shield = 21.0,
        power = 22.0,
        agility = 4.0,
        psijuPotency = 140.0,
        psijuEfficacy = 20.0,
    ) {
        override fun instantiate() = Jad()
    },

    // Ordinal 6
    KEW(
        label = "Kew",
        health = 32.00,
        shield = 16.0,
        power = 24.0,
        agility = 4.8,
        psijuPotency = 64.0,
        psijuEfficacy = 36.0,
    ) {
        override fun instantiate() = Kew()
    },

    // Ordinal 7
    WIEWIOR(
        label = "Wiewior",
        health = 48.0,
        shield = 20.0,
        power = 16.0,
        agility = 6.0,
        psijuPotency = 100.0,
        psijuEfficacy = 21.0,
    ) {
        override fun instantiate() = Wiewior()
    },

    // Ordinal 8
    CH8,

    // Ordinal 9
    DOGMAN(
        label = "Dogman",
        health = 36.0,
        shield = 36.0,
        power = 17.0,
        agility = 5.0,
        psijuPotency = 112.0,
        psijuEfficacy = 24.0,
    ) {
        override fun instantiate() = Dogman()
    };

    internal fun loadStats() {

    }

    internal open fun instantiate(): AbstractCharacter<out AbstractCharacterNode> {
        throw NotImplementedError("Character not implemented")
    }

    companion object {
        @JvmStatic
        val characters: Array<MemberCharacter> = MemberCharacter.values()

        @JvmStatic
        internal operator fun get(id: Int): MemberCharacter = characters[id]
    }
}