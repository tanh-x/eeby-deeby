package battle.entity.character.kew

import battle.entity.character.AbstractCharacterNode
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