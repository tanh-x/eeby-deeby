package character

import character.aj.Aj
import character.dogman.Dogman
import character.jad.Jad
import character.kew.Kew
import character.peek.Peek
import character.wiewior.Wiewior
import kotlin.Double.Companion.NaN

internal enum class MemberCharacter(
    internal var label: String = "default",
    internal var health: Double = NaN,
    internal var shield: Double = NaN,
    internal var power: Double = NaN,
    internal var agility: Double = NaN,
) {
    // Ordinal 0
    TEST(
        label = "Test",
    ) {
        override fun instantiate() = Aj()
    },

    // Ordinal 1
    AJ(
        label = "Aj",
        health = 20.0,
        shield = 64.0,
    ) {
        override fun instantiate() = Aj()
    },

    // Ordinal 2
    CH2,

    // Ordinal 3
    PEEK(
        label = "Peek",
        health = 56.0,
        shield = 8.0,
    ) {
        override fun instantiate() = Peek()
    },

    // Ordinal 4
    CH4,

    // Ordinal 5
    JAD(
        label = "Jad",
        health = 40.0,
        shield = 20.0,
    ) {
        override fun instantiate() = Jad()
    },

    // Ordinal 6
    KEW(
        label = "Kew",
        health = 33.0,
        shield = 20.0,
    ) {
        override fun instantiate() = Kew()
    },

    // Ordinal 7
    WIEWIOR(
        label = "Wiewior",
        health = 40.0,
        shield = 15.0,
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