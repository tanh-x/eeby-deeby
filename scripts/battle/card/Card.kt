package battle.card


internal enum class Card(
    private val label: String
) {
    NONE(label = "None")

    ;

    companion object {
        @JvmStatic
        val cards: Array<Card> = Card.values()

        @JvmStatic
        internal operator fun get(id: Int): Card = cards[id]
    }
}