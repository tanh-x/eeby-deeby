import core.GameManager
import godot.Node
import utils.helpers.node

/**
 * Memoization for fetching global singletons.
 */
internal object EngineSingletons {
    private val singletons: HashMap<String, Node> = hashMapOf()

    @Suppress("UNCHECKED_CAST")
    internal fun <T : Node> Node.singleton(path: String): T = singletons.getOrPut(path) { node("/root/$path") } as T

    /**
     * Helper function to get the [core.GameManager]
     */
    internal fun Node.getManager(): GameManager =
        singletons.getOrPut("GameManager") { node("/root/GameManager") } as GameManager
}