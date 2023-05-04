extends Label

const INTERVAL = 1.0

var timer = Timer.new()

func _ready():
	timer.connect("timeout", self, "on_timeout")
	timer.wait_time = INTERVAL
	timer.one_shot = false
	timer.autostart = true
	add_child(timer)
	on_timeout()

func on_timeout() -> void:
	text = "FPS: " + str(Engine.get_frames_per_second()) + "/" + str(Engine.target_fps) + "\n" + "RAM: " + str(int(Performance.get_monitor(4) / 1048576)) + "M/" + str(int(Performance.get_monitor(3) / 1048576)) + "M\n" + "Rendering:\n" + "  Resolution: " + str(OS.window_size.x) + "x" + str(OS.window_size.y) + "\n" + "  VRAM: " + str(int(Performance.get_monitor(20) / 1024)) + "K\n" + "    Texture: " + str(int(Performance.get_monitor(21) / 1024)) + "K\n" + "    Vertex: " + str(int(Performance.get_monitor(22) / 1024)) + "K\n" + "Objects: " + str(int(Performance.get_monitor(8))) + "\n" + "  Nodes: " + str(int(Performance.get_monitor(10))) + " (" + str(int(Performance.get_monitor(11))) + " orphans)\n" +  "  Resources: " + str(int(Performance.get_monitor(9))) + "\n" + "Physics: " + str(int(Performance.get_monitor(2) * 1000)) + "ms/step (" + str(int(Performance.get_monitor(2) * Engine.iterations_per_second * 100)) + "%)\n" + "  Active: " + str(int(Performance.get_monitor(24))) + "\n" + "  Collision pairs: " + str(int(Performance.get_monitor(25)))
