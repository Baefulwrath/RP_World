package ui;

import input.Inputhandler;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import cmd.Cmdhandler;

import render.Renderer;
import rpw.RPWorld;
import rpw.State;

import ui.menus.*;

public class UIhandler {
	public static HashMap<String, Menu> menus = new HashMap<String, Menu>();
	public static String activeMenu = "";
	public static ArrayList<Message> messages = new ArrayList<Message>();
	public static long lastUpdate = 0;
	public static int updateInterval = 50;
	
	public static void load(){
		menus.put("mainmenu", new Main_Menu());
		menus.put("sharedchoosemenu", new SharedChoose_Menu());
		menus.put("sharedchooseworldmenu", new SharedChooseWorld_Menu());
		menus.put("sharedmainmenu", new SharedMain_Menu());
		menus.put("worldmainmenu", new WorldMain_Menu());
		activeMenu = "mainmenu";
	}
	
	public static void update(){
		if(readyToUpdate()){
	    	for(Map.Entry<String, Menu> entry : menus.entrySet()){
	    		menus.get(entry.getKey()).update(Inputhandler.staticMouse);
	    	}
	    	updateMessages();
		}
	}
	
	public static boolean readyToUpdate(){
		boolean temp = false;
		if(lastUpdate + updateInterval <= System.currentTimeMillis()){
			temp = true;
			lastUpdate = System.currentTimeMillis();
		}
		return temp;
	}
	
	public static void updateMessages(){
    	for(int i = 0; i < messages.size(); i++){
    		Message m = messages.get(i);
    		if(m.creationTime + m.LIFETIME <= System.currentTimeMillis()){
    			System.out.println("--<" + m.TEXT + ">--");
    			messages.remove(i);
    			updateMessages();
    			break;
    		}
    	}
	}
	
	public static Menu getMenu(){
		return getMenu(activeMenu);
	}
	
	public static Menu getMenu(String id){
		return menus.get(id);
	}

	public static void openMenu(String id) {
		activeMenu = id;
	}
	
	public static void activate(){
		Menu m = getMenu();
		for(int i = 0; i < m.buttons.size(); i++){
			if(m.buttons.get(i).HOVER){
				Cmdhandler.handleCmd(m.buttons.get(i).CMD);
			}
		}
	}
	
	public static void print(String s){
		System.out.println(s);
		messages.add(new Message(s, 4000));
	}
	
	public static void print(String s, int time){
		System.out.println(s);
		messages.add(new Message(s, time));
	}

	public static void resetMenu() {
    	for(Map.Entry<String, Menu> entry : menus.entrySet()){
    		Menu m = menus.get(entry.getKey());
    		if(m.MAIN && m.STATE == RPWorld.state){
    			activeMenu = entry.getKey();
    			break;
    		}
		}
	}
}
