package ui.battle

import battle.entity.AbstractEntity
import battle.entity.AbstractEntityNode
import godot.Control
import godot.annotation.RegisterClass
import godot.annotation.RegisterFunction

@RegisterClass
class EntityOverlay : Control() {
	private lateinit var entity: AbstractEntity<out AbstractEntityNode>

	@RegisterFunction
	override fun _ready() {

	}

	internal fun attachEntity(entity: AbstractEntity<out AbstractEntityNode>) {
		this.entity = entity
		updateOverlay()
	}

	@RegisterFunction
	fun updateOverlay() {

	}
}