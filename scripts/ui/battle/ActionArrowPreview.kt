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
import utils.helpers.rgb
import utils.helpers.rgba

@RegisterClass
class ActionArrowPreview : Path2D {
    constructor() : super()

    internal constructor(
        source: AbstractEntity<out AbstractEntityNode>,
        targets: Collection<AbstractEntity<out AbstractEntityNode>>
    ) : this() {
        this.source = source
        this.targets = targets
    }

    init {
        name = "ActionArrow"
        selfModulate = Color.white
    }

    private var source: AbstractEntity<out AbstractEntityNode>? = null
        set(value) {
            field = value?.also { ent -> arrowTailPosition = ent.node.overlay.centroidGlobalPosition() }
        }
    private var targets: Collection<AbstractEntity<out AbstractEntityNode>> = emptyList()
        set(value) {
            field = value
            targetOverlays = value.map { ent -> ent.node.overlay }
        }
    private lateinit var targetOverlays: Collection<EntityOverlay>
    private lateinit var arrowTailPosition: Vector2

    @RegisterFunction
    override fun _ready() {

    }

    @RegisterFunction
    override fun _process(delta: Double) {

    }

    @RegisterFunction
    override fun _draw() {
        val globalMousePosition: Vector2 = getGlobalMousePosition()

        val target: EntityOverlay? = targetOverlays.firstOrNull { it._hasPoint(globalMousePosition) }

        if (target != null) {
            drawLine(
                from = arrowTailPosition,
                to = target.centroidGlobalPosition(),
                color = COLOR_TARGETED,
                width = WIDTH_TARGETED,
                antialiased = true
            )
        } else {
            drawLine(
                from = arrowTailPosition,
                to = globalMousePosition,
                color = COLOR_DFLT,
                width = WIDTH_DFLT,
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
        @JvmStatic
        val COLOR_DFLT: Color = 0x1e89b3.rgba(0.8)

        @JvmStatic
        val COLOR_TARGETED: Color = 0x48ffaf.rgba(0.8)

        /**
         * The default width of the arrow.
         */
        const val WIDTH_DFLT: Double = 8.0

        /**
         * The default width of the arrow.
         */
        const val WIDTH_TARGETED: Double = 15.0
    }
}