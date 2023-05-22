package utils.helpers

import godot.*
import godot.core.NodePath
import godot.core.Vector2
import utils.exception.NoSuchPropertyException
import utils.exception.NoSuchResourceException
import kotlin.reflect.KClass

/**
 * This extension function gets a node by its string path and casts it into the type parameter [T].
 * Will throw a [NoSuchPropertyException] if the path doesn't exist
 *
 * @param T The type of the property. This will not be type checked at compile time.
 * @param path The path to the node, can take both local and absolute paths.
 * @return The node to fetch
 *
 * @throws NoSuchPropertyException if the node path doesn't exist
 */
@Suppress("UNCHECKED_CAST")
internal fun <T> Node.node(path: String): T = getNode(NodePath(path)) as T
    ?: throw NoSuchPropertyException("Node path $path not found")

/**
 * Gets an object's property and casts it into the type parameter [T]
 * Will throw a [NoSuchPropertyException] if the property doesn't exist
 *
 * @param T The type of the property. This will not be type checked at compile time.
 * @param property The property identifier
 * @return The value of that property, as type [T]
 *
 * @throws NoSuchPropertyException if the property doesn't exist
 */
@Suppress("UNCHECKED_CAST")
internal operator fun <T> Object.get(property: String): T = this.get(property) as T
    ?: throw NoSuchPropertyException("Property $property doesn't exist on node $this")


/**
 * Sets an object's property safely. Will throw a [IllegalArgumentException] instead of an
 * unpredictable error by the engine if the type doesn't match.
 * Will throw a [NoSuchPropertyException] if the property doesn't exist
 *
 * @param property The property identifier
 *
 * @throws NoSuchPropertyException if the property doesn't exist
 */
internal operator fun Object.set(property: String, value: Any?) {
    val clazz: KClass<*> =
        this.get(property)?.let { it::class } ?: throw NoSuchPropertyException("Property $property not found")
    if (!clazz.isInstance(value)) throw IllegalArgumentException("$value is incompatible to type $clazz of property $property")
    this.set(property, value)
}

/**
 * Loads and instantiates a scene from a .tscn file
 *
 * @param path The file path (starts with res://, which is not validated by the method)
 * @param noCache if true, the resource cache will be bypassed and the resource will be loaded anew.
 * Otherwise, the cached resource will be returned if it exists.
 *
 * @throws NoSuchResourceException if the file path doesn't exist
 * @throws InstantiationError if [PackedScene.instance] fails for any reason.
 */
@Suppress("UNCHECKED_CAST")
internal fun <T : Node> instantiateScene(path: String, noCache: Boolean = false): T {
    val sceneResource: PackedScene = ResourceLoader.load(path, noCache = noCache) as PackedScene?
        ?: throw NoSuchResourceException("Resource path $path doesn't exist")
    return sceneResource.instance() as T? ?: throw InstantiationError("Failed to instantiate $path")
}

/**
 * Calculates the global position of the center of a [Control] node.
 *
 * @return The Vector2 representing the position of the centroid
 */
internal fun Control.centroidGlobalPosition(): Vector2 = rectGlobalPosition + rectSize * 0.5