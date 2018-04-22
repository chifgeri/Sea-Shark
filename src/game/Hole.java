package game;

import java.io.IOException;
//Lyukat reprezentáló osztály
public class Hole extends Field{

	//A lyukba beállítjuk az itemet, valójában a leesik, majd kitöröljük.
	public void setItem(Pushable p){
		//System.out.println("--- Hole setItem()");
		item = p;
		if(item != null) {
			item.Fall();
			removeItem();
		}
	}
}
