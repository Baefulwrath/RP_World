package render;

import rpw.RPWorld;
import ui.UIhandler;
import world.Worldhandler;

public class SharedMap_Renderer extends Renderer{

	@Override
	public void loadSpecificResources() {
	}

	@Override
	public void mobileRender() {
	}

	@Override
	public void staticRender() {
		drawMessages(UIhandler.messages, Renderhandler.getScreenX(), -Renderhandler.getScreenY(), false);
		drawLevel(Worldhandler.getLevel());
		if(RPWorld.sharedPaused){
			drawMenu(UIhandler.getMenu());
		}
	}

}
