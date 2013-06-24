package world;

public class Level {
	public Tile[][] TILES = new Tile[0][0];
	public String TITLE = "";
	public String TILESET = "";
	
	public Level(){}
	
	public Level(String title, String tileset, Tile[][] tiles){
		TITLE = title;
		TILESET = tileset;
		TILES = tiles;
	}
}
