package battle.entity

import godot.Label
import godot.Node2D
import godot.Sprite
import godot.annotation.RegisterClass
import godot.annotation.RegisterFunction
import godot.core.Vector2
import ui.battle.EntityOverlay
import utils.helpers.node

@RegisterClass
abstract class AbstractEntityNode() : Node2D() {
	internal abstract var overlay: EntityOverlay
	internal var entityName: String = "default"
		private set

	internal lateinit var sprite: Sprite

	protected constructor(entityName: String) : this() {
		this.entityName = entityName
	}

	internal var isReady: Boolean = false

	@RegisterFunction
	override fun _ready() {
		name = entityName
		sprite = createSprite().apply {
			name = "Sprite"
			this@AbstractEntityNode.addChild(this)
		}

		isReady = true
	}

	protected abstract fun createSprite(): Sprite

	companion object {
		val DEFAULT_SCALE: Vector2 = Vector2(0.5, 0.5)
	}
}