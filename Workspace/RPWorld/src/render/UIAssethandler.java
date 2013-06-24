package render;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.NinePatch;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.scenes.scene2d.ui.Label.LabelStyle;

public class UIAssethandler {
    private static BitmapFont com64;
    private static BitmapFont com32;
    private static BitmapFont com16;
    private static BitmapFont com10;
    private static BitmapFont com32_BI;
    private static BitmapFont com16_BI;
    private static BitmapFont com10_BI;
    
    public static LabelStyle messageLabelStyle;
    public static LabelStyle logoLabelStyle;
    public static LabelStyle debugLabelStyle;
    public static LabelStyle basicLabelStyle;
    public static LabelStyle titleLabelStyle;
    public static LabelStyle buttonLabelStyle;
    
	public static NinePatch buttonUpImg;
	public static NinePatch buttonDownImg;
	public static NinePatch mapImg;
    
    public static void load(){
    	try{
            com64 = new BitmapFont(Gdx.files.internal("data/fonts/com64.fnt"), Gdx.files.internal("data/fonts/com64.png"), false, false);
            com32 = new BitmapFont(Gdx.files.internal("data/fonts/com32.fnt"), Gdx.files.internal("data/fonts/com32.png"), false, false);
            com16 = new BitmapFont(Gdx.files.internal("data/fonts/com16.fnt"), Gdx.files.internal("data/fonts/com16.png"), false, false);
            com10 = new BitmapFont(Gdx.files.internal("data/fonts/com10.fnt"), Gdx.files.internal("data/fonts/com10.png"), false, false);
            com32_BI = new BitmapFont(Gdx.files.internal("data/fonts/com32_BI.fnt"), Gdx.files.internal("data/fonts/com32_BI.png"), false, false);
            com16_BI = new BitmapFont(Gdx.files.internal("data/fonts/com16_BI.fnt"), Gdx.files.internal("data/fonts/com16_BI.png"), false, false);
            com10_BI = new BitmapFont(Gdx.files.internal("data/fonts/com10_BI.fnt"), Gdx.files.internal("data/fonts/com10_BI.png"), false, false);

            messageLabelStyle = new LabelStyle(UIAssethandler.com10, Color.CYAN);
            logoLabelStyle = new LabelStyle(UIAssethandler.com64, Color.WHITE);
            debugLabelStyle = new LabelStyle(UIAssethandler.com10, Color.RED);
            titleLabelStyle = new LabelStyle(UIAssethandler.com32_BI, Color.WHITE);
            basicLabelStyle = new LabelStyle(UIAssethandler.com10, Color.WHITE);
            buttonLabelStyle = new LabelStyle(UIAssethandler.com16, Color.WHITE);

            buttonUpImg = parsePatch(Gdx.files.internal("data/images/buttonUpPatch.txt").readString(), new Texture(Gdx.files.internal("data/images/buttonUp.png")));
            buttonDownImg = parsePatch(Gdx.files.internal("data/images/buttonDownPatch.txt").readString(), new Texture(Gdx.files.internal("data/images/buttonDown.png")));
            mapImg = parsePatch(Gdx.files.internal("data/images/mapPatch.txt").readString(), new Texture(Gdx.files.internal("data/images/map.png")));
    	}catch(Exception ex){
    		ex.printStackTrace(System.out);
    	}
    }
    
    public static void dispose(){}
    
    public static NinePatch parsePatch(String info, Texture tex){
    	NinePatch NP;
    	int left = Integer.parseInt(info.substring(0, info.indexOf(",")));
    	info = info.substring(info.indexOf(",") + 1);
    	int right = Integer.parseInt(info.substring(0, info.indexOf(",")));
    	info = info.substring(info.indexOf(",") + 1);
    	int top = Integer.parseInt(info.substring(0, info.indexOf(",")));
    	int bottom = Integer.parseInt(info.substring(info.indexOf(",") + 1));
    	NP = new NinePatch(tex, left, right, top, bottom);
    	return NP;
    }

}
