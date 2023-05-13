package battle.entity.character

import godot.Sprite
import godot.Texture
import godot.annotation.RegisterClass
import godot.annotation.RegisterFunction
import godot.global.GD

@RegisterClass
class AjNode : AbstractCharacterNode() {
	override val entityName: String = "AJ"

	@RegisterFunction
	override fun _ready() {
		super._ready()
		println("AjNode ready")
	}
}
