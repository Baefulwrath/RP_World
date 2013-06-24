package ui.menus;

import java.awt.Rectangle;
import java.util.Map;

import render.Renderhandler;
import rpw.State;

import ui.*;
import world.World;
import world.Worldhandler;

public class SharedChooseWorld_Menu extends Menu {

	public SharedChooseWorld_Menu() {
		super("Choose World (Shared)", true, State.MENU, false);
	}

	@Override
	public void setup() {
		buttons.add(new Button(new Rectangle(-200, 150, 200, 30), "Back", "openmenu_sharedchoosemenu", 30));
		buttons.add(new Button(new Rectangle(-200, 110, 200, 30), "Continue", "changestate_WORLD", 30));
		int i = 0;
		String set = "";
		int rows = 0;
    	for(Map.Entry<String, World> entry : Worldhandler.worlds.entrySet()){
			World w = Worldhandler.worlds.get(entry.getKey());
			if(entry.getKey().equals(Worldhandler.activeWorld)){
				set = "[SET]";
			}else{
				set = "";
			}
			buttons.add(new Button(new Rectangle(-200, 70 - (i * 40), 300, 30), w.TITLE + set, "chooseworld_" + entry.getKey(), 30));
			i++;
		}
	}
	
}
