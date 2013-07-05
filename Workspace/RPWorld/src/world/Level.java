package world;

import rpw.RPWorld;
import rpw.State;

public class Level {
	public Tile[][] TILES = new Tile[0][0];
	public String TITLE = "";
	public String TILESET = "";
	public int X = 0;
	public int Y = 0;
	public boolean left = false;
	public boolean right = false;
	public boolean up = false;
	public boolean down = false;
	public static int speed = 32;
	public boolean HOVER = false;
	
	public Level(){}
	
	public Level(String title, String tileset, Tile[][] tiles){
		TITLE = title;
		TILESET = tileset;
		TILES = tiles;
	}
	
	public void update(){
		if(RPWorld.state == State.SHAREDMAP || RPWorld.state == State.PERSONALMAP){
			move();
		}
	}
	
	public void move(){
		if(left){
			X -= speed;
		}else if(right){
			X += speed;
		}
		if(up){
			Y += speed;
		}else if(down){
			Y -= speed;
		}
	}
}
