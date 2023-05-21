package ui.battle

import battle.entity.AbstractEntity
import battle.entity.AbstractEntityNode
import godot.GlobalConstants.BUTTON_LEFT
import godot.InputEvent
import godot.InputEventMouseButton
import godot.Path2D
import godot.annotation.RegisterClass
import godot.annotation.RegisterFunction
import godot.core.Color
import godot.core.Vector2
import utils.helpers.centroidGlobalPosition

@RegisterClass
class ActionArrowPreview : Path2D {
    constructor() : super()

    private var source: AbstractEntity<out AbstractEntityNode>? = null
        set(value) {
            field = value?.also { ent -> arrowTailPosition = ent.node.overlay.centroidGlobalPosition() }
        }
    private var targets: Collection<AbstractEntity<out AbstractEntityNode>> = emptyList()
        set(value) {
            field = value
            targetOverlayRects = value.map { ent -> ent.node.overlay }
        }
    private lateinit var targetOverlayRects: Collection<EntityOverlay>
    private lateinit var arrowTailPosition: Vector2

    internal constructor(
        source: AbstractEntity<out AbstractEntityNode>,
        targets: Collection<AbstractEntity<out AbstractEntityNode>>
    ) : this() {
        this.source = source
        this.targets = targets
    }


    init {
        name = "ActionArrow"
    }

    @RegisterFunction
    override fun _ready() {

    }

    @RegisterFunction
    override fun _process(delta: Double) {

    }

    @RegisterFunction
    override fun _draw() {
        source?.run {
            val globalMousePosition: Vector2 = getGlobalMousePosition()

            drawLine(
                from = arrowTailPosition,
                to = targetOverlayRects.firstOrNull { o -> o._hasPoint(globalMousePosition) }?.centroidGlobalPosition()
                    ?: globalMousePosition,
                color = DEFAULT_COLOR,
                width = 12.0,
                antialiased = true
            )
        }
    }


    @RegisterFunction
    override fun _input(event: InputEvent) {
        update()
        if (event is InputEventMouseButton && event.buttonIndex == BUTTON_LEFT && !event.pressed) queueFree()
    }

    companion object {
        /**
         * Doesn't actually work, not completely.
         */
        @JvmStatic
        val DEFAULT_COLOR: Color = Color(1.0, 1.0, 1.0, 1.0)
    }
}