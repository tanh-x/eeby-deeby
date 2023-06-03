package graphics.artist

import godot.CanvasItem
import godot.core.Color
import godot.core.Vector2
import utils.helpers.Palette.BLACK
import utils.helpers.math.QuadraticBezier

/**
 * The Artist2D class represents an "artist" object that contains helper methods to draw various shapes
 * on a [CanvasItem].
 */
internal class Artist2D(
	/**
	 * The [CanvasItem] node on which the shapes will be drawn.
	 */
	private val canvas: CanvasItem
) {
	/**
	 * The color used for drawing. Defaults to [BLACK]
	 */
	private var color: Color = BLACK

	/**
	 * The width of the lines drawn. Defaults to 5px
	 */
	private var lineWidth: Double = 5.00

	/**
	 * Represents the line style used for drawing. This property is currently unused.
	 */
	private var lineStyle: LineStyle = LineStyle.SOLID

	/**
	 * Indicates whether antialiasing is enabled for drawing. Defaults to true
	 */
	private var antialiasing: Boolean = true

	/**
	 * Currently unused
	 */
	private var resampler: Nothing? = null

	/**
	 * Sets the color used for drawing.
	 * @return The updated [Artist2D] instance
	 */
	internal fun setColor(color: Color): Artist2D = apply {
		this.color = color
	}

	/**
	 * Sets the width of the lines drawn.
	 * @return The updated [Artist2D] instance
	 */
	internal fun setLineWidth(lineWidth: Double): Artist2D = apply {
		this.lineWidth = lineWidth
	}

	/**
	 * Sets the style of the lines drawn.
	 * @return The updated [Artist2D] instance
	 */
	internal fun setLineStyle(lineStyle: LineStyle): Artist2D = apply {
		this.lineStyle = lineStyle
	}

	/**
	 * Matplotlib-style API for setting parameters
	 *
	 * @param c The color to set to.
	 * @param lw The line width to set to.
	 * @param ls A string representing the style, can be "-", "--", or ":". (See [LineStyle])
	 *
	 * @return The updated [Artist2D] instance
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
	 * Draws a line from the specified starting point to the ending point. Can only be used within
	 * a _draw() call.
	 *
	 * @param from
	 * @param to
	 * @param color
	 * @param lineWidth
	 */
	internal fun drawLine(
		from: Vector2, to: Vector2,
		color: Color = this.color,
		lineWidth: Double = this.lineWidth
	) {
		Companion.drawLine(canvas, from, to, color, lineWidth, antialiasing)
	}

	/**
	 * Draws a path connecting the specified points. Can only be used within a _draw() call.
	 *
	 * @param points
	 * @param color
	 * @param lineWidth
	 * @param cyclic
	 */
	internal fun drawPath(
		points: List<Vector2>,
		color: Color = this.color,
		lineWidth: Double = this.lineWidth,
		cyclic: Boolean = false
	) {
		Companion.drawPath(canvas, points, color, lineWidth, antialiasing, cyclic)
	}

	/**
	 * Draws a quadratic Bézier curve from the starting point to the ending point, controlled by a specified
	 * control point. Can only be used within a _draw() call.
	 *
	 * @param from
	 * @param to
	 * @param controlPoint
	 * @param numPoints
	 * @param color
	 * @param lineWidth
	 */
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
		 * Extension method that creates an instance of [Artist2D] associated with the [CanvasItem] at
		 * which it was called (extended) from.
		 */
		internal fun CanvasItem.artist2D(): Artist2D = Artist2D(this)

		/**
		 *
		 */
		enum class LineStyle {
			SOLID, DASHED, DOTTED;

			companion object {
				/**
				 * Converts a string representation of a line style to the corresponding LineStyle enum value.
				 *
				 * @param s: The string representation of the line style.
				 * @return the LineStyle enum value corresponding to the input string.
				 * @throws IllegalArgumentException if the input string does not represent a valid line style.
				 */
				@JvmStatic
				fun fromString(s: String): LineStyle = when (s) {
					"-"  -> SOLID
					"--" -> DASHED
					":"  -> DOTTED
					else -> throw IllegalArgumentException("$s is not a valid line style")
				}
			}
		}
	}
}