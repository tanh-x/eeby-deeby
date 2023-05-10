package battle.entity.character

import battle.entity.AbstractEntityNode
import godot.annotation.RegisterClass
import godot.annotation.RegisterFunction

@RegisterClass
abstract class AbstractCharacterNode: AbstractEntityNode() {
	@RegisterFunction
	override fun _ready() {
		super._ready()
	}
}