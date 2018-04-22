package game;

import java.io.IOException;

//A dobozokat reprezentáló osztály, ami a Pushable osztályból származik

import java.io.PrintStream;

public class Box extends Pushable {
	//A dobozt eltoló függvény, hasonlóan mûködik, mint a munkást eltoló függvény, de
	//a doboz aktivál minden mezõt.
	public boolean Push(Direction d)  {
		//System.out.println("--- Box Push()");

		System.out.println("@@@ Tolódni próbál a doboz!");

		Field neighbor = actual.getNeighborAt(d);
		Pushable neighbor_item = neighbor.getItem();
		if(neighbor_item != null)
			neighbor_item.actual=neighbor;
		if( neighbor_item==null || neighbor_item.Push(d) ) {
			neighbor.setItem(this);
			neighbor.activate();
			actual.removeItem();
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

	@Override

	public void setActual(Field field) {
		actual = field;
	}

	public void printType(PrintStream ps) {
		ps.print(" Box ");
		
	}
}