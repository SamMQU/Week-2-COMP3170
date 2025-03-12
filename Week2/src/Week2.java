import comp3170.IWindowListener;
import comp3170.OpenGLException;
import comp3170.Window;

public class Week2 implements IWindowListener {
	 	private int screenWidth = 800;
	 	private int screenHeight = 800;
	 	
	 	public Week2() throws OpenGLException{
	 		Window window = new Window("Week 2", screenWidth, screenHeight, this);
	 		window.run();
	 	}
	 	
	    public static void main(String[] args) throws OpenGLException {
	        new Week2();
	    }

		@Override
		public void init() {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void draw() {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void resize(int width, int height) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void close() {
			// TODO Auto-generated method stub
			
		}
}
