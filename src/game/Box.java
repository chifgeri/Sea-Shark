package game;

import java.io.PrintStream;
//A dobozokat reprezentáló osztály, ami a Pushable osztályból származik
public class Box extends Pushable {

	//A doboz súlyát reprezentáló adat.
	private boolean scored=false;
	//A dobozt eltoló függvény, hasonlóan működik, mint a munkást eltoló függvény, de 
	//a doboz aktivál minden mezőt.
	public boolean Push(Direction d, int force) {		

		Field neighbor = actual.getNeighborAt(d);
		Pushable neighbor_item = neighbor.getItem();
		
		if(scored)
			return false;
		
		if(neighbor_item!=null && force <= (neighbor.friction * neighbor_item.weight)) {
			return false;					
	}
	if(neighbor_item==null) {
		neighbor.setItem(this);
		actual.removeItem();
		actual=neighbor;
		return true; 
	}
	
			int newforce= force - (neighbor.friction * neighbor_item.weight);
			if(neighbor_item.Push(d, newforce) ) {
				neighbor.setItem(this);
				actual.removeItem();
				actual=neighbor;
				return true; 
			}
	
		return false;
	}
	//Ha a doboz leesik, akkor hívódik meg ez a függvény.
	public void Fall() {
		Map.boxes.remove(actual);
		actual.removeItem();
	}
	
	public void setscored(boolean b) {
		scored = b;
	}

	public void printType(PrintStream ps) {
		ps.print(" Box ");		
	}
}