package render;

import static com.badlogic.gdx.Gdx.*;

import java.util.HashMap;
import java.util.Map;

import rpw.*;
import sun.reflect.ReflectionFactory.GetReflectionFactoryAction;
import static rpw.State.*;

import static com.badlogic.gdx.graphics.GL11.*;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Renderhandler {
	public static OrthographicCamera camera;
	public static SpriteBatch batch;
	public static float w;
	public static float h;
	public static long lastRender = 0;
	public static int renderInterval = 5;
	public static float zoomMax;
	public static float zoomMin;
	public static float zoomSpeed = 32;
	public static boolean zoomIn = false;
	public static boolean zoomOut = false;
	public static float zoom = w;
	public static HashMap<State, Renderer> renderers = new HashMap<State, Renderer>();
	public static Sprite background = new Sprite();
	
	public static void setup(){
		w = graphics.getWidth();
		h = graphics.getHeight();
		zoomMax = graphics.getWidth() * 4;
		zoomMin = graphics.getWidth() / 4;
		zoom = w;
		
		camera = new OrthographicCamera(1, h/w);
		batch = new SpriteBatch();
		camera.zoom = w;
		setupRenderers();
		loadResources();
	}
	
	public static void setupRenderers(){
		renderers.put(DEFAULT, new Default_Renderer());
		renderers.put(MENU, new Menu_Renderer());
		renderers.put(WORLD, new World_Renderer());
		renderers.put(SHAREDMAP, new SharedMap_Renderer());
		renderers.put(PERSONALMAP, new Personal_Renderer());
	}
	
	public static void render(){
		zoomIn();
		zoomOut();
		newFrame();
		backgroundRender();
		mobileRender();
		staticRender();
	}

	public static void doRender(boolean mobile){
		if(mobile){
			getActiveRenderer().mobileRender();
		}else{
			getActiveRenderer().staticRender();
		}
	}
	
	public static void backgroundRender() {
		camera.zoom = w;
		prepRender();
		getActiveRenderer().drawImage(background, 0, 0, w, h, 0, true, Color.WHITE, 1.0f, true);
		getActiveRenderer().drawString(RPWorld.state.toString(), getScreenX(), getScreenY() + (Assethandler.messageLabelStyle.font.getCapHeight()), Assethandler.messageLabelStyle, 0.5f);
		endRender();
	}
	
	public static void mobileRender(){
		camera.zoom = zoom;
		prepRender();
		doRender(true);
		endRender();
	}
	
	public static void staticRender(){
		camera.zoom = w;
		prepRender();
		doRender(false);
		endRender();
	}
	
	public static void newFrame(){
		graphics.getGL10().glClearColor(0, 0.05f, 0.05f, 1.0f);
		graphics.getGL10().glClear(GL_COLOR_BUFFER_BIT | GL_STENCIL_BUFFER_BIT | GL_DEPTH_BUFFER_BIT);
		graphics.getGL10().glDisable(GL_CULL_FACE);
	}
	
	public static void prepRender(){
		camera.position.set(camera.viewportWidth * .5f, camera.viewportHeight * .5f, 0f);
		camera.update();
		batch.setProjectionMatrix(camera.combined);
		batch.setColor(1.0f, 1.0f, 1.0f, 1.0f);
		batch.begin();
	}
	
	public static void endRender(){
		batch.end();
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
		Assethandler.dispose();
	}
    
    public static float getZoomScale(){
    	return zoom / w;
    }
    
    public static float getZoomScale_In(){
    	return zoom / w - 1;
    }
    
    public static void zoomIn(){
    	if(zoomIn && zoom > zoomMin){
    		zoom -= zoomSpeed;
    	}
    }

    public static void zoomOut(){
    	if(zoomOut && zoom < zoomMax){
    		zoom += zoomSpeed;
    	}
    }

    public static float getScreenX() {
        return -(w / 2);
    }

    public static float getScreenY() {
        return -(h / 2);
    }
    
    public static Renderer getActiveRenderer(){
    	return renderers.get(RPWorld.state);
    }
    
    public static void loadResources(){
    	try{
	    	for(Map.Entry<State, Renderer> entry : renderers.entrySet()){
	    		renderers.get(entry.getKey()).loadSpecificResources();
	    	}
	    	Assethandler.load();
	    	background = new Sprite(new Texture(Gdx.files.internal("data/images/background.png")));
    	}catch(Exception ex){
    		ex.printStackTrace(System.out);
    	}
    }
}
