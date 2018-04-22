package game;

import java.io.IOException;
//A munkást reprezentáló osztály.
public class Worker extends Pushable {
	//A munkás pontszáma.
	protected int score = 0;
	
	//Lekérdezzük a munkás pontszámát.
	public int getScore() {
		//System.out.println("--- Worker getScore()");
		return score;
	}
	//Beállítjuk a munkás pontszámát.
	public void setScore(int s) {
		System.out.println("--- Worker setScore()");
		score = s;
	}
	//A munkás mozgás függvénye a megadott irányba.
	public boolean Move(Direction d) {
		//System.out.println("--- Worker Move()");
		//A Main függvényben növeljük a távolság változó értékét, mivel a szomszédokat fogjuk vizsgálni.
		Main.DIST++;
		//Információs üzenet.
		System.out.println("@@@ Mozogni próbál a munkás!");
		//Lekérdezzük a szomszédot.
		Field neighbor = actual.getNeighborAt(d);
		//Lekérdezzük a szomszédon lévõ itemet.
		Pushable neighbor_item = neighbor.getItem();
		//A szomszédon lévõ itemnek beállítjuk a szomszédot annak fieldjeként.
		//(Persze a szomszédon van item, csak akkor.)
		if(neighbor_item != null)
			neighbor_item.actual=neighbor;
		//Ha a szomszédon lévõ item null, akkor true-val térünk vissza, mert el tud mozdulni oda az item.
		//Ha a szomszédon lévõ itemet el tudjuk tolni, akkor is.
		//Ekkor egy sor keletkezik, tehát az összes szomszédos itemet meg próbáljuk eltolni.
		if( neighbor_item==null || neighbor_item.Push(d) ) {
			//Az eltolás során a szomszéd itemét beállítjuk a munkásra,
			//Az aktuális fieldrõl pedig eltávolítjuk a munkást.
			neighbor.setItem(this);
			actual.removeItem();
			//Információs üzenet.
			System.out.println("@@@ A munkás "+Main.DIR+" irányba mozgott!");
			return true; 
		}
		//Egyéb esetben a munkás nem tud mozogni, ezt tudatjuk a felhasználóval is.
		System.out.println("@@@ A munkás nem tud mozogni!");
		return false;
	}
	//A tolódás jelentõ függvény, nagyon hasonlít a mozgásra.
	//A munkás mindenképpen el tud tolódni, ha nincs hely, akkor összenyomódik.
	public boolean Push(Direction d) {
		//System.out.println("--- Box Push()");
		Main.DIST++;
		System.out.println("@@@ Tolódni próbál a munkás!");
		
		Field neighbor = actual.getNeighborAt(d);
		Pushable neighbor_item = neighbor.getItem();
		if(neighbor_item != null)
			neighbor_item.actual=neighbor;
		if( neighbor_item==null || neighbor_item.Push(d) ) {
			neighbor.setItem(this);
			actual.removeItem();
			System.out.println("@@@ A munkás "+Main.DIR+" irányba tolódott!");
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
	public void setActual(Field field) {
		actual = field;
	}
}
