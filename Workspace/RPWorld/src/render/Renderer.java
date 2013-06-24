package render;

import java.awt.Rectangle;
import java.util.ArrayList;

import ui.*;
import world.World;
import world.Worldhandler;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture.TextureFilter;
import com.badlogic.gdx.graphics.g2d.NinePatch;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Label.LabelStyle;

public abstract class Renderer {
	public abstract void loadSpecificResources();
	public abstract void mobileRender();
	public abstract void staticRender();

    public void drawImage(Sprite sprite, float x, float y, float scale, int rotation, boolean smooth, Color tint, float opacity, boolean centered) {
    	if(smooth){
    		sprite.getTexture().setFilter(TextureFilter.Linear, TextureFilter.Linear);
    	}else{
    		sprite.getTexture().setFilter(TextureFilter.Nearest, TextureFilter.Nearest);
    	}
    	if(!centered){
    		x += sprite.getWidth() / 2;
    		y += sprite.getHeight() / 2;
    	}
    	sprite.setSize(1, 1);
    	sprite.setScale(scale);
    	sprite.setOrigin(sprite.getWidth() / 2, sprite.getHeight() / 2);
    	sprite.setPosition(x - (sprite.getWidth() / 2), y - (sprite.getHeight() / 2));
    	sprite.setRotation(rotation);
    	sprite.setColor(tint.r, tint.g, tint.b, opacity);
    	actualDrawImage(sprite);
    }
    
    public void drawImage(Sprite sprite, float x, float y, float width, float height, int rotation, boolean smooth, Color tint, float opacity, boolean centered) {
    	if(smooth){
    		sprite.getTexture().setFilter(TextureFilter.Linear, TextureFilter.Linear);
    	}else{
    		sprite.getTexture().setFilter(TextureFilter.Nearest, TextureFilter.Nearest);
    	}
    	if(!centered){
    		x += width / 2;
    		y += height / 2;
    	}
    	sprite.setSize(1, 1);
    	sprite.setScale(width, height);
    	sprite.setOrigin(sprite.getWidth() / 2, sprite.getHeight() / 2);
    	sprite.setPosition(x - (sprite.getWidth() / 2), y - (sprite.getHeight() / 2));
    	sprite.setRotation(rotation);
    	sprite.setColor(tint.r, tint.g, tint.b, opacity);
    	actualDrawImage(sprite);
    }
    
    public void drawNinePatch(NinePatch img, float x, float y, float width, float height){
    	img.getTexture().setFilter(TextureFilter.Nearest, TextureFilter.Nearest);
    	img.draw(Renderhandler.batch, x, y, width, height);
    }
    
    private void actualDrawImage(Sprite sprite){
    	sprite.draw(Renderhandler.batch);
    }

    public void drawString(String string, float x, float y, LabelStyle style, float opacity) {
    	y -= style.font.getCapHeight();
        Label lab = new Label(string, style);
        lab.setPosition(x, y);
        lab.draw(Renderhandler.batch, opacity);
    }
    
    public void drawMenu(Menu m){
    	if(m.DRAWTITLE){
    		drawString(m.TITLE, -250, 300, UIAssethandler.titleLabelStyle, 1.0f);
        	drawString("-------------", -250, 300 - UIAssethandler.titleLabelStyle.font.getCapHeight() - 2, UIAssethandler.titleLabelStyle, 1.0f);
    	}
    	for(int i = 0; i < m.buttons.size(); i++){
    		Button b = m.buttons.get(i);
    		NinePatch img;
    		if(b.HOVER){
    			img = UIAssethandler.buttonDownImg;
    		}else{
    			img = UIAssethandler.buttonUpImg;
    		}
    		drawNinePatch(img, b.BOX.x, b.BOX.y, b.BOX.width, b.BOX.height);
    		String title = b.TITLE;
    		if(title.isEmpty()){
    			title = "[UNTITLED]";
    		}
    		drawString(title, b.BOX.x + b.TX, b.getTitleY(), UIAssethandler.buttonLabelStyle, 1.0f);
    	}
    }
    
    public void drawWorld(World w){
    	try{
	    	for(int x = 0; x < w.LEVELS.length; x++){
	    		for(int y = 0; y < w.LEVELS[x].length; y++){
	    			Rectangle b = w.getLevelBox(x, y);
	    			drawNinePatch(UIAssethandler.mapImg, b.x, b.y, b.width, b.height);
	    		}
	    	}
    	}catch(Exception ex){
    		drawString("ERROR", 0, 0, UIAssethandler.debugLabelStyle, 0.5f);
    	}
    }
    
    public void drawMessages(ArrayList<Message> m, float x, float y, boolean up){
    	LabelStyle style = UIAssethandler.messageLabelStyle;
    	for(int i = 0; i < m.size(); i++){
    		if(up){
    			drawString(m.get(i).TEXT, x, y + (i * (style.font.getCapHeight() + 3)), style, 0.5f);
    		}else{
    			drawString(m.get(i).TEXT, x, y - (i * (style.font.getCapHeight() + 3)) - style.font.getCapHeight(), style, 0.5f);
    		}
    	}
    }
}
