package battle.entity.characternodes

import godot.annotation.RegisterClass
import godot.annotation.RegisterFunction

@RegisterClass
class DogmanNode : AbstractCharacterNode(entityName = "Dogman") {
	@RegisterFunction
	override fun _ready() {
		super._ready()
		println("DogmanNode ready")
	}
}