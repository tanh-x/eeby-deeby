package gds

import godot.Node
import godot.annotation.RegisterClass
import godot.annotation.RegisterFunction
import godot.util.RealT
import utils.helpers.math.formatted

/**
 * Exposes the Java runtime and Java virtual machine to a Godot script.
 */
@RegisterClass
class JvmFacade : Node() {
	private val jvm: Runtime = Runtime.getRuntime()

	@RegisterFunction
	fun memory(): String =
		"${format(jvm.totalMemory() - jvm.freeMemory())} " +
		"(alloc: ${format(jvm.totalMemory())})"

	private fun format(x: Long) = x.formatted(
		digits = 2,
		threshold = 1e3,
		prefixes = BYTE_PREFIXES,
		base = CBRT_1024
	)

	/**
	 * This one is used by ui/PerformanceLabel.gd
	 */
	@RegisterFunction
	fun format(x: RealT) = x.formatted(
		digits = 2,
		threshold = 1e3,
		prefixes = BYTE_PREFIXES,
		base = CBRT_1024
	)

	companion object {
		const val CBRT_1024: Double = 10.079368399158986
		val BYTE_PREFIXES: Array<String> = arrayOf(
			"", "KiB", "MiB", "GiB", "TiB", "PiB"
		)
	}
}
