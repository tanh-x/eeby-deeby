package ui

import EngineSingletons.singleton
import battle.BattleParams
import game.GameManager
import godot.Button
import godot.Control
import godot.TextEdit
import godot.annotation.RegisterClass
import godot.annotation.RegisterFunction
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.json.Json
import utils.helpers.node

/**
 * This [Control] node handles actions made within the menu that precedes a battle.
 * When the [startButton] button is pressed, a certain method from the [GameManager] singleton
 * will be called.
 */
@RegisterClass
class PregameMenu : Control() {
	/**
	 * [ DEBUG ] The text box that holds the config string
	 */
	private lateinit var configTextBox: TextEdit

	/**
	 * The button that initialises a call to start the game
	 */
	private lateinit var startButton: Button

	init {
		System.gc()
	}

	/**
	 * On ready, we fetch the components that we access frequently
	 */
	@RegisterFunction
	override fun _ready() {
		configTextBox = node("Margin/HBoxContainer/RightContainer/ConfigTextBox")
		startButton = node("Margin/HBoxContainer/RightContainer/HBoxContainer/StartButton")
	}

	/**
	 * This method listens to the "pressed" signal of the [startButton], upon which it will get the
	 * [GameManager] singleton and call its [GameManager.switchToBattle] method. This approach is used
	 * instead of emitting a signal because we want to pass in a custom serialized Kotlin data class,
	 * which Godot does not understand.
	 */
	@RegisterFunction
	fun onStartButtonPressed() {
		singleton<GameManager>("GameManager").switchToBattle(
			battleParams = Json.decodeFromString<BattleParams>(configTextBox.text)
		)
	}
}