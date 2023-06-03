package graphics.artist

import godot.CanvasItem
import godot.core.Color
import godot.core.Vector2
import utils.helpers.Palette
import utils.helpers.math.QuadraticBezier

internal class Artist2D(
	private val canvas: CanvasItem
) {
	/**
	 *
	 */
	private var color: Color = Palette.BLACK

	/**
	 *
	 */
	private var lineWidth: Double = 5.00

	/**
	 * Currently unused
	 */
	private var lineStyle: LineStyle = LineStyle.SOLID

	/**
	 *
	 */
	private var antialiasing: Boolean = true

	/**
	 * Currently unused
	 */
	private var resampler: Nothing? = null

	/**
	 *
	 */
	internal fun setColor(color: Color): Artist2D = apply {
		this.color = color
	}

	/**
	 *
	 */
	internal fun setLineWidth(lineWidth: Double): Artist2D = apply {
		this.lineWidth = lineWidth
	}

	/**
	 *
	 */
	internal fun setLineStyle(lineStyle: LineStyle): Artist2D = apply {
		this.lineStyle = lineStyle
	}

	/**
	 * Matplotlib-style API for setting parameters
	 */
	internal fun set(
		c: Color? = null,
		lw: Double? = null,
		ls: String? = null
	): Artist2D = apply {
		c?.let { setColor(it) }
		lw?.let { setLineWidth(it) }
		ls?.let { setLineStyle(LineStyle.fromString(it)) }
	}

	/**
	 *
	 */
	internal fun drawLine(
		from: Vector2, to: Vector2,
		color: Color = this.color,
		lineWidth: Double = this.lineWidth
	) {
		Companion.drawLine(canvas, from, to, color, lineWidth, antialiasing)
	}

	/**
	 *
	 */
	internal fun drawPath(
		points: List<Vector2>,
		color: Color = this.color,
		lineWidth: Double = this.lineWidth,
		cyclic: Boolean = false
	) {
		Companion.drawPath(canvas, points, color, lineWidth, antialiasing, cyclic)
	}

	internal fun drawQuadraticBezier(
		from: Vector2,
		to: Vector2,
		controlPoint: Vector2,
		numPoints: Int,
		color: Color = this.color,
		lineWidth: Double = this.lineWidth
	) {
		Companion.drawQuadraticBezier(canvas, from, to, controlPoint, numPoints, color, lineWidth)
	}

	companion object {
		@JvmStatic
		internal fun drawLine(
			canvas: CanvasItem,
			from: Vector2, to: Vector2,
			color: Color,
			lineWidth: Double,
			antialiasing: Boolean = true,
		) {
			canvas.drawLine(from, to, color, lineWidth, antialiasing)
		}

		@JvmStatic
		internal fun drawPath(
			canvas: CanvasItem,
			points: List<Vector2>,
			color: Color,
			lineWidth: Double,
			antialiasing: Boolean,
			cyclic: Boolean = false
		) {
			for (i: Int in 1 until points.size) {
				canvas.drawLine(
					from = points[i - 1],
					to = points[i],
					color = color,
					width = lineWidth,
					antialiased = antialiasing
				)
			}

			if (cyclic) canvas.drawLine(points.last(), points.first(), color, lineWidth, antialiasing)
		}

		@JvmStatic
		internal fun drawQuadraticBezier(
			canvas: CanvasItem,
			from: Vector2,
			to: Vector2,
			controlPoint: Vector2,
			numPoints: Int,
			color: Color,
			lineWidth: Double
		) {
			val points: List<Vector2> = QuadraticBezier(from, to, controlPoint, numPoints)
			drawPath(canvas, points, color, lineWidth, false)
		}

		/**
		 *
		 */
		internal fun CanvasItem.artist2D(): Artist2D = Artist2D(this)

		/**
		 *
		 */
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