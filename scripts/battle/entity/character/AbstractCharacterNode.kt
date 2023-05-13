package battle.entity.character

import battle.entity.AbstractEntityNode
import godot.Sprite
import godot.annotation.RegisterClass
import godot.annotation.RegisterFunction
import godot.global.GD
import utils.Constants.CHARACTER_ASSET_DIR

@RegisterClass
abstract class AbstractCharacterNode : AbstractEntityNode {
	/**
	 * Default constructor for Godot-Kotlin/
	 */
	constructor() : super()

	/**
	 * For characters, the entity name must correspond to the identifier used in assets/characters/
	 * Otherwise, the [createSprite] method must be overridden
	 */
	constructor(entityName: String) : super(entityName)

	@RegisterFunction
	override fun _ready() {
		super._ready()
	}

	override fun createSprite(): Sprite = Sprite().apply {
		val identifier: String = entityName.lowercase()
		val assetDir: String = CHARACTER_ASSET_DIR + identifier
		texture = GD.load("$assetDir/default.png")
	}
}