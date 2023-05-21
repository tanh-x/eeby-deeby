package ui

import EngineSingletons.getManager
import battle.BattleScene
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
		battleScene.characters.values.forEach { it.node.overlay.updateAll() }
		battleScene.enemies.values.forEach { it.node.overlay.updateAll() }
	}

	@RegisterFunction
	fun onFn2Pressed() {
		battleScene.characters.values.forEach { it.health = Random.nextDouble() * it.maxHealth }
	}

	@RegisterFunction
	fun onFn3Pressed() {
		battleScene.characters.values.first().sustainDamage(Random.nextDouble() * 5)
	}
}
