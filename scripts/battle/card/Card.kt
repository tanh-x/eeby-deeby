package battle.card

/**
 * A card object represents an augmentation upon a player's actions. The chosen card is stored within
 * an [battle.core.Action] data object.
 *
 * @param label The display name of the card
 *
 * @see battle.core.Action
 */
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