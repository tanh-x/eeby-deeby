package utils.helpers

import godot.core.Color

/**
 * Sets the opacity of the Color to [a]. Note that alpha goes from 0 to 1
 *
 * @param a The new alpha value
 * @return A new [Color] object with the change
 */
internal fun Color.alpha(a: Double) = Color(this).apply { this.a = a }

/**
 * *Increases* the saturation quantity by [deltaS]. Note that saturation goes from 0 to 1
 *
 * @param deltaS The amount of saturation to add
 * @return A new [Color] object with the change
 */
internal fun Color.saturate(deltaS: Double) = Color(this).apply { this.s += deltaS }

// @formatter:off
/**
 * Creates a new color from a 24-bit 0xRRGGBB [Int] literal.
 *
 * @return The resultant [Color] object.
 */
internal fun Int.rgb(): Color = Color(
	r = (this shr 16		) / 255.0,
	g = (this shr 8  and 255) / 255.0,
	b = (this 		 and 255) / 255.0
)

/**
 * Creates a new color from a 24-bit 0xRRGGBB [Int] literal, along with an [alpha]
 * argument for setting the opacity.
 *
 * @param alpha The opacity of the color.
 * @return The resultant [Color] object.
 */
internal fun Int.rgba(alpha: Double): Color = Color(
	r = (this shr 16		) / 255.0,
	g = (this shr 8  and 255) / 255.0,
	b = (this 		 and 255) / 255.0,
	a = alpha
)

/**
 * Creates a new color from a 32-bit 0xRRGGBBAA [Long] literal
 *
 * @return The resultant [Color] object.
 */
internal fun Long.rgba(): Color = Color(
	r = (this shr 24		) / 255.0,
	g = (this shr 16 and 255) / 255.0,
	b = (this shr 8  and 255) / 255.0,
	a = (this 		 and 255) / 255.0
)


/**
 * Color shades from [Tailwind CSS](https://tailwindcss.com/docs/background-color)
 */
@Suppress("Unused")
object Palette {
	val WHITE: Color 		= 0xffffff.rgb()
	val BLACK: Color 		= 0x000000.rgb()

	val SLATE_50: Color 	= 0xf8fafc.rgb()
	val SLATE_100: Color 	= 0xf1f5f9.rgb()
	val SLATE_200: Color 	= 0xe2e8f0.rgb()
	val SLATE_300: Color 	= 0xcbd5e1.rgb()
	val SLATE_400: Color 	= 0x94a3b8.rgb()
	val SLATE_500: Color 	= 0x64748b.rgb()
	val SLATE_600: Color 	= 0x475569.rgb()
	val SLATE_700: Color 	= 0x334155.rgb()
	val SLATE_800: Color 	= 0x1e293b.rgb()
	val SLATE_900: Color 	= 0x0f172a.rgb()
	val SLATE_950: Color 	= 0x020617.rgb()

	val GRAY_50: Color 		= 0xf9fafb.rgb()
	val GRAY_100: Color 	= 0xf3f4f6.rgb()
	val GRAY_200: Color 	= 0xe5e7eb.rgb()
	val GRAY_300: Color 	= 0xd1d5db.rgb()
	val GRAY_400: Color 	= 0x9ca3af.rgb()
	val GRAY_500: Color 	= 0x6b7280.rgb()
	val GRAY_600: Color 	= 0x4b5563.rgb()
	val GRAY_700: Color 	= 0x374151.rgb()
	val GRAY_800: Color 	= 0x1f2937.rgb()
	val GRAY_900: Color 	= 0x111827.rgb()
	val GRAY_950: Color 	= 0x030712.rgb()

	val ZINC_50: Color 		= 0xfafafa.rgb()
	val ZINC_100: Color 	= 0xf4f4f5.rgb()
	val ZINC_200: Color 	= 0xe4e4e7.rgb()
	val ZINC_300: Color 	= 0xd4d4d8.rgb()
	val ZINC_400: Color 	= 0xa1a1aa.rgb()
	val ZINC_500: Color 	= 0x71717a.rgb()
	val ZINC_600: Color 	= 0x52525b.rgb()
	val ZINC_700: Color 	= 0x3f3f46.rgb()
	val ZINC_800: Color 	= 0x27272a.rgb()
	val ZINC_900: Color 	= 0x18181b.rgb()
	val ZINC_950: Color 	= 0x09090b.rgb()

