package battle.core

import godot.core.Color
import utils.helpers.Palette

enum class ActionType(
	internal val arrowColor: Color = Palette.AMBER_100
) {
	/**
	 * An action that is targeted towards their opponent
	 */
	OFFENSE(Palette.ORANGE_400),

	/**
	 * An action that is targeted towards their ally
	 */
	SUPPORT(Palette.FUCHSIA_500),

	/**
	 * An action that is targeted towards the actor
	 */
	SELF(Palette.VIOLET_400),

	/**
	 * A special action, optional.
	 */
	SPECIAL(Palette.VIOLET_400)
}

