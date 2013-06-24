package ui;

import java.awt.Rectangle;
import java.util.ArrayList;

import render.Renderhandler;
import rpw.State;

public abstract class Menu {
	public ArrayList<Button> buttons = new ArrayList<Button>();
	public boolean DRAWTITLE = true;
	public String TITLE = "";
	public State STATE = State.DEFAULT;
	public boolean MAIN = false;
	
	public Menu(String title, boolean drawTitle, State state, boolean main){
		TITLE = title;
		DRAWTITLE = drawTitle;
		STATE = state;
		MAIN = main;
	}
	
	public void update(Rectangle controller){
		clear();
		setup();
		testHover(controller);
	}
	
	public void testHover(Rectangle controller){
		for(int i = 0; i < buttons.size(); i++){
			buttons.get(i).update(controller);
		}
	}

	public abstract void setup();

	public void clear(){
		buttons.clear();
	}
	
}
