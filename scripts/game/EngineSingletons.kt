import godot.Node
import godot.core.NodePath
import godot.global.GD
import utils.helpers.node
import java.lang.NullPointerException

internal object EngineSingletons {
	private val singletons: HashMap<String, Node> = hashMapOf()

	@Suppress("UNCHECKED_CAST")
	internal fun <T : Node> Node.singleton(path: String): T = singletons.getOrPut(path) { node("/root/$path") } as T

}