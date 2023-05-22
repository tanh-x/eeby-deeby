package ui

import EngineSingletons.getManager
import battle.core.BattleScene
import godot.Button
import godot.Control
import godot.annotation.RegisterClass
import godot.annotation.RegisterFunction
import utils.helpers.node
import kotlin.random.Random

@RegisterClass
class PrimaryUI : Control() {
	private lateinit var battleScene: BattleScene

	private lateinit var escapeButton: Button

	@RegisterFunction
	override fun _ready() {
		battleScene = node("/root/BattleScene")
		escapeButton = node("VBoxContainer/EscapeButton")
	}

	@RegisterFunction
	fun onEscapeButtonPressed() {
		getManager().switchSceneSafely("res://scenes/core/Main.tscn")
	}

	@RegisterFunction
	fun onFn1Pressed() {
		battleScene.charactersList.forEach { it.node.overlay.updateAll() }
		battleScene.enemiesList.forEach { it.node.overlay.updateAll() }
	}

	@RegisterFunction
	fun onFn2Pressed() {
		battleScene.charactersList.forEach { it.health = Random.nextDouble() * it.maxHealth }
	}

	@RegisterFunction
	fun onFn3Pressed() {
		battleScene.charactersList.first().sustainDamage(Random.nextDouble() * 5)
	}

	@RegisterFunction
	fun onReadyPressed() {
		battleScene.readyTurn()
	}
}
