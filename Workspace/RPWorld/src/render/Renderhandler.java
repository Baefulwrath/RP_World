package render;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Renderhandler {
	public static OrthographicCamera camera;
	public static SpriteBatch batch;
	public static float w;
	public static float h;
	public static long lastRender = 0;
	public static int renderInterval = 5;
	
	public static void setup(){
		w = Gdx.graphics.getWidth();
		h = Gdx.graphics.getHeight();
		
		camera = new OrthographicCamera(1, h/w);
		batch = new SpriteBatch();
		camera.zoom = w;
	}
	
	public static void render(){
		
	}
	
	public static boolean readyToRender(){
		boolean temp = false;
		if(lastRender + renderInterval <= System.currentTimeMillis()){
			temp = true;
			lastRender = System.currentTimeMillis();
		}
		return temp;
	}
	
	public static void doRender(){
		
	}
	
	public static void dispose(){
		batch.dispose();
	}
}
