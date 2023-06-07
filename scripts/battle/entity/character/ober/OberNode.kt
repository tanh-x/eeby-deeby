package battle.entity.character.ober

import battle.entity.character.AbstractCharacterNode
import core.PlayerCharacter
import godot.annotation.RegisterClass
import godot.annotation.RegisterFunction

@RegisterClass
class OberNode : AbstractCharacterNode(entityName = PlayerCharacter.OBER.label) {
	@RegisterFunction
	override fun _ready() {
		super._ready()
		println("OberNode ready")
	}
}