#version 410

uniform vec3 u_colour; // (r,g,b)

layout(location = 0) out vec4 o_color; // (r,g,b,a)

void main() {
	o_color = vec4(u_colour, 1);
}