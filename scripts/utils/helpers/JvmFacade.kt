package utils.helpers

import godot.Node
import godot.annotation.RegisterClass
import godot.annotation.RegisterFunction

@RegisterClass
class JvmFacade : Node() {
	private val jvm: Runtime = Runtime.getRuntime()

	@RegisterFunction
	fun memory(): String = "${(jvm.totalMemory() - jvm.freeMemory()) / 1024}K (alloc: ${jvm.totalMemory()/1024}K)"
}