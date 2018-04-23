package game;

import java.io.IOException;

//A munkást reprezentáló osztály.

import java.io.PrintStream;

public class Worker extends Pushable {
	//A munkás pontszáma.
	protected int score = 0;
	
	//Lekérdezzük a munkás pontszámát.
	public int getScore() {
		//System.out.println("--- Worker getScore()");
		return score;
	}
	//Beállítjuk a munkás pontszámát.
	public void addScore(int s) {
		score += s;
	}
	//A munkás mozgás függvénye a megadott irányba.
	public boolean Move(Direction d) {
		//System.out.println("--- Worker Move()");

		//Információs üzenet.
		System.out.println("@@@ Mozogni próbál a munkás!");
		//Lekérdezzük a szomszédot.
		Field neighbor = actual.getNeighborAt(d);
		//Lekérdezzük a szomszédon lévő itemet.
		Pushable neighbor_item = neighbor.getItem();
		//A szomszédon lévő itemnek beállítjuk a szomszédot annak fieldjeként.
		//(Persze a szomszédon van item, csak akkor.)
		if(neighbor_item != null)
			neighbor_item.actual=neighbor;
		//Ha a szomszédon lévő item null, akkor true-val térünk vissza, mert el tud mozdulni oda az item.
		//Ha a szomszédon lévő itemet el tudjuk tolni, akkor is.
		//Ekkor egy sor keletkezik, tehát az összes szomszédos itemet meg próbáljuk eltolni.
		if( neighbor_item==null || neighbor_item.Push(d) ) {
			//Az eltolás során a szomszéd itemét beállítjuk a munkásra,
			//Az aktuális fieldről pedig eltávolítjuk a munkást.
			neighbor.setItem(this);
			actual.removeItem();
			//Információs üzenet.

			return true; 
		}
		//Egyéb esetben a munkás nem tud mozogni, ezt tudatjuk a felhasználóval is.
		System.out.println("@@@ A munkás nem tud mozogni!");
		return false;
	}
	//A tolódás jelentő függvény, nagyon hasonlít a mozgásra.
	//A munkás mindenképpen el tud tolódni, ha nincs hely, akkor összenyomódik.
	public boolean Push(Direction d) {
		//System.out.println("--- Box Push()");

		System.out.println("@@@ Tolódni próbál a munkás!");
		
		Field neighbor = actual.getNeighborAt(d);
		Pushable neighbor_item = neighbor.getItem();
		if(neighbor_item != null)
			neighbor_item.actual=neighbor;
		if( neighbor_item==null || neighbor_item.Push(d) ) {
			neighbor.setItem(this);
			actual.removeItem();
		
			return true; 
		}
		System.out.println("@@@ A munkás a falnak nyomódott!");
		Die();
		return true;
	}
	//A munkás leesik, ekkor meg is hal.
	public void Fall() {
		//System.out.println("--- Worker Fall()");
		System.out.println("@@@ A munkás leesett!");
		Die();
	}
	//A munkás meghal.
	public void Die() {
		//System.out.println("--- Worker Die()");
		System.out.println("@@@ A munkás meghalt!");
	}

	@Override
	public void printType(PrintStream ps) {
		ps.print(" Worker ");		
	}

	@Override
	public void setActual(Field field) {
		actual = field;
	}
}

