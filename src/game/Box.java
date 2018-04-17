package game;

import java.io.IOException;
//A dobozokat reprezentáló osztály, ami a Pushable osztályból származik
public class Box extends Pushable {
	//A dobozt eltoló függvény, hasonlóan mûködik, mint a munkást eltoló függvény, de 
	//a doboz aktivál minden mezõt.
	public boolean Push(Direction d) throws IOException {
		//System.out.println("--- Box Push()");
		Main.DIST++;
		System.out.println("@@@ Tolódni próbál a doboz!");
		
		Field neighbor = actual.getNeighborAt(d);
		Pushable neighbor_item = neighbor.getItem();
		if(neighbor_item != null)
			neighbor_item.actual=neighbor;
		if( neighbor_item==null || neighbor_item.Push(d) ) {
			neighbor.setItem(this);
			neighbor.activate();
			actual.removeItem();
			System.out.println("@@@ A doboz "+Main.DIR+" irányba tolódott!");
			return true; 
		}
		System.out.println("@@@ A doboz nem tud tolódni!");
		return false;
	}
	//Ha a doboz leesik, akkor hívódik meg ez a függvény.
	public void Fall() {
		//System.out.println("--- Box Fall()");
		System.out.println("@@@ A doboz leesett!");
	}
}
