package battle.entity.character.bnuuy

import battle.entity.character.AbstractCharacterNode
import core.PlayerCharacter
import godot.annotation.RegisterClass
import godot.annotation.RegisterFunction

@RegisterClass
class BnuuyNode : AbstractCharacterNode(entityName = PlayerCharacter.BNUUY.label) {
	@RegisterFunction
	override fun _ready() {
		super._ready()
		println("BnuuyNode ready")
	}
}