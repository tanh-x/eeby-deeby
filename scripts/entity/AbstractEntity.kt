package entity

import godot.Node2D

abstract class AbstractEntity<T: Node2D> {
	internal lateinit var node: T

}