	val NEUTRAL_50: Color 	= 0xfafafa.rgb()
	val NEUTRAL_100: Color 	= 0xf5f5f5.rgb()
	val NEUTRAL_200: Color 	= 0xe5e5e5.rgb()
	val NEUTRAL_300: Color 	= 0xd4d4d4.rgb()
	val NEUTRAL_400: Color 	= 0xa3a3a3.rgb()
	val NEUTRAL_500: Color 	= 0x737373.rgb()
	val NEUTRAL_600: Color 	= 0x525252.rgb()
	val NEUTRAL_700: Color 	= 0x404040.rgb()
	val NEUTRAL_800: Color 	= 0x262626.rgb()
	val NEUTRAL_900: Color 	= 0x171717.rgb()
	val NEUTRAL_950: Color 	= 0x0a0a0a.rgb()

	val STONE_50: Color 	= 0xfafaf9.rgb()
	val STONE_100: Color 	= 0xf5f5f4.rgb()
	val STONE_200: Color 	= 0xe7e5e4.rgb()
	val STONE_300: Color 	= 0xd6d3d1.rgb()
	val STONE_400: Color 	= 0xa8a29e.rgb()
	val STONE_500: Color 	= 0x78716c.rgb()
	val STONE_600: Color 	= 0x57534e.rgb()
	val STONE_700: Color 	= 0x44403c.rgb()
	val STONE_800: Color 	= 0x292524.rgb()
	val STONE_900: Color 	= 0x1c1917.rgb()
	val STONE_950: Color 	= 0x0c0a09.rgb()

	val RED_50: Color 		= 0xfef2f2.rgb()
	val RED_100: Color 		= 0xfee2e2.rgb()
	val RED_200: Color 		= 0xfecaca.rgb()
	val RED_300: Color 		= 0xfca5a5.rgb()
	val RED_400: Color 		= 0xf87171.rgb()
	val RED_500: Color 		= 0xef4444.rgb()
	val RED_600: Color 		= 0xdc2626.rgb()
	val RED_700: Color 		= 0xb91c1c.rgb()
	val RED_800: Color 		= 0x991b1b.rgb()
	val RED_900: Color 		= 0x7f1d1d.rgb()
	val RED_950: Color 		= 0x450a0a.rgb()

	val ORANGE_50: Color 	= 0xfff7ed.rgb()
	val ORANGE_100: Color 	= 0xffedd5.rgb()
	val ORANGE_200: Color 	= 0xfed7aa.rgb()
	val ORANGE_300: Color 	= 0xfdba74.rgb()
	val ORANGE_400: Color 	= 0xfb923c.rgb()
	val ORANGE_500: Color 	= 0xf97316.rgb()
	val ORANGE_600: Color 	= 0xea580c.rgb()
	val ORANGE_700: Color 	= 0xc2410c.rgb()
	val ORANGE_800: Color 	= 0x9a3412.rgb()
	val ORANGE_900: Color 	= 0x7c2d12.rgb()
	val ORANGE_950: Color 	= 0x431407.rgb()

	val AMBER_50: Color 	= 0xfffbeb.rgb()
	val AMBER_100: Color 	= 0xfef3c7.rgb()
	val AMBER_200: Color 	= 0xfde68a.rgb()
	val AMBER_300: Color 	= 0xfcd34d.rgb()
	val AMBER_400: Color 	= 0xfbbf24.rgb()
	val AMBER_500: Color 	= 0xf59e0b.rgb()
	val AMBER_600: Color 	= 0xd97706.rgb()
	val AMBER_700: Color 	= 0xb45309.rgb()
	val AMBER_800: Color 	= 0x92400e.rgb()
	val AMBER_900: Color 	= 0x78350f.rgb()
	val AMBER_950: Color 	= 0x451a03.rgb()

	val YELLOW_50: Color 	= 0xfefce8.rgb()
	val YELLOW_100: Color 	= 0xfef9c3.rgb()
	val YELLOW_200: Color 	= 0xfef08a.rgb()
	val YELLOW_300: Color 	= 0xfde047.rgb()
	val YELLOW_400: Color 	= 0xfacc15.rgb()
	val YELLOW_500: Color 	= 0xeab308.rgb()
	val YELLOW_600: Color 	= 0xca8a04.rgb()
	val YELLOW_700: Color 	= 0xa16207.rgb()
	val YELLOW_800: Color 	= 0x854d0e.rgb()
	val YELLOW_900: Color 	= 0x713f12.rgb()
	val YELLOW_950: Color 	= 0x422006.rgb()

	val LIME_50: Color 		= 0xf7fee7.rgb()
	val LIME_100: Color 	= 0xecfccb.rgb()
	val LIME_200: Color 	= 0xd9f99d.rgb()
	val LIME_300: Color 	= 0xbef264.rgb()
	val LIME_400: Color 	= 0xa3e635.rgb()
	val LIME_500: Color 	= 0x84cc16.rgb()
	val LIME_600: Color 	= 0x65a30d.rgb()
	val LIME_700: Color 	= 0x4d7c0f.rgb()
	val LIME_800: Color 	= 0x3f6212.rgb()
	val LIME_900: Color 	= 0x365314.rgb()
	val LIME_950: Color 	= 0x1a2e05.rgb()

