package battle.entity

import godot.Node2D
import godot.Sprite
import godot.annotation.RegisterClass
import godot.annotation.RegisterFunction
import godot.core.Vector2

@RegisterClass
abstract class AbstractEntityNode : Node2D() {
	internal abstract val entityName: String
	internal lateinit var sprite: Sprite

	@RegisterFunction
	override fun _ready() {
		name = entityName
		sprite = createSprite().apply {
			scale = DEFAULT_SCALE
			this@AbstractEntityNode.addChild(this)
		}

		println("AbstractEntNode")
	}

	protected abstract fun createSprite(): Sprite

	companion object {
		val DEFAULT_SCALE: Vector2 = Vector2(0.5, 0.5)
	}
}