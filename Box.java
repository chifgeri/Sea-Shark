package game;

import java.io.IOException;
//A dobozokat reprezentáló osztály, ami a Pushable osztályból származik
public class Box extends Pushable {
	
	//A doboz súlyát reprezentáló adat.
	protected int weight= 10;
	
	//A dobozt eltoló függvény, hasonlóan mûködik, mint a munkást eltoló függvény, de 
	//a doboz aktivál minden mezõt.
	public boolean Push(Direction d, int force) {
		//System.out.println("--- Box Push()");
		Main.DIST++;
		
		Field neighbor = actual.getNeighborAt(d);
		Pushable neighbor_item = neighbor.getItem();
		
		if(neighbor_item != null)
			neighbor_item.actual=neighbor;
		
		if(force <= (neighbor_item.weight * neighbor.friction)) {
			return false;
		}
		
		int newforce= force - (neighbor_item.weight * neighbor.friction);
		if( neighbor_item==null || neighbor_item.Push(d, newforce) ) {
			neighbor.setItem(this);
			neighbor.activate();
			actual.removeItem();
			return true; 
		}
	
		return false;
	}
	//Ha a doboz leesik, akkor hívódik meg ez a függvény.
	public void Fall() {
		actual.removeItem();
		actual= null;	
	}
}
