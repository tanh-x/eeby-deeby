package battle.entity.characternodes

import godot.annotation.RegisterClass
import godot.annotation.RegisterFunction

@RegisterClass
class MavesNode : AbstractCharacterNode(entityName = "Maves") {
	@RegisterFunction
	override fun _ready() {
		super._ready()
		println("MavesNode ready")
	}
}