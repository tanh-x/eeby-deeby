package graphics.artist

import godot.CanvasItem
import godot.core.Color
import godot.core.Vector2
import graphics.artist.Artist2D.Companion.LineStyle.SOLID
import utils.helpers.Palette

internal class Artist2D(
	private val canvas: CanvasItem
) {
	private var color: Color = Palette.BLACK
	private var lineWidth: Double = 5.00
	private var lineStyle: LineStyle = SOLID
	private var antialiasing: Boolean = true

	internal fun setColor(color: Color): Artist2D = apply {
		this.color = color
	}

	internal fun setLineWidth(lineWidth: Double): Artist2D = apply {
		this.lineWidth = lineWidth
	}

	internal fun setLineStyle(lineStyle: LineStyle): Artist2D = apply {
		this.lineStyle = lineStyle
	}

	internal fun setAntialiasing(antialiasing: Boolean): Artist2D = apply {
		this.antialiasing = antialiasing
	}

	internal fun set(
		c: Color? = null,
		lw: Double? = null,
		ls: String? = null
	): Artist2D = apply {
		c?.let { setColor(it) }
		lw?.let { setLineWidth(it) }
		ls?.let { setLineStyle(LineStyle.fromString(it)) }
	}

	internal fun drawLine(
		from: Vector2,
		to: Vector2,
		color: Color = this.color,
		width: Double = lineWidth,
	) {
		canvas.drawLine(from, to, color, width)
	}

	companion object {
		internal fun CanvasItem.artist2D(): Artist2D = Artist2D(this)

		enum class LineStyle {
			SOLID, DASHED, DOTTED;

			companion object {
				@JvmStatic
				fun fromString(s: String): LineStyle = when (s) {
					"-"      -> SOLID
					"--"     -> DASHED
					":", "." -> DOTTED
					else     -> throw IllegalArgumentException("$s is not a valid line style")
				}
			}
		}
	}
}