	val GREEN_50: Color 	= 0xf0fdf4.rgb()
	val GREEN_100: Color 	= 0xdcfce7.rgb()
	val GREEN_200: Color 	= 0xbbf7d0.rgb()
	val GREEN_300: Color 	= 0x86efac.rgb()
	val GREEN_400: Color 	= 0x4ade80.rgb()
	val GREEN_500: Color 	= 0x22c55e.rgb()
	val GREEN_600: Color 	= 0x16a34a.rgb()
	val GREEN_700: Color 	= 0x15803d.rgb()
	val GREEN_800: Color 	= 0x166534.rgb()
	val GREEN_900: Color 	= 0x14532d.rgb()
	val GREEN_950: Color 	= 0x052e16.rgb()

	val EMERALD_50: Color 	= 0xecfdf5.rgb()
	val EMERALD_100: Color 	= 0xd1fae5.rgb()
	val EMERALD_200: Color 	= 0xa7f3d0.rgb()
	val EMERALD_300: Color 	= 0x6ee7b7.rgb()
	val EMERALD_400: Color 	= 0x34d399.rgb()
	val EMERALD_500: Color 	= 0x10b981.rgb()
	val EMERALD_600: Color 	= 0x059669.rgb()
	val EMERALD_700: Color 	= 0x047857.rgb()
	val EMERALD_800: Color 	= 0x065f46.rgb()
	val EMERALD_900: Color 	= 0x064e3b.rgb()
	val EMERALD_950: Color 	= 0x022c22.rgb()

	val TEAL_50: Color 		= 0xf0fdfa.rgb()
	val TEAL_100: Color 	= 0xccfbf1.rgb()
	val TEAL_200: Color 	= 0x99f6e4.rgb()
	val TEAL_300: Color 	= 0x5eead4.rgb()
	val TEAL_400: Color 	= 0x2dd4bf.rgb()
	val TEAL_500: Color 	= 0x14b8a6.rgb()
	val TEAL_600: Color 	= 0x0d9488.rgb()
	val TEAL_700: Color 	= 0x0f766e.rgb()
	val TEAL_800: Color 	= 0x115e59.rgb()
	val TEAL_900: Color 	= 0x134e4a.rgb()
	val TEAL_950: Color 	= 0x042f2e.rgb()

	val CYAN_50: Color 		= 0xecfeff.rgb()
	val CYAN_100: Color 	= 0xcffafe.rgb()
	val CYAN_200: Color 	= 0xa5f3fc.rgb()
	val CYAN_300: Color 	= 0x67e8f9.rgb()
	val CYAN_400: Color 	= 0x22d3ee.rgb()
	val CYAN_500: Color 	= 0x06b6d4.rgb()
	val CYAN_600: Color 	= 0x0891b2.rgb()
	val CYAN_700: Color 	= 0x0e7490.rgb()
	val CYAN_800: Color 	= 0x155e75.rgb()
	val CYAN_900: Color 	= 0x164e63.rgb()
	val CYAN_950: Color 	= 0x083344.rgb()

	val SKY_50: Color 		= 0xf0f9ff.rgb()
	val SKY_100: Color 		= 0xe0f2fe.rgb()
	val SKY_200: Color 		= 0xbae6fd.rgb()
	val SKY_300: Color 		= 0x7dd3fc.rgb()
	val SKY_400: Color 		= 0x38bdf8.rgb()
	val SKY_500: Color 		= 0x0ea5e9.rgb()
	val SKY_600: Color 		= 0x0284c7.rgb()
	val SKY_700: Color 		= 0x0369a1.rgb()
	val SKY_800: Color 		= 0x075985.rgb()
	val SKY_900: Color 		= 0x0c4a6e.rgb()
	val SKY_950: Color 		= 0x082f49.rgb()

	val BLUE_50: Color 		= 0xeff6ff.rgb()
	val BLUE_100: Color 	= 0xdbeafe.rgb()
	val BLUE_200: Color 	= 0xbfdbfe.rgb()
	val BLUE_300: Color 	= 0x93c5fd.rgb()
	val BLUE_400: Color 	= 0x60a5fa.rgb()
	val BLUE_500: Color 	= 0x3b82f6.rgb()
	val BLUE_600: Color 	= 0x2563eb.rgb()
	val BLUE_700: Color 	= 0x1d4ed8.rgb()
	val BLUE_800: Color 	= 0x1e40af.rgb()
	val BLUE_900: Color 	= 0x1e3a8a.rgb()
	val BLUE_950: Color 	= 0x172554.rgb()

