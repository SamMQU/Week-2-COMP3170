package comp3170.lectures.week2;

import org.joml.Vector3f;
import org.joml.Vector4f;

import static org.lwjgl.opengl.GL15.GL_TRIANGLES;
import static org.lwjgl.opengl.GL15.GL_LINES;
import static org.lwjgl.opengl.GL15.glDrawElements;
import static org.lwjgl.opengl.GL15.glBindBuffer;
import static org.lwjgl.opengl.GL15.glDrawArrays;
import static org.lwjgl.opengl.GL15.GL_ELEMENT_ARRAY_BUFFER;
import static org.lwjgl.opengl.GL15.GL_UNSIGNED_INT;

import comp3170.GLBuffers;
import comp3170.Shader;
import comp3170.ShaderLibrary;

public class Bolt {
	final private String VERTEX_SHADER = "vertex.glsl";
	final private String FRAGMENT_SHADER = "fragment.glsl";

	private Vector4f[] vertices;
	private int vertexBuffer;
	private Shader shader;
	private int[] indices;
	private int indexBuffer;
	
	private Vector3f colour = new Vector3f(0.0f,1.0f,1.0f);

	public Bolt() {
		shader = ShaderLibrary.instance.compileShader(VERTEX_SHADER, FRAGMENT_SHADER);
		
		//vertices as (x,y) pairs
				
		// @formatter:off
		vertices = new Vector4f[] {
			new Vector4f(-0.2f,  -0.5f, 0.0f, 1.0f),	// P0
			new Vector4f(0.2f,  -0.5f, 0.0f, 1.0f),	// P1
			new Vector4f(0.2f,   0.1f, 0.0f, 1.0f),	// P2
			new Vector4f(0.5f,  0.1f, 0.0f, 1.0f),	// P3
			new Vector4f( 0.0f,   0.5f, 0.0f, 1.0f),	// P4
			new Vector4f( -0.5f,   0.1f, 0.0f, 1.0f),	// P5
			new Vector4f( -0.2f,   0.1f, 0.0f, 1.0f),	// P6
			
		};
		// @formatter:on
		
		// @formatter:off
		indices = new int[] {
			0, 1, 6,
			1, 2, 6,
			3, 4, 5	    	
		};
		// @formatter:on
		
		vertexBuffer = GLBuffers.createBuffer(vertices);
		indexBuffer = GLBuffers.createIndexBuffer(indices);
		
	}
	
	public void draw() {
		shader.enable();
		
		shader.setAttribute("a_position", vertexBuffer);
		glBindBuffer(GL_ELEMENT_ARRAY_BUFFER, indexBuffer);
		
		shader.setUniform("u_colour", colour);
		
		glDrawElements(GL_TRIANGLES, indices.length, GL_UNSIGNED_INT, 0);
	}
}
