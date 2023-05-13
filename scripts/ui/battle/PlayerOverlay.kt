package ui.battle

import battle.entity.character.AbstractCharacter
import godot.Control
import godot.annotation.RegisterClass
import godot.annotation.RegisterFunction

@RegisterClass
class PlayerOverlay : Control() {
	private lateinit var character: AbstractCharacter<*>

	@RegisterFunction
	override fun _ready() {

	}

	internal fun attachCharacter(character: AbstractCharacter<*>) {
		this.character = character
		updateOverlay()
	}

	@RegisterFunction
	fun updateOverlay() {

	}
}