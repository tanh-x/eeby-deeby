package character.aj

import character.AbstractCharacterNode
import godot.annotation.RegisterClass
import godot.annotation.RegisterFunction

@RegisterClass
class AjNode : AbstractCharacterNode(entityName = "AJ") {
	@RegisterFunction
	override fun _ready() {
		super._ready()
		println("AjNode ready")
	}
}
