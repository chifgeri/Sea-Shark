package game;

import java.io.IOException;
//A munkást reprezentáló osztály.
public class Worker extends Pushable {
	//A munkás pontszáma.
	protected int score = 0;
	protected int weight= 10;
	protected int force= 200;
	protected int honey= 2;
	protected int oil= -2;
	
	//A munkás mozgás függvénye a megadott irányba.
	public boolean Move(Direction d) {
		//A Main függvényben növeljük a távolság változó értékét, mivel a szomszédokat fogjuk vizsgálni.
		Main.DIST++;
	
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
			return true; 
		}
		//Egyéb esetben a munkás nem tud mozogni, ezt tudatjuk a felhasználóval is.
		return false;
	}
	//A tolódás jelentõ függvény, hasonlít a mozgásra, de most a surlódással is számolni kell.
	//A munkás mindenképpen el tud tolódni, ha nincs hely, akkor összenyomódik.
	public boolean Push(Direction d, int force) {
		Main.DIST++;
		
		Field neighbor = actual.getNeighborAt(d);
		Pushable neighbor_item = neighbor.getItem();
		
		if(neighbor_item != null)
			neighbor_item.actual=neighbor;
		
		if(force <= (neighbor.friction * neighbor_item.weight))
			return false;
		
		int newforce= force - (neighbor.friction * neighbor_item.weight);
		if( neighbor_item==null || neighbor_item.Push(d, newforce) ) {
			neighbor.setItem(this);
			actual.removeItem();
			return true; 
		}
		Die()
		return true;
	}
	
	//olajat önt a mezõre, csökkenti a surlódást.
	public void DropOil() {
		actual.changeFriction(oil);
	}
	
	//mézet önt a mezõre, növeli a surlódást.
	public void DropHoney() {
		actual.changeFriction(honey);
	}
	
	//A munkás leesik, ekkor meg is hal.
	public void Fall() {
		Die();
	}
	//A munkás meghal.
	public void Die() {
		actual.removeItem();
		actual= null;
	}
}