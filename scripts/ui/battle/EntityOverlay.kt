package ui.battle

import battle.entity.AbstractEntity
import godot.Control
import godot.annotation.RegisterClass
import godot.annotation.RegisterFunction
import utils.helpers.node

@RegisterClass
open class EntityOverlay : Control() {
	internal lateinit var entity: AbstractEntity<*>

	private lateinit var healthbar: Healthbar

	@RegisterFunction
	override fun _ready() {
		healthbar = node<Healthbar>("Healthbar").apply {

		}
	}

	internal open fun attachEntity(entity: AbstractEntity<*>) {
		this.entity = entity
		updateAll()
	}

	@RegisterFunction
	open fun updateAll() {

	}
}