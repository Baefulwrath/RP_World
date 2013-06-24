package ui;

import java.awt.Rectangle;

import render.UIAssethandler;

public class Button {
	public Rectangle BOX = new Rectangle();
	public String TITLE = "";
	public String CMD = "";
	public boolean HOVER = false;
	public int TX = 0;
	
	public Button(Rectangle box, String title, String cmd, int titleX){
		BOX = box;
		TITLE = title;
		CMD = cmd;
		TX = titleX;
	}
	
	public boolean hits(Rectangle r){
		if(r.intersects(BOX)){
			return true;
		}else{
			return false;
		}
	}
	
	public int getTitleY(){
		int y = BOX.y;
		y += (BOX.height / 2) + (UIAssethandler.buttonLabelStyle.font.getCapHeight() / 2);
		return y;
	}
	public void update(Rectangle controller){
		HOVER = hits(controller);
	}
	
}
