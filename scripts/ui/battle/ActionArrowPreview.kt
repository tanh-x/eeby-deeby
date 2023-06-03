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
import graphics.artist.Artist2D
import graphics.artist.Artist2D.Companion.artist2D
import utils.helpers.Palette
import utils.helpers.alpha
import utils.helpers.centroidGlobalPosition

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
		name = "ActionArrowPreview"
		selfModulate = Palette.WHITE
	}

	private val artist: Artist2D = artist2D().set(c = COLOR_DFLT, lw = WIDTH_DFLT, ls = "-")

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
	override fun _draw() {
		val globalMousePosition: Vector2 = getGlobalMousePosition()
		val target: EntityOverlay? = targetOverlays.firstOrNull { it._hasPoint(globalMousePosition) }

		if (target == null) {
			artist.drawLine(
				from = arrowTailPosition,
				to = globalMousePosition
			)
		} else {
			artist.drawLine(
				from = arrowTailPosition,
				to = target.centroidGlobalPosition(),
				color = COLOR_TARGETED,
				width = WIDTH_TARGETED,
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
		val COLOR_DFLT: Color = Palette.TEAL_600.alpha(0.76)

		@JvmStatic
		val COLOR_TARGETED: Color = Palette.TEAL_500.alpha(0.85)

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
