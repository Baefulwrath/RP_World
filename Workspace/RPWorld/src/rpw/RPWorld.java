package rpw;

import input.Inputhandler;
import render.Renderhandler;
import ui.UIhandler;
import world.Worldhandler;

import cmd.Cmdhandler;

import com.badlogic.gdx.ApplicationListener;
import static com.badlogic.gdx.Gdx.*;

public class RPWorld implements ApplicationListener {
	
	public static State state = State.MENU;
	public static Inputhandler IH = new Inputhandler();
	public static boolean sharedPaused = false;
	public static boolean personalPaused = false;
	public static boolean worldPaused = false;
	
	@Override
	public void create() {
		Renderhandler.setup();
		UIhandler.load();
		input.setInputProcessor(IH);
		Worldhandler.setup();
	}

	@Override
	public void dispose() {
		Renderhandler.dispose();
	}

	@Override
	public void render() {
		UIhandler.update();
		Cmdhandler.update();
		Worldhandler.update();
		Renderhandler.render();
	}

	@Override
	public void resize(int width, int height) {
	}

	@Override
	public void pause() {
	}

	@Override
	public void resume() {
	}
	
	public static void exit(){
		System.exit(0);
	}

	public static void changeState(String id) {
		state = State.parseState(id);
		UIhandler.resetMenu();
	}
	
	public static void changeState(State s) {
		state = s;
		UIhandler.resetMenu();
	}
}
