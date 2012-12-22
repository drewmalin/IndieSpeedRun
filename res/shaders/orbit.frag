uniform sampler2D texture;
uniform float array[40];
uniform int screenHeight;
uniform int count;
uniform float defaultLevel;

void main() 
{
	float atten 	= defaultLevel;
	vec4 color	= texture2D(texture, gl_TexCoord[0].st);
	
	vec2 pixel 	= gl_FragCoord.xy;
	pixel.y 	= float(screenHeight) - pixel.y;

	for (int i = 0; i < (count*4); i+= 4) 
	{
		vec2 light = vec2(array[i], array[i+1]);

		float dist = length(light - pixel);
		
		if (dist > 0.0) 
		{
			atten += array[i+3] * (1.0 / (dist));
		}
		else {
			atten += 0.0;
		}		
	}

	gl_FragColor = color * vec4(atten, atten, atten, 1.0);
}
