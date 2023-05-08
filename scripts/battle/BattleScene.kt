package battle

import EngineSingletons.singleton
import entity.AbstractEntity
import entity.AbstractEntityNode
import entity.Entity
import game.GameManager
import godot.Node2D
import godot.Timer
import godot.annotation.RegisterClass
import godot.annotation.RegisterFunction
import graphics.BattleCamera
import utils.helpers.node

@RegisterClass
class BattleScene() : Node2D() {
	private lateinit var gameManager: GameManager

	private lateinit var camera: BattleCamera

	internal lateinit var params: BattleParams

	private val characters: HashMap<Entity<out AbstractEntityNode>, Node2D> = hashMapOf()

	private val opponents: HashMap<AbstractEntity<out AbstractEntityNode>, Node2D> = hashMapOf()

	private val initialTimer: Timer = Timer().apply {
		connect("timeout", this@BattleScene, "play_starting_animation")
		waitTime = 1.0
		oneShot = true
		autostart = false
	}

	@RegisterFunction
	override fun _ready() {
		this.gameManager = singleton("GameManager")
		this.params = gameManager.battleParams
		this.camera = node("BattleCamera")
		addChild(initialTimer)

		generateBattle()
	}

	private fun generateBattle() {
		initialTimer.start()
	}

	@RegisterFunction
	fun playStartingAnimation() {
		camera.playStartingAnimation()
		initialTimer.queueFree()
	}
}