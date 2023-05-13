package ui

import EngineSingletons.singleton
import battle.BattleScene
import game.GameManager
import godot.Button
import godot.Control
import godot.annotation.RegisterClass
import godot.annotation.RegisterFunction
import utils.helpers.node

@RegisterClass
class PrimaryUI : Control() {
	private lateinit var battleScene: BattleScene

	private lateinit var escapeButton: Button

	private lateinit var gameManager: GameManager

	@RegisterFunction
	override fun _ready() {
		gameManager = singleton("GameManager")
		battleScene = node("/root/BattleScene")
		escapeButton = node("EscapeButton")
	}

	@RegisterFunction
	fun onEscapeButtonPressed() {
		gameManager.switchSceneSafely("res://scenes/core/Main.tscn")
	}
}