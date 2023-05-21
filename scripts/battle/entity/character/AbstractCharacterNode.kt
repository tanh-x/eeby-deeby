package battle.entity.character

import battle.entity.AbstractEntityNode
import godot.Sprite
import godot.annotation.RegisterClass
import godot.annotation.RegisterFunction
import godot.core.Vector2
import godot.global.GD
import ui.battle.PlayerOverlay
import utils.Constants.CHARACTER_ASSET_DIR
import utils.helpers.instantiateScene

@RegisterClass
abstract class AbstractCharacterNode : AbstractEntityNode {
    internal lateinit var overlay: PlayerOverlay

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

        overlay = instantiateScene("res://scenes/ui/PlayerOverlay.tscn")
        addChild(overlay)
    }

    override fun createSprite(): Sprite = Sprite().apply {
        val identifier: String = entityName.lowercase()
        val assetDir: String = CHARACTER_ASSET_DIR + identifier
        texture = GD.load("$assetDir/default.png")

        offset = Vector2(0, -650.0)  // Place the feet of the sprite at the node's center
    }
}