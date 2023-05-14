package ui.battle

import battle.entity.AbstractEntity
import battle.entity.Vulnerable
import godot.Control
import godot.annotation.RegisterClass
import godot.annotation.RegisterFunction
import utils.helpers.node

@RegisterClass
open class EntityOverlay : Control() {
	internal lateinit var entity: AbstractEntity<*>

	private var entIsVulnerable: Boolean = false

	private lateinit var healthbar: Healthbar

	@RegisterFunction
	override fun _ready() {
		healthbar = node("Healthbar")
	}

	internal open fun attachEntity(entity: AbstractEntity<*>) {
		this.entity = entity
		if (entity is Vulnerable) {
			healthbar.entity = entity
			entIsVulnerable = true
			healthbar.visible = true
		}

		updateAll()
	}

	@RegisterFunction
	open fun updateAll() {
		if (entIsVulnerable) healthbar.rerender()
	}
}