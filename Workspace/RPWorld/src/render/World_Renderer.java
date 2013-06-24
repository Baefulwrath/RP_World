package render;

import rpw.RPWorld;
import ui.UIhandler;
import world.Worldhandler;

public class World_Renderer extends Renderer{

	@Override
	public void loadSpecificResources() {
	}

	@Override
	public void mobileRender() {
		drawWorld(Worldhandler.getWorld());
	}

	@Override
	public void staticRender() {
		drawMessages(UIhandler.messages, Renderhandler.getScreenX(), -Renderhandler.getScreenY(), false);
		if(RPWorld.worldPaused){
			drawMenu(UIhandler.getMenu());
		}
	}

}
