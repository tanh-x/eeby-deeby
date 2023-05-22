package utils.helpers

import godot.core.Color

internal fun Int.rgb(): Color = Color(
    r = (this shr 16        ) / 255.0,
    g = (this shr 8  and 255) / 255.0,
    b = (this        and 255) / 255.0
)

internal fun Int.rgba(alpha: Double): Color = Color(
    r = (this shr 16        ) / 255.0,
    g = (this shr 8  and 255) / 255.0,
    b = (this        and 255) / 255.0,
    a = alpha
)

internal fun Long.rgba(): Color = Color(
    r = (this shr 24        ) / 255.0,
    g = (this shr 16 and 255) / 255.0,
    b = (this shr 8  and 255) / 255.0,
    a = (this        and 255) / 255.0
)