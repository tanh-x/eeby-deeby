package graphics.camera

import godot.annotation.RegisterClass
import godot.annotation.RegisterFunction
import godot.core.Vector2

/**
 * Custom camera for [battle.BattleScene]
 */
@RegisterClass
class BattleCamera : SmoothCamera() {

    @RegisterFunction
    override fun _ready() {
        super._ready()
        zoom = Vector2(2.45, 2.45)
        targetZoom = zoom
    }

    @RegisterFunction
    override fun _physicsProcess(delta: Double) {
        super._physicsProcess(delta)
    }

    internal fun playStartingAnimation() {
        targetZoom = Vector2(0.85, 0.85)
    }
}