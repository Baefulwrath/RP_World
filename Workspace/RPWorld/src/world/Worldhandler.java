package world;

import java.util.HashMap;
import java.util.Map;

import javax.swing.JOptionPane;

import render.Renderer;
import rpw.RPWorld;
import rpw.State;
import ui.UIhandler;

import cmd.Cmdhandler;

import com.badlogic.gdx.Gdx;

public class Worldhandler {
	
	public static HashMap<String, World> worlds = new HashMap<String, World>();
	public static String activeWorld = "";
	public static boolean worldSet = false;
	public static long lastUpdate = 0;
	public static int updateInterval = 50;
	
	public static void setup(){
		loadMaps();
	}
	
	public static void update(){
		if(readyToUpdate()){
	    	for(Map.Entry<String, World> entry : worlds.entrySet()){
	    		worlds.get(entry.getKey()).update();
	    	}
		}
	}

	public static boolean readyToUpdate(){
		boolean temp = false;
		if(lastUpdate + updateInterval <= System.currentTimeMillis()){
			temp = true;
			lastUpdate = System.currentTimeMillis();
		}
		if(RPWorld.state != State.SHAREDMAP && RPWorld.state != State.PERSONALMAP && RPWorld.state != State.WORLD){
			temp = false;
		}
		return temp;
	}
	
	public static void loadMaps(){
		try{
			
		}catch(Exception ex){
			ex.printStackTrace(System.out);
		}
	}

	public static void createNewWorld() {
		if(Gdx.graphics.isFullscreen()){
			UIhandler.print("Unavailable while in fullscreen mode, sorry.");
			Cmdhandler.stopCommand();
		}else{
			World w = new World();
			String id = JOptionPane.showInputDialog(null, "World ID:", "World ID");
			String title = JOptionPane.showInputDialog(null, "World Title:", "World Title");
			int worldW = Integer.parseInt(JOptionPane.showInputDialog(null, "World Width:", "World Width"));
			int worldH = Integer.parseInt(JOptionPane.showInputDialog(null, "World Height:", "World Height"));
			String tileset = "TEST_TILESET";
			int mapW = Integer.parseInt(JOptionPane.showInputDialog(null, "Map Width (General):", "Map Width"));
			int mapH = Integer.parseInt(JOptionPane.showInputDialog(null, "Map Height (General):", "Map Height"));
			w.LEVELS = new Level[mapW][mapH];
			for(int x = 0; x < worldW; x++){
				for(int y = 0; y < worldH; y++){
					Level m = new Level("", tileset, new Tile[mapW][mapH]);
					w.put(m, x, y);
				}
			}
			w.TITLE = title;
			worlds.put(id, w);
		}
	}
	
	public static World getWorld(){
		return worlds.get(activeWorld);
	}

	public static void setActiveWorld(String id) {
		activeWorld = id;
		worldSet = true;
	}

}
