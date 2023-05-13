package battle.entity.enemy

import godot.annotation.RegisterClass
import godot.annotation.RegisterFunction

@RegisterClass
class BasicEnemyNode : AbstractEnemyNode {
	constructor() : super()
	constructor(entityName: String) : super(entityName)

	@RegisterFunction
	override fun _ready() {
		super._ready()
	}
}