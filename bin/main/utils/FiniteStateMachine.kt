package utils

import godot.Node

/**
 * A finite state machine (FSM) is a set of states, where each state has a transition
 * function that switches the machine to a specified state. This class actually models
 * a state within the FSM, and the actual switch only happens within the [Node]
 *
 * @param T The Godot [Node] that we want to embed the FSM in.
 */
internal interface FiniteStateMachine<T : Node> {
	/**
	 * Calculates and returns the next state of the FSM, doesn't actually switch to it
	 *
	 * @param obj The [Node] of interest
	 */
	fun transitionFunction(obj: T): FiniteStateMachine<T>
}