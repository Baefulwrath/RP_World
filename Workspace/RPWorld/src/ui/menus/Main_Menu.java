package ui.menus;

import java.awt.Rectangle;

import rpw.State;

import ui.*;

public class Main_Menu extends Menu {

	public Main_Menu() {
		super("Main Menu", true, State.MENU, true);
	}

	@Override
	public void setup() {
		buttons.add(new Button(new Rectangle(-200, 150, 200, 30), "Shared Map", "openmenu_sharedchoosemenu", 30));
		buttons.add(new Button(new Rectangle(-200, 110, 200, 30), "Personal Map", "print_Unavailable", 30));
		buttons.add(new Button(new Rectangle(-200, 70, 200, 30), "Exit", "exit_", 30));
	}
	
}
