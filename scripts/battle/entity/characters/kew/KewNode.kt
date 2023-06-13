package battle.entity.characters.kew

import battle.entity.characters.AbstractCharacterNode
import godot.annotation.RegisterClass
import godot.annotation.RegisterFunction

@RegisterClass
class KewNode : AbstractCharacterNode(entityName = "Kew") {

	@RegisterFunction
	override fun _ready() {
		super._ready()
		println("KewNode ready")
	}
}