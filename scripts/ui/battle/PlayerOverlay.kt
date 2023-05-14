package ui.battle

import battle.entity.AbstractEntity
import battle.entity.character.AbstractCharacter
import battle.entity.character.AbstractCharacterNode
import godot.annotation.RegisterClass
import godot.annotation.RegisterFunction

@RegisterClass
class PlayerOverlay : EntityOverlay() {
	private lateinit var character: AbstractCharacter<out AbstractCharacterNode>

	@RegisterFunction
	override fun _ready() {
		super._ready()
	}

	override fun attachEntity(entity: AbstractEntity<*>) {
		super.attachEntity(entity)
		this.character = entity as AbstractCharacter<out AbstractCharacterNode>
	}
}