package battle.entity.enemy

import battle.entity.AbstractEntityNode
import godot.annotation.RegisterClass
import godot.annotation.RegisterFunction

@RegisterClass
abstract class AbstractEnemyNode: AbstractEntityNode() {
	@RegisterFunction
	override fun _ready() {
		println("AbstractEnemyNode")
	}

}