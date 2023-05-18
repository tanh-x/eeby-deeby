package character.wiewior

import character.AbstractCharacterNode
import godot.annotation.RegisterClass
import godot.annotation.RegisterFunction

@RegisterClass
class WiewiorNode : AbstractCharacterNode(entityName = "Wiewior") {
	@RegisterFunction
	override fun _ready() {
		super._ready()
		println("WiewiorNode ready")
	}
}