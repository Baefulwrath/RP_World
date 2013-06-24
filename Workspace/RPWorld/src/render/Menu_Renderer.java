package render;

import ui.UIhandler;

public class Menu_Renderer extends Renderer{

	@Override
	public void loadSpecificResources() {
	}

	@Override
	public void mobileRender() {
	}

	@Override
	public void staticRender() {
		drawMessages(UIhandler.messages, Renderhandler.getScreenX(), -Renderhandler.getScreenY(), false);
		drawMenu(UIhandler.getMenu());
	}

}
