package battle

import EngineSingletons.singleton
import entity.AbstractEntity
import game.GameManager
import godot.Node2D
import godot.annotation.RegisterClass
import godot.annotation.RegisterFunction

@RegisterClass
class BattleScene() : Node2D() {
	private lateinit var gameManager: GameManager

	internal lateinit var params: BattleParams

	private val characters: HashMap<AbstractEntity<out Node2D>, Node2D> = hashMapOf()

	@RegisterFunction
	override fun _ready() {
		this.gameManager = singleton("GameManager")
		this.params = gameManager.battleParams

		generateBattle()
	}

	private fun generateBattle() {

	}
}