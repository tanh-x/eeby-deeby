package battle.entity.characters.dogman

import battle.entity.characters.AbstractCharacterNode
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