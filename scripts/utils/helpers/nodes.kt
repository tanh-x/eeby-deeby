package utils.helpers

import godot.Node
import godot.PackedScene
import godot.ResourceLoader
import godot.core.NodePath
import godot.global.GD.load
import java.io.FileNotFoundException
import kotlin.reflect.KClass

/**
 * This extension function gets a node by its string path and casts it into the type parameter [T].
 * Will throw a [NullPointerException] if the path doesn't exist
 *
 * @param T The type of the property. This will not be type checked at compile time.
 * @param path The path to the node, can take both local and absolute paths.
 * @return The node to fetch
 *
 * @throws NullPointerException if the node path doesn't exist
 */
@Suppress("UNCHECKED_CAST")
internal fun <T> Node.node(path: String): T = getNode(NodePath(path)) as T
	?: throw NullPointerException("Node path $path not found")

/**
 * Gets an object's property and casts it into the type parameter [T]
 * Will throw a [NullPointerException] if the property doesn't exist
 *
 * @param T The type of the property. This will not be type checked at compile time.
 * @param property The property identifier
 * @return The value of that property, as type [T]
 *
 * @throws NullPointerException if the property doesn't exist
 */
@Suppress("UNCHECKED_CAST")
internal operator fun <T> godot.Object.get(property: String): T = this.get(property) as T
	?: throw NullPointerException("Property $property doesn't exist on node $this")


/**
 * Sets an object's property safely. Will throw a [IllegalArgumentException] instead of an
 * unpredictable error by the engine if the type doesn't match.
 * Will throw a []
 *
 * @param T The type of the property. This will not be type checked at compile time.
 * @param property The property identifier
 * @return The value of that property, as type [T]
 *
 * @throws NullPointerException if the property doesn't exist
 */
internal operator fun godot.Object.set(param: String, value: Any?) {
	val clazz: KClass<*> = this.get(param)?.let { it::class } ?: throw NullPointerException("Property $param not found")
	if (!clazz.isInstance(value)) throw IllegalArgumentException("$value is incompatible type $clazz of property $param")
	this.set(param, value)
}

/**
 * Loads and instantiates a scene from a .tscn file
 *
 * @param path The file path (starts with res://, which is not validated by the method)
 * @param noCache if true, the resource cache will be bypassed and the resource will be loaded anew.
 * Otherwise, the cached resource will be returned if it exists.
 *
 * @throws FileNotFoundException if the file path doesn't exist
 * @throws InstantiationError if [PackedScene.instance] fails for any reason.
 */
@Suppress("UNCHECKED_CAST")
internal fun <T : Node> instantiateScene(path: String, noCache: Boolean = false): T {
	val sceneResource: PackedScene = ResourceLoader.load(path, noCache = noCache) as PackedScene?
		?: throw FileNotFoundException("Resource path $path doesn't exist")
	return sceneResource.instance() as T? ?: throw InstantiationError("Failed to instantiate $path")
}