extends Label

#const INTERVAL = 0.25

#var timer = Timer.new()
var frames = 0
const FRAME_INTERVAL = 24

var jvm = load("res://scripts/utils/helpers/JvmFacade.kt").new()

#func _ready():
#	timer.connect("timeout", self, "on_timeout")
#	timer.wait_time = INTERVAL
#	timer.one_shot = false
#	timer.autostart = true
#	add_child(timer)
#	on_timeout()


#func on_timeout() -> void:
func _process(_delta) -> void:
	if (frames % FRAME_INTERVAL == 0):
		text = "FPS: " + str(Engine.get_frames_per_second()) + "/" + str(Engine.target_fps) + " (" + str(frames) + "f)\n" + "RAM (Godot): " + str(int(Performance.get_monitor(4) / 1024)) + "K / " + str(int(Performance.get_monitor(3) / 1024)) + "K\nRAM (Kotlin/JVM): "+ jvm.memory() +"\n" + "Rendering:\n" + "  Resolution: " + str(OS.window_size.x) + "x" + str(OS.window_size.y) + "\n" + "  VRAM: " + str(int(Performance.get_monitor(20) / 1024)) + "K\n" + "    Texture: " + str(int(Performance.get_monitor(21) / 1024)) + "K\n" + "    Vertex: " + str(int(Performance.get_monitor(22) / 1024)) + "K\n" + "Objects: " + str(int(Performance.get_monitor(8))) + "\n" + "  Nodes: " + str(int(Performance.get_monitor(10))) + " (" + str(int(Performance.get_monitor(11))) + " orphans)\n" +  "  Resources: " + str(int(Performance.get_monitor(9))) + "\n" + "Physics: " + str(int(Performance.get_monitor(2) * 1000)) + "ms/step (" + str(int(Performance.get_monitor(2) * Engine.iterations_per_second * 100)) + "%)\n" + "  Active: " + str(int(Performance.get_monitor(24))) + "\n" + "  Collision pairs: " + str(int(Performance.get_monitor(25))) + "\nScene: " +get_tree().get_current_scene().get_name()
	frames += 1
