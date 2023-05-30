package ui.battle

import battle.core.Action
import godot.Control
import godot.annotation.RegisterClass
import godot.annotation.RegisterFunction
import utils.helpers.node

@RegisterClass
class ActionArrow() : Control() {
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

		sourceEndpoint.setGlobalPosition(action.actor.node.globalPosition)
		sinkEndpoint.setGlobalPosition(action.target.node.globalPosition)
		name = "ActionArrow $action"
	}
}
