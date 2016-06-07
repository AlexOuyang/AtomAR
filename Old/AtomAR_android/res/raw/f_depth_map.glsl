/**
 * Pixel shader to generate the Depth Map
 * Used for shadow mapping - generates depth map from the light's viewpoint
 * Based on: http://blog.shayanjaved.com/2011/03/13/shaders-android/
 */
precision highp float;

varying vec4 vPosition; 

/**
 * From Fabien Sangalard's DEngine.
 * Since we only need the distance of objects from the light source which
 * is called the shadow map. To use it later we store this depth values
 * in a texture. On some android devices it's not possible to render depth
 * values directly to a texture (GPUs without OES_depth_texture OpenGL extension)
 * so we have to pack the depth values into RGBA components and later unpack them.
 */
vec4 pack (float depth)
{
	const vec4 bitSh = vec4(256.0 * 256.0 * 256.0,
							256.0 * 256.0,
							256.0,
							1.0);
	const vec4 bitMsk = vec4(0,
							 1.0 / 256.0,
							 1.0 / 256.0,
							 1.0 / 256.0);
	vec4 comp = fract(depth * bitSh);
	comp -= comp.xxyz * bitMsk;
	return comp;
}

void main() {
	// the depth
	float normalizedDistance  = vPosition.z / vPosition.w;
	// scale -1.0;1.0 to 0.0;1.0 
	normalizedDistance = (normalizedDistance + 1.0) / 2.0;

	// pack value into 32-bit RGBA texture, we encode the depth value
	// (coordinate Z) to 4 components
	gl_FragColor = pack(normalizedDistance);
}