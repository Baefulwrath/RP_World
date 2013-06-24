package ui.menus;

import java.awt.Rectangle;

import rpw.State;

import ui.*;

public class WorldMain_Menu extends Menu {

	public WorldMain_Menu() {
		super("Paused", true, State.WORLD, true);
	}

	@Override
	public void setup() {
		buttons.add(new Button(new Rectangle(-200, 150, 200, 30), "Continue", "unpauseWorld_", 30));
		buttons.add(new Button(new Rectangle(-200, 110, 200, 30), "Exit", "changestate_MENU", 30));
	}
	
}
