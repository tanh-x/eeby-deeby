package battle.entity.character.aj

import battle.entity.character.AbstractCharacterNode
import core.PlayerCharacter
import godot.annotation.RegisterClass
import godot.annotation.RegisterFunction

@RegisterClass
class AjNode : AbstractCharacterNode(entityName = PlayerCharacter.AJ.label) {
	@RegisterFunction
	override fun _ready() {
		super._ready()
		println("AjNode ready")
	}
}
