package battle.entity

import godot.Node2D
import godot.Sprite
import godot.annotation.RegisterClass
import godot.annotation.RegisterFunction
import godot.core.Vector2

@RegisterClass
abstract class AbstractEntityNode() : Node2D() {
	internal var entityName: String = "default"
		private set

	internal lateinit var sprite: Sprite

	protected constructor(entityName: String) : this() {
		this.entityName = entityName
	}

	@RegisterFunction
	override fun _ready() {
		name = entityName
		sprite = createSprite().apply {
			name = "Sprite"
			this@AbstractEntityNode.addChild(this)
		}
	}

	protected abstract fun createSprite(): Sprite

	companion object {
		val DEFAULT_SCALE: Vector2 = Vector2(0.5, 0.5)
	}
}