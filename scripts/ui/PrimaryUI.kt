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
		escapeButton = node("VBoxContainer/EscapeButton")
	}

	@RegisterFunction
	fun onEscapeButtonPressed() {
		gameManager.switchSceneSafely("res://scenes/core/Main.tscn")
	}

	@RegisterFunction
	fun onFn1Pressed() {
		println("Fn 1")
		battleScene.characters.forEach { it.node.overlay.updateAll() }
		battleScene.enemies.forEach { it.node.overlay.updateAll() }
	}

	@RegisterFunction
	fun onFn2Pressed() {
		println("Fn 2")
	}

	@RegisterFunction
	fun onFn3Pressed() {
		println("Fn 3")
	}
}