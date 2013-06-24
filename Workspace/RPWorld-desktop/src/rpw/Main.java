package rpw;

import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JOptionPane;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;

public class Main {
	public static void main(String[] args) {
		LwjglApplicationConfiguration cfg = new LwjglApplicationConfiguration();
		cfg.title = "RP World";
		cfg.useGL20 = false;
		cfg.width = 1280;
		cfg.height = 720;
		//int fullscreen = JOptionPane.showConfirmDialog(null, "Fullscreen?", "Fullscreen", JOptionPane.YES_NO_OPTION);
		//if(fullscreen == JOptionPane.YES_OPTION){
		if(false){
			Toolkit toolkit =  Toolkit.getDefaultToolkit();
			Dimension dim = toolkit.getScreenSize();
			cfg.width = dim.width;
			cfg.height = dim.height;
			cfg.fullscreen = true;
		}
		
		new LwjglApplication(new RPWorld(), cfg);
	}
}
