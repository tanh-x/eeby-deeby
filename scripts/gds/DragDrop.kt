package gds

import godot.core.Vector2

interface DragDrop {
	fun gdGetDragData(position: Vector2): Any?
	fun gdCanDropData(position: Vector2, data: Any?): Boolean
	fun gdDropData(position: Vector2, data: Any?)
}