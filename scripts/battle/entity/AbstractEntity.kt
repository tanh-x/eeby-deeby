package battle.entity

import godot.Node2D

abstract class AbstractEntity<N: Node2D> {
	internal lateinit var node: N
}