extends Control

onready var parent = get_parent()

func can_drop_data(position, data) -> bool:
	return parent.gd_can_drop_data(position, data)

func get_drag_data(position):
	return parent.gd_get_drag_data(position)

func drop_data(position, data):
	parent.gd_drop_data(position, data)
