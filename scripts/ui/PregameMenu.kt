package ui

import EngineSingletons
import EngineSingletons.singleton
import game.GameManager
import godot.Button
import godot.Control
import godot.TextEdit
import godot.annotation.RegisterClass
import godot.annotation.RegisterFunction
import utils.helpers.node

@RegisterClass
class PregameMenu : Control() {
	private lateinit var configTextBox: TextEdit
	private lateinit var startButton: Button

	@RegisterFunction
	override fun _ready() {
		configTextBox = node("%/ConfigTextBox")
		startButton = node("%/ConfigTextBox")
	}

	@RegisterFunction
	fun onStartButtonPressed() {
		singleton<GameManager>("GameManager").switchToBattle()
	}
}