package battle.entity.character.cyg

import battle.entity.character.AbstractCharacterNode
import core.PlayerCharacter
import godot.annotation.RegisterClass
import godot.annotation.RegisterFunction

@RegisterClass
class CygNode : AbstractCharacterNode(entityName = PlayerCharacter.CYG.label) {
	@RegisterFunction
	override fun _ready() {
		super._ready()
		println("CygNode ready")
	}
}