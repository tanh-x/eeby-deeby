package battle.entity.characternodes

import godot.annotation.RegisterClass
import godot.annotation.RegisterFunction

@RegisterClass
class JadNode : AbstractCharacterNode(entityName = "Jad") {
	@RegisterFunction
	override fun _ready() {
		super._ready()
		println("JadNode ready")
	}
}