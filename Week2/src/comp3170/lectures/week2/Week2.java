package comp3170.lectures.week2;

import org.lwjgl.opengl.GLCapabilities;
import static org.lwjgl.opengl.GL41.*;

import java.io.File;

import comp3170.IWindowListener;
import comp3170.OpenGLException;
import comp3170.ShaderLibrary;
import comp3170.Window;

public class Week2 implements IWindowListener {
	private int screenWidth = 800;
	private int screenHeight = 800;
	
	final private File DIRECTORY = new File("src/comp3170/lectures/week2/");
	
	private Scene scene;

	public Week2() throws OpenGLException {
		Window window = new Window("Week 2", screenWidth, screenHeight, this);
		window.run();

	}

	public static void main(String[] args) throws OpenGLException {
		new Week2();
	}

	@Override
	public void init() {
		new ShaderLibrary(DIRECTORY);
		
		glClearColor(0.0f, 0.0f, 0.0f, 1.0f);
		
		scene = new Scene();
	}

	@Override
	public void draw() {
		glClear(GL_COLOR_BUFFER_BIT);
		scene.draw();
	}

	@Override
	public void resize(int width, int height) {

	}

	@Override
	public void close() {

	}
}
