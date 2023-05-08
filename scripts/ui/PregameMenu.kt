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

@RegisterClass
class PregameMenu : Control() {
	private lateinit var configTextBox: TextEdit
	private lateinit var startButton: Button

	@RegisterFunction
	override fun _ready() {
		configTextBox = node("Margin/HBoxContainer/RightContainer/ConfigTextBox")
		startButton = node("Margin/HBoxContainer/RightContainer/HBoxContainer/StartButton")
	}

	@RegisterFunction
	fun onStartButtonPressed() {
		singleton<GameManager>("GameManager").switchToBattle(
			battleParams = Json.decodeFromString<BattleParams>(configTextBox.text)
		)
	}
}