package input;

import java.awt.Rectangle;
import static com.badlogic.gdx.Input.Keys.*;
import com.badlogic.gdx.Input.Buttons;

import render.Renderhandler;
import rpw.RPWorld;
import ui.UIhandler;
import world.Worldhandler;
import static rpw.State.*;

import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputProcessor;

public class Inputhandler implements InputProcessor{

    public static Rectangle mouse = new Rectangle(0, 0, 0, 0);
    public static Rectangle staticMouse = new Rectangle(0, 0, 0, 0);
    
    public void updateMouse(int screenX, int screenY){
        mouse = new Rectangle((int) ((screenX + Renderhandler.getScreenX()) * Renderhandler.getZoomScale()), (int) ((-screenY - Renderhandler.getScreenY()) * Renderhandler.getZoomScale()), 1, 1);
        staticMouse = new Rectangle((int) (screenX + Renderhandler.getScreenX()), (int) (-screenY - Renderhandler.getScreenY()), 1, 1);
    }

	@Override
	public boolean keyDown(int keycode) {
		switch(RPWorld.state){
			case MENU:
				switch(keycode){
					case ESCAPE:
						RPWorld.exit();
						break;
					}
				break;
			case SHAREDMAP:
				switch(keycode){
					case ESCAPE:
						if(RPWorld.sharedPaused){
							RPWorld.sharedPaused = false;
						}else{
							RPWorld.sharedPaused = true;
						}
						break;
				}
				break;
			case WORLD:
				switch(keycode){
					case ESCAPE:
						if(RPWorld.worldPaused){
							RPWorld.worldPaused = false;
						}else{
							RPWorld.worldPaused = true;
						}
						break;
				}
				if(RPWorld.worldPaused){
					switch(keycode){
						
					}
				}else{
					switch(keycode){
						case PAGE_UP:
							Renderhandler.zoomIn = true;
							break;
						case PAGE_DOWN:
							Renderhandler.zoomOut = true;
							break;
						case LEFT:
							Worldhandler.getWorld().right = true;
							break;
						case RIGHT:
							Worldhandler.getWorld().left = true;
							break;
						case UP:
							Worldhandler.getWorld().down = true;
							break;
						case DOWN:
							Worldhandler.getWorld().up = true;
							break;
					}
				}
				break;
		}
		return false;
	}

	@Override
	public boolean keyUp(int keycode) {
		switch(RPWorld.state){
			case WORLD:
				switch(keycode){
					case PAGE_UP:
						Renderhandler.zoomIn = false;
						break;
					case PAGE_DOWN:
						Renderhandler.zoomOut = false;
						break;
					case LEFT:
						Worldhandler.getWorld().right = false;
						break;
					case RIGHT:
						Worldhandler.getWorld().left = false;
						break;
					case UP:
						Worldhandler.getWorld().down = false;
						break;
					case DOWN:
						Worldhandler.getWorld().up = false;
						break;
					case ENTER:
						RPWorld.changeState(SHAREDMAP);
						break;
				}
				break;
		}
		return false;
	}

	@Override
	public boolean keyTyped(char character) {
		return false;
	}

	@Override
	public boolean touchDown(int screenX, int screenY, int pointer, int button) {
		updateMouse(screenX, screenY);
		switch(RPWorld.state){
			case MENU:
				switch(button){
					case Input.Buttons.LEFT:
						UIhandler.activate();
						break;
				}
			break;
			case SHAREDMAP:
				if(RPWorld.sharedPaused){
					switch(button){
						case Input.Buttons.LEFT:
							UIhandler.activate();
							break;
					}
				}else{
					
				}
				break;
			case WORLD:
				if(RPWorld.worldPaused){
					switch(button){
						case Input.Buttons.LEFT:
							UIhandler.activate();
							break;
					}
				}else{
					switch(button){
						case Input.Buttons.LEFT:
							if(Worldhandler.getWorld().hasHover()){
								Worldhandler.setActiveLevel();
							}
							break;
					}
				}
				break;
		}
		return false;
	}

	@Override
	public boolean touchUp(int screenX, int screenY, int pointer, int button) {
		updateMouse(screenX, screenY);
		return false;
	}

	@Override
	public boolean touchDragged(int screenX, int screenY, int pointer) {
		updateMouse(screenX, screenY);
		return false;
	}

	@Override
	public boolean mouseMoved(int screenX, int screenY) {
		updateMouse(screenX, screenY);
		return false;
	}

	@Override
	public boolean scrolled(int amount) {
		return false;
	}
	
}
