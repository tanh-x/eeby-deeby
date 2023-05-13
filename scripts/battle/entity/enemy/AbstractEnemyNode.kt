package battle.entity.enemy

import battle.entity.AbstractEntityNode
import godot.Sprite
import godot.annotation.RegisterClass
import godot.annotation.RegisterFunction
import godot.global.GD
import utils.Constants.ENEMY_ASSET_DIR

@RegisterClass
abstract class AbstractEnemyNode : AbstractEntityNode {
	/**
	 * Default constructor for Godot-Kotlin/
	 */
	constructor() : super()

	/**
	 * For enemies, the entity name must correspond to the identifier used in assets/entity/enemy/
	 * Otherwise, the [createSprite] method must be overridden
	 */
	constructor(entityName: String) : super(entityName)

	@RegisterFunction
	override fun _ready() {
		super._ready()
		println("AbstractEnemyNode ready")
	}

	override fun createSprite(): Sprite = Sprite().apply {
		val identifier: String = entityName.lowercase()
		val assetDir: String = ENEMY_ASSET_DIR + identifier
		texture = GD.load("$assetDir/$identifier.png")
	}
}