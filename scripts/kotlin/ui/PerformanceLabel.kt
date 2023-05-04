package ui

import godot.Engine
import godot.Engine.getFramesPerSecond
import godot.Engine.targetFps
import godot.Label
import godot.OS
import godot.Performance.MEMORY_DYNAMIC
import godot.Performance.MEMORY_STATIC
import godot.Performance.OBJECT_COUNT
import godot.Performance.OBJECT_NODE_COUNT
import godot.Performance.OBJECT_ORPHAN_NODE_COUNT
import godot.Performance.OBJECT_RESOURCE_COUNT
import godot.Performance.PHYSICS_2D_ACTIVE_OBJECTS
import godot.Performance.PHYSICS_2D_COLLISION_PAIRS
import godot.Performance.RENDER_TEXTURE_MEM_USED
import godot.Performance.RENDER_VERTEX_MEM_USED
import godot.Performance.RENDER_VIDEO_MEM_USED
import godot.Performance.TIME_PHYSICS_PROCESS
import godot.Performance.getMonitor
import godot.Timer
import godot.annotation.RegisterClass
import godot.annotation.RegisterFunction
import kotlin.math.round

/**
 * This node handles the performance debug overlay
 */
@RegisterClass
class PerformanceLabel : Label() {
	private val timer: Timer = Timer().apply {
		connect("timeout", this@PerformanceLabel, "on_timeout")
		waitTime = INTERVAL
		oneShot = false
		autostart = true
	}

	private val jvm: Runtime = Runtime.getRuntime()

	@RegisterFunction
	override fun _ready() {
		addChild(timer)
		onTimeout()
	}

	@RegisterFunction
	fun onTimeout() {
		text = """
			FPS: ${getFramesPerSecond()}/$targetFps
			Memory:
			  Godot: ${getMonitor(MEMORY_DYNAMIC).MB()}M/${getMonitor(MEMORY_STATIC).MB()}M
			  Kotlin/JVM: ${(jvm.totalMemory() - jvm.freeMemory()).MB()}M (${jvm.totalMemory().MB()}M allocated)
			Rendering: 
			  Resolution: ${OS.windowSize.run { "${x.toInt()}x${y.toInt()}" }}
			  VRAM: ${getMonitor(RENDER_VIDEO_MEM_USED).KB()}K
			    Texture: ${getMonitor(RENDER_TEXTURE_MEM_USED).KB()}K
			    Vertex: ${getMonitor(RENDER_VERTEX_MEM_USED).KB()}K
			Objects: ${getMonitor(OBJECT_COUNT).toInt()}
			  Nodes: ${getMonitor(OBJECT_NODE_COUNT).toInt()} (${getMonitor(OBJECT_ORPHAN_NODE_COUNT).toInt()} orphans)
			  Resources: ${getMonitor(OBJECT_RESOURCE_COUNT).toInt()}
			Physics: ${getMonitor(TIME_PHYSICS_PROCESS).milli()}ms/step (${(getMonitor(TIME_PHYSICS_PROCESS) * Engine.iterationsPerSecond).percent()}%)
			  Active: ${getMonitor(PHYSICS_2D_ACTIVE_OBJECTS).toInt()}
			  Collision pairs: ${getMonitor(PHYSICS_2D_COLLISION_PAIRS).toInt()}
		""".trimIndent()
	}

	companion object {
		private const val INTERVAL: Double = 1.0

		@JvmStatic
		private fun Long.MB(): Double = round(this / 10485.76) / 100

		@JvmStatic
		private fun Double.MB(): Double = round(this / 10485.76) / 100

		@JvmStatic
		private fun Long.KB(): Double = round(this / 102.4) / 10

		@JvmStatic
		private fun Double.KB(): Double = round(this / 102.4) / 10

		@JvmStatic
		private fun Double.milli(): Double = round(this * 1e5) / 100

		@JvmStatic
		private fun Double.percent(): Double = round(this * 1e4) / 100
	}
}