package battle.entity.character.murwan

import battle.entity.character.AbstractCharacterNode
import core.PlayerCharacter
import godot.annotation.RegisterClass
import godot.annotation.RegisterFunction

@RegisterClass
class MurwanNode: AbstractCharacterNode(entityName = PlayerCharacter.MURWAN.label) {
	@RegisterFunction
	override fun _ready() {
		super._ready()
		println("MurwanNode ready")
	}
}