	val INDIGO_50: Color 	= 0xeef2ff.rgb()
	val INDIGO_100: Color 	= 0xe0e7ff.rgb()
	val INDIGO_200: Color 	= 0xc7d2fe.rgb()
	val INDIGO_300: Color 	= 0xa5b4fc.rgb()
	val INDIGO_400: Color 	= 0x818cf8.rgb()
	val INDIGO_500: Color 	= 0x6366f1.rgb()
	val INDIGO_600: Color 	= 0x4f46e5.rgb()
	val INDIGO_700: Color 	= 0x4338ca.rgb()
	val INDIGO_800: Color 	= 0x3730a3.rgb()
	val INDIGO_900: Color 	= 0x312e81.rgb()
	val INDIGO_950: Color 	= 0x1e1b4b.rgb()

	val VIOLET_50: Color 	= 0xf5f3ff.rgb()
	val VIOLET_100: Color 	= 0xede9fe.rgb()
	val VIOLET_200: Color 	= 0xddd6fe.rgb()
	val VIOLET_300: Color 	= 0xc4b5fd.rgb()
	val VIOLET_400: Color 	= 0xa78bfa.rgb()
	val VIOLET_500: Color 	= 0x8b5cf6.rgb()
	val VIOLET_600: Color 	= 0x7c3aed.rgb()
	val VIOLET_700: Color 	= 0x6d28d9.rgb()
	val VIOLET_800: Color 	= 0x5b21b6.rgb()
	val VIOLET_900: Color 	= 0x4c1d95.rgb()
	val VIOLET_950: Color 	= 0x2e1065.rgb()

	val PURPLE_50: Color 	= 0xfaf5ff.rgb()
	val PURPLE_100: Color 	= 0xf3e8ff.rgb()
	val PURPLE_200: Color 	= 0xe9d5ff.rgb()
	val PURPLE_300: Color 	= 0xd8b4fe.rgb()
	val PURPLE_400: Color 	= 0xc084fc.rgb()
	val PURPLE_500: Color 	= 0xa855f7.rgb()
	val PURPLE_600: Color 	= 0x9333ea.rgb()
	val PURPLE_700: Color 	= 0x7e22ce.rgb()
	val PURPLE_800: Color 	= 0x6b21a8.rgb()
	val PURPLE_900: Color 	= 0x581c87.rgb()
	val PURPLE_950: Color 	= 0x3b0764.rgb()

	val FUCHSIA_50: Color 	= 0xfdf4ff.rgb()
	val FUCHSIA_100: Color 	= 0xfae8ff.rgb()
	val FUCHSIA_200: Color 	= 0xf5d0fe.rgb()
	val FUCHSIA_300: Color 	= 0xf0abfc.rgb()
	val FUCHSIA_400: Color 	= 0xe879f9.rgb()
	val FUCHSIA_500: Color 	= 0xd946ef.rgb()
	val FUCHSIA_600: Color 	= 0xc026d3.rgb()
	val FUCHSIA_700: Color 	= 0xa21caf.rgb()
	val FUCHSIA_800: Color 	= 0x86198f.rgb()
	val FUCHSIA_900: Color 	= 0x701a75.rgb()
	val FUCHSIA_950: Color 	= 0x4a044e.rgb()

	val PINK_50: Color 		= 0xfdf2f8.rgb()
	val PINK_100: Color 	= 0xfce7f3.rgb()
	val PINK_200: Color 	= 0xfbcfe8.rgb()
	val PINK_300: Color 	= 0xf9a8d4.rgb()
	val PINK_400: Color 	= 0xf472b6.rgb()
	val PINK_500: Color 	= 0xec4899.rgb()
	val PINK_600: Color 	= 0xdb2777.rgb()
	val PINK_700: Color 	= 0xbe185d.rgb()
	val PINK_800: Color 	= 0x9d174d.rgb()
	val PINK_900: Color 	= 0x831843.rgb()
	val PINK_950: Color 	= 0x500724.rgb()

	val ROSE_50: Color 		= 0xfff1f2.rgb()
	val ROSE_100: Color 	= 0xffe4e6.rgb()
	val ROSE_200: Color 	= 0xfecdd3.rgb()
	val ROSE_300: Color 	= 0xfda4af.rgb()
	val ROSE_400: Color 	= 0xfb7185.rgb()
	val ROSE_500: Color 	= 0xf43f5e.rgb()
	val ROSE_600: Color 	= 0xe11d48.rgb()
	val ROSE_700: Color 	= 0xbe123c.rgb()
	val ROSE_800: Color 	= 0x9f1239.rgb()
	val ROSE_900: Color 	= 0x881337.rgb()
	val ROSE_950: Color 	= 0x4c0519.rgb()
}
