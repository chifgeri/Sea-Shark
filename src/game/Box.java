package game;

import java.io.PrintStream;
//A dobozokat reprezentáló osztály, ami a Pushable osztályból származik
public class Box extends Pushable {

	//A doboz súlyát reprezentáló adat.
	protected int weight= 10;
	
	//A dobozt eltoló függvény, hasonlóan működik, mint a munkást eltoló függvény, de 
	//a doboz aktivál minden mezőt.
	public boolean Push(Direction d, int force) {		

		Field neighbor = actual.getNeighborAt(d);
		Pushable neighbor_item = neighbor.getItem();
		
		if(neighbor_item!=null && force <= (neighbor_item.weight * neighbor.friction)) {
			return false;
		}
		
		int newforce= force - (neighbor_item.weight * neighbor.friction);
		if( neighbor_item==null || neighbor_item.Push(d, newforce) ) {
			neighbor.setItem(this);
			neighbor.activate();
			actual.removeItem();

			actual=neighbor;
			return true; 

		}
	
		return false;
	}
	//Ha a doboz leesik, akkor hívódik meg ez a függvény.
	public void Fall() {
		actual.removeItem();
	}

	@Override

	public void setActual(Field field) {
		actual = field;
	}

	public void printType(PrintStream ps) {
		ps.print(" Box ");		
	}
}