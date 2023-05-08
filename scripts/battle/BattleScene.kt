package battle

import godot.Node2D
import godot.annotation.RegisterClass
import godot.annotation.RegisterConstructor

@RegisterClass
class BattleScene() : Node2D() {
	private var params: BattleParams? = null

	@RegisterConstructor
	constructor(params: BattleParams) : this() {
		this.params = params
	}
}