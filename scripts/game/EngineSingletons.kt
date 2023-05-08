
import godot.Node
import utils.helpers.node

internal object EngineSingletons {
	private val singletons: HashMap<String, Node> = hashMapOf()

	@Suppress("UNCHECKED_CAST")
	internal fun <T : Node> Node.singleton(path: String): T = singletons.getOrPut(path) { node("/root/$path") } as T

}