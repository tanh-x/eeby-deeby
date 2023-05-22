extends Path2D

func _draw():
	draw_line(
		Vector2(200, 800),
		Vector2(1200, 300),
		Color("#dc59ff"),
		6.0,
		true
	)
