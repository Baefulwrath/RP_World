package rpw;

public enum State {
    DEFAULT, MENU, WORLD, SHAREDMAP, PERSONALMAP;
    
    @Override
    public String toString() {
        return super.toString();
    }
    
    public static State parseState(String state){
    	State temp = DEFAULT;
    	for(int i = 0; i < values().length; i++){
    		if(state.equals(values()[i].toString())){
    			temp = values()[i];
    		}
    	}
    	return temp;
    }
}
