package world;

import input.Inputhandler;

import java.awt.Rectangle;

import rpw.RPWorld;
import rpw.State;

public class World {
	public Level[][] LEVELS = new Level[0][0];
	public int activeLevelX = 0;
	public int activeLevelY = 0;
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
	public boolean levelChosen = false;
	
	public void put(Level[][] maps){
		LEVELS = maps;
	}
	public void put(Level map, int x, int y){
		LEVELS[x][y] = map;
	}
	
	public void update(){
		if(RPWorld.state == State.WORLD){
			move();
			for(int x = 0; x < LEVELS.length; x++){
				for(int y = 0; y < LEVELS[x].length; y++){
					if(getLevelBox(x, y).intersects(Inputhandler.mouse) && !RPWorld.worldPaused){
						LEVELS[x][y].HOVER = true;
					}else{
						LEVELS[x][y].HOVER = false;
					}
				}
			}
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
	
	public Rectangle getLevelBox(int x, int y){
		Level l = LEVELS[x][y];
		Rectangle box = new Rectangle(X + (x * (mapSize + mapBorder)), Y + (y * (mapSize + mapBorder)), mapSize, mapSize);
		return box;
	}
	
	public void setActiveLevel() {
		for(int x = 0; x < LEVELS.length; x++){
			for(int y = 0; y < LEVELS[x].length; y++){
				if(LEVELS[x][y].HOVER){
					activeLevelX = x;
					activeLevelY = y;
					levelChosen = true;
				}
			}
		}
	}
	
	public Level getLevel(){
		return LEVELS[activeLevelX][activeLevelY];
	}
	
	public boolean hasHover(){
		boolean temp = false;
		for(int x = 0; x < LEVELS.length; x++){
			for(int y = 0; y < LEVELS[x].length; y++){
				if(LEVELS[x][y].HOVER){
					temp = true;
					break;
				}
			}
		}
		return temp;
	}
}
