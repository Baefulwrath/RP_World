package ui.menus;

import java.awt.Rectangle;

import rpw.State;

import ui.*;

public class SharedMain_Menu extends Menu {

	public SharedMain_Menu() {
		super("Paused", true, State.SHAREDMAP, true);
	}

	@Override
	public void setup() {
		buttons.add(new Button(new Rectangle(-200, 150, 200, 30), "Continue", "unpauseShared_", 30));
		buttons.add(new Button(new Rectangle(-200, 110, 200, 30), "New Map", "print_Unavailable", 30));
		buttons.add(new Button(new Rectangle(-200, 70, 200, 30), "Load Map", "print_Unavailable", 30));
		buttons.add(new Button(new Rectangle(-200, 30, 200, 30), "Exit", "changestate_MENU", 30));
	}
	
}
