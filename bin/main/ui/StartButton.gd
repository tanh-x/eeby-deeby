extends Button


onready var game_manager = get_node("/root/GameManager")

func _ready():
	connect("pressed", self, "_button_pressed")


func _button_pressed():
	game_manager.switch_to_battle()
