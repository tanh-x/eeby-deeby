package battle.entity.characternodes

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