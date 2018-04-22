package game;

import java.io.IOException;
//A dobozokat reprezent�l� oszt�ly, ami a Pushable oszt�lyb�l sz�rmazik
public class Box extends Pushable {
	
	//A doboz s�ly�t reprezent�l� adat.
	protected int weight= 10;
	
	//A dobozt eltol� f�ggv�ny, hasonl�an m�k�dik, mint a munk�st eltol� f�ggv�ny, de 
	//a doboz aktiv�l minden mez�t.
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
	//Ha a doboz leesik, akkor h�v�dik meg ez a f�ggv�ny.
	public void Fall() {
		actual.removeItem();
		actual= null;	
	}
}
