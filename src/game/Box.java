package game;

import java.io.IOException;
//A dobozokat reprezent�l� oszt�ly, ami a Pushable oszt�lyb�l sz�rmazik
public class Box extends Pushable {
	//A dobozt eltol� f�ggv�ny, hasonl�an m�k�dik, mint a munk�st eltol� f�ggv�ny, de 
	//a doboz aktiv�l minden mez�t.
	public boolean Push(Direction d) {
		//System.out.println("--- Box Push()");
		Main.DIST++;
		System.out.println("@@@ Tol�dni pr�b�l a doboz!");
		
		Field neighbor = actual.getNeighborAt(d);
		Pushable neighbor_item = neighbor.getItem();
		if(neighbor_item != null)
			neighbor_item.actual=neighbor;
		if( neighbor_item==null || neighbor_item.Push(d) ) {
			neighbor.setItem(this);
			neighbor.activate();
			actual.removeItem();
			System.out.println("@@@ A doboz "+Main.DIR+" ir�nyba tol�dott!");
			return true; 
		}
		System.out.println("@@@ A doboz nem tud tol�dni!");
		return false;
	}
	//Ha a doboz leesik, akkor h�v�dik meg ez a f�ggv�ny.
	public void Fall() {
		//System.out.println("--- Box Fall()");
		System.out.println("@@@ A doboz leesett!");
	}
}
