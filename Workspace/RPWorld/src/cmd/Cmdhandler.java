package cmd;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import rpw.RPWorld;

import ui.UIhandler;
import world.Worldhandler;

public class Cmdhandler {
    private static InputStreamReader inputStreamReader = new InputStreamReader(System.in);
    private static BufferedReader reader = new BufferedReader(inputStreamReader);
    private static boolean stopped = false;
    
    public static void update() {
        try {
            if (reader.ready()) {
                handleCmd(reader.readLine());
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
    
	public static void handleCmd(String cmd){
		stopped = false;
        while (cmd.contains("#")) {
        	readLine(cmd.substring(0, cmd.indexOf("#")));
        	cmd = cmd.substring(cmd.indexOf("#") + 1);
        }
        readLine(cmd);
	}
	
	private static void readLine(String line){
		if(!stopped){
			if(line.length() > 9){
				if(line.substring(0, line.indexOf("_") + 1).equals("openmenu_")){
					UIhandler.openMenu(line.substring(9));
				}
			}
			if(line.length() > 6){
				if(line.substring(0, line.indexOf("_") + 1).equals("print_")){
					UIhandler.print(line.substring(6));
				}
			}
			if(line.length() > 12){
				if(line.substring(0, line.indexOf("_") + 1).equals("changestate_")){
					RPWorld.changeState(line.substring(12));
				}
			}
			if(line.length() > 12){
				if(line.substring(0, line.indexOf("_") + 1).equals("chooseworld_")){
					Worldhandler.setActiveWorld(line.substring(12));
				}
			}
			if(line.length() == 14){
				if(line.equals("unpauseShared_")){
					RPWorld.sharedPaused = false;
				}
			}
			if(line.length() == 15){
				if(line.equals("createnewworld_")){
					Worldhandler.createNewWorld();
				}
			}
			if(line.length() == 5){
				if(line.equals("exit_")){
					RPWorld.exit();
				}
			}
			System.out.println(line);
		}else{
			System.out.println("[cmd stopped]");
		}
	}
	
	public static void stopCommand(){
		stopped = true;
	}
}
