package render;

import rpw.RPWorld;
import ui.UIhandler;

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
		if(RPWorld.sharedPaused){
			drawMenu(UIhandler.getMenu());
		}
	}

}
