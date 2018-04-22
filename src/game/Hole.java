package game;

import java.io.IOException;

//Lyukat reprezentáló osztály

import java.io.PrintStream;

public class Hole extends Field{

	//A lyukba beállítjuk az itemet, valójában a leesik, majd kitöröljük.
	public void setItem(Pushable p){
		item = p;
		if(item != null) {
			item.Fall();
			removeItem();
		}
	}
	public void print( PrintStream ps) {
		ps.print("Hole ");
		if(item!=null)
			item.printType(ps);
			else
			ps.print("empty ");
		ps.print(friction);
	}
}
