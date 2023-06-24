package battle.entity.characternodes

import core.PlayerCharacter
import godot.annotation.RegisterClass
import godot.annotation.RegisterFunction

@RegisterClass
class AelizaNode : AbstractCharacterNode(entityName = PlayerCharacter.AELIZA.label) {
	@RegisterFunction
	override fun _ready() {
		super._ready()
		println("AelizaNode ready")
	}
}
