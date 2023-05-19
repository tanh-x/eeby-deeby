package character.aj

import character.AbstractCharacterNode
import character.MemberCharacter
import godot.annotation.RegisterClass
import godot.annotation.RegisterFunction

@RegisterClass
class AjNode : AbstractCharacterNode(entityName = MemberCharacter.AJ.label) {
	@RegisterFunction
	override fun _ready() {
		super._ready()
		println("AjNode ready")
	}
}
