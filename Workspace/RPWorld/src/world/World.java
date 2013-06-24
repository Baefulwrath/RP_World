package world;

import java.awt.Rectangle;

public class World {
	public Level[][] LEVELS = new Level[0][0];
	public String TITLE = "";
	public static final int mapSize = 50;
	public static final int mapBorder = 4;
	public int X = 0;
	public int Y = 0;
	public boolean left = false;
	public boolean right = false;
	public boolean up = false;
	public boolean down = false;
	public static int speed = 32;
	
	public void put(Level[][] maps){
		LEVELS = maps;
	}
	public void put(Level map, int x, int y){
		LEVELS[x][y] = map;
	}
	
	public void update(){
		move();
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
	
	public Rectangle getLevelBox(int x, int y){
		Level l = LEVELS[x][y];
		Rectangle box = new Rectangle(X + (x * (mapSize + mapBorder)), Y + (y * (mapSize + mapBorder)), mapSize, mapSize);
		return box;
	}
}
