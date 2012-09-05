import org.lwjgl.LWJGLException;
import org.lwjgl.input.Keyboard;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.DisplayMode;
import org.lwjgl.opengl.GL11;



public class Graphicmain {

	/**
	 * @param args
	 */
	int keycheckX = 0;
	int keycheckY = 0;
	float rotate = 2.0f % 360;
	int expandx = 50;
	int expandy = 50;
	int expandz = 50;
	int constanttranslate = 20;
	public void startup() {
		
		try{
			Display.setDisplayMode(new DisplayMode(1400, 900));
			Display.setInitialBackground(1.0f, 0.2f, 0.0f);
			Display.create();
		}
		catch(LWJGLException e) {
			e.printStackTrace();
			System.exit(0);
		}
		//init of GL here
		GL11.glMatrixMode(GL11.GL_PROJECTION);
		GL11.glLoadIdentity();
		GL11.glOrtho(0, Display.getDisplayMode().getWidth(), 0, Display.getDisplayMode().getHeight(), 1, -1);
		System.out.println(Display.getDisplayMode().getWidth() + " " + Display.getDisplayMode().getHeight());
		GL11.glMatrixMode(GL11.GL_MODELVIEW);
		
		while(!Display.isCloseRequested()) {
			
			//render OpenGl here
			
			guisetup();
			actionkeys();
			Display.update();
		}
		Display.destroy();
	}
	
	public static void main(String[] args) {
		Graphicmain graphicmain = new Graphicmain();
		graphicmain.startup();
		
		
	}
	public void guisetup() {
		// Clear the screen and depth buffer
		
		GL11.glClear(GL11.GL_COLOR_BUFFER_BIT | GL11.GL_DEPTH_BUFFER_BIT); 

		
		
		// set the color of the quad (R,G,B,A)
		GL11.glColor3f(0.5f,0.5f,1.0f);
		
		// draw quad
		GL11.glPushMatrix();
			GL11.glTranslatef(Display.getDisplayMode().getWidth()/2, Display.getDisplayMode().getHeight()/2, 0.0f);
			GL11.glTranslatef(keycheckX, keycheckY, 0);
			//GL11.glRotatef(rotate, 0, 0, 0);
		
			GL11.glBegin(GL11.GL_QUADS);
				GL11.glVertex2f(-expandx,-expandy);
				GL11.glVertex2f(expandx,-expandy);
				GL11.glVertex2f(expandx,expandy);
				GL11.glVertex2f(-expandx,expandy);
			GL11.glEnd();
			
			
		GL11.glPopMatrix();
	}
	public void actionkeys() {
		
		while(Keyboard.next()) {
			
			int constantangle = 180;
			int constantexpand = 10;
			if (Keyboard.getEventKeyState()){
			/*	if (Keyboard.getEventKey() == Keyboard.KEY_W) {
					System.out.println("UP");
					y = y+10;
				}*/
				
				//Same Thing as above^^^^
				//translate quad:
				if (Keyboard.isKeyDown(Keyboard.KEY_W)) {
					System.out.println("UP");
					keycheckY = keycheckY + constanttranslate;
				}
				if (Keyboard.getEventKey() == Keyboard.KEY_A) {
					System.out.println("LEFT");
					keycheckX= keycheckX - constanttranslate;
				}
				if (Keyboard.getEventKey() == Keyboard.KEY_S){
					System.out.println("DOWN");
					keycheckY = keycheckY - constanttranslate;
				}
				if (Keyboard.getEventKey() == Keyboard.KEY_D) {
					System.out.println("RIGHT");
					keycheckX = keycheckX + constanttranslate;
				}
				
				//rotate quad:
				if (Keyboard.isKeyDown(Keyboard.KEY_Q)) {
					rotate = rotate - 2.0f % constantangle;
				}
				if (Keyboard.isKeyDown(Keyboard.KEY_E)) {
					rotate = rotate + 2.0f % constantangle;
				}
				
				//expand quad:
				if (Keyboard.isKeyDown(Keyboard.KEY_UP)) {
					expandy = expandy - constantexpand;
				}
				if (Keyboard.isKeyDown(Keyboard.KEY_DOWN)) {
					expandy = expandy + constantexpand;
				}
				if (Keyboard.isKeyDown(Keyboard.KEY_LEFT)) {
					expandx = expandx - constantexpand;
				}
				if (Keyboard.isKeyDown(Keyboard.KEY_RIGHT)) {
					expandx = expandx + constantexpand;
				}
				
				//other quad:
				if (Keyboard.isKeyDown(Keyboard.KEY_SPACE)){
					constanttranslate = constanttranslate + 10;
					System.out.println("CTR: " + constanttranslate);
				}
			}
		/*	else {
				if (Keyboard.)
			}
			*/
		}
		
	}
	

}
