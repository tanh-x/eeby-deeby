package battle.entity.characternodes

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
