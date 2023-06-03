package ui.battle

import battle.core.Action
import godot.Control
import godot.Path2D
import godot.annotation.RegisterClass
import godot.annotation.RegisterFunction
import godot.core.Vector2
import graphics.artist.Artist2D
import utils.helpers.Palette
import utils.helpers.centroid
import utils.helpers.node
import utils.helpers.toScreenSpace

@RegisterClass
class ActionArrow : Path2D() {

	init {
		name = "ActionArrow"
		selfModulate = Palette.WHITE
	}

	private lateinit var action: Action

	private lateinit var sourceEndpoint: Control
	private lateinit var sinkEndpoint: Control

	internal fun withAction(action: Action): ActionArrow = apply {
		println("[ActionArrow] Creating new arrow")
		this.action = action
	}

	@RegisterFunction
	override fun _ready() {
		sourceEndpoint = node("SourceEndpoint")
		sinkEndpoint = node("SinkEndpoint")

		if (!::action.isInitialized) {
			throw UninitializedPropertyAccessException(
				"Action property was not initialized. This is probably because the ActionArrow" +
				"has no actions attached to it. Use ActionArrow.with(Action) before adding the" +
				"node to the scene tree."
			)
		}

		sourceEndpoint.setGlobalPosition(action.actor.node.overlay.centroid())
		sinkEndpoint.setGlobalPosition(action.target.node.overlay.centroid())
		name = "ActionArrow $action"
	}

	@RegisterFunction
	override fun _draw() {
		val actorPosition: Vector2 = sourceEndpoint.rectGlobalPosition
		val targetPosition: Vector2 = sinkEndpoint.rectGlobalPosition

		println("Here?")

		Artist2D.drawQuadraticBezier(
			canvas = this,
			from = actorPosition,
			to = targetPosition,
			controlPoint = Vector2(
				x = 0.5 * (actorPosition.x + targetPosition.x),
				y = 0.5 * (actorPosition.y + targetPosition.y),
			) - Vector2(0.0, 0.35).toScreenSpace(),
			numPoints = 48,
			color = action.type.arrowColor,
			lineWidth = 8.0
		)
	}
}
