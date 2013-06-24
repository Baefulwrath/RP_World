package ui.menus;

import java.awt.Rectangle;

import rpw.State;

import ui.*;

public class SharedChoose_Menu extends Menu {

	public SharedChoose_Menu() {
		super("Shared Map", true, State.MENU, false);
	}

	@Override
	public void setup() {
		buttons.add(new Button(new Rectangle(-200, 150, 200, 30), "New World", "createnewworld_#openmenu_sharedchooseworldmenu", 30));
		buttons.add(new Button(new Rectangle(-200, 110, 200, 30), "Load World", "openmenu_sharedchooseworldmenu", 30));
		buttons.add(new Button(new Rectangle(-200, 70, 200, 30), "Back", "openmenu_mainmenu", 30));
	}
	
}
