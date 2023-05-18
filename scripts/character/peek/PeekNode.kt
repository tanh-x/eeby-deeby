package character.peek

import character.AbstractCharacterNode
import godot.annotation.RegisterClass
import godot.annotation.RegisterFunction

@RegisterClass
class PeekNode : AbstractCharacterNode(entityName = "Peek") {
	@RegisterFunction
	override fun _ready() {
		super._ready()
		println("PeekNode ready")
	}
}