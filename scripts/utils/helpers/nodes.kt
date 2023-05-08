package utils.helpers

import godot.Node
import godot.PackedScene
import godot.core.NodePath
import godot.global.GD.load
import java.io.FileNotFoundException
import kotlin.reflect.KClass

internal fun <T> Node.node(path: String): T = getNode(NodePath(path)) as T
	?: throw NullPointerException("Node path $path not found")

internal operator fun <T> godot.Object.get(property: String): T = this.get(property) as T
	?: throw NullPointerException("Property $property doesn't exist on node $this")

internal operator fun godot.Object.set(param: String, value: Any?) {
	val clazz: KClass<*> = this.get(param)?.let { it::class } ?: throw NullPointerException("Property $param not found")
	if (!clazz.isInstance(value)) throw IllegalArgumentException("$value is incompatible type $clazz of property $param")
	this.set(param, value)
}

internal fun <T : Node> instantiateScene(path: String, noCache: Boolean = false): T {
	val sceneResource: PackedScene = load(path)
		?: throw FileNotFoundException("Resource path $path doesn't exist")
	return sceneResource.instance() as T? ?: throw UnknownError("Failed to instantiate $path")
}