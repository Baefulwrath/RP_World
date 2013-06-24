package world;

public class Level {
	public Tile[][] TILES = new Tile[0][0];
	public String TITLE = "";
	public String TILESET = "";
	public boolean HOVER = false;
	
	public Level(){}
	
	public Level(String title, String tileset, Tile[][] tiles){
		TITLE = title;
		TILESET = tileset;
		TILES = tiles;
	}
	
	public void update(){
		
	}
}
