package game;

import java.awt.Graphics;
import java.io.PrintStream;
/**
 * Lyukat reprezentáló osztály
 */
public class Hole extends Field{
	/**
	 * A lyukba beállítjuk az itemet, valójában a leesik, majd kitöröljük.
	 */
	public void setItem(Pushable p){
		item = p;
		if(item != null) {
			item.Fall();
			removeItem();
		}
	}
	/**
	 * A kimeneti nyelvnek megfelelően kiírja az információkat a megadott streambe.
	 */
	public void print( PrintStream ps) {
		ps.print("Hole ");
		if(item!=null)
			item.printType(ps);
			else
			ps.print("empty ");
		ps.print(friction);
	}
	
	public void Draw(Graphics g) {
		// TODO Auto-generated method stub
		g.drawImage(Images.HoleImage, x, y,null);
		if(item!=null)
			item.Draw(g);
	}
}