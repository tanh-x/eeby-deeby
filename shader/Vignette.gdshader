shader_type canvas_item;

uniform vec2 center = vec2(0.5, 0.5);
uniform float vignette_radius;
uniform float vignette_scalar;

void fragment() {
    float radius = length(SCREEN_UV - center);
    float vignette = smoothstep(vignette_radius - vignette_scalar, vignette_radius, radius);
	COLOR = mix(textureLod(SCREEN_TEXTURE, SCREEN_UV, 0.0), vec4(0.0, 0.0, 0.0, 1.0), vignette);
}
