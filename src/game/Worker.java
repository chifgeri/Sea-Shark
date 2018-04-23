package game;

import java.io.IOException;
import java.io.PrintStream;
		//A munkást reprezentáló osztály.
public class Worker extends Pushable {

			//A munkás pontszáma.
			protected int score = 0;
			protected int force= 200;
			protected int honey= 2;
			protected int oil= -2;
			
			//Lekérdezzük a munkás pontszámát.
			public int getScore() {
				//System.out.println("--- Worker getScore()");
				return score;
			}
			//Beállítjuk a munkás pontszámát.
			public void addScore(int s) {
				score += s;
			}
			
			public boolean Move(Direction d) {			
				Field neighbor = actual.getNeighborAt(d);
				Pushable neighbor_item = neighbor.getItem();
				
				//Ha a szomszédon lévő item null, akkor true-val térünk vissza, mert el tud mozdulni oda az item.
				//Ha a szomszédon lévő itemet el tudjuk tolni, akkor is.
				//Ekkor egy sor keletkezik, tehát az összes szomszédos itemet meg próbáljuk eltolni.
				if( neighbor_item==null || neighbor_item.Push(d,force) ) {
					//Az eltolás során a szomszéd itemét beállítjuk a munkásra,
					//Az aktuális fieldről pedig eltávolítjuk a munkást.
					neighbor.setItem(this);
					actual.removeItem();
					actual=neighbor;
					return true; 
				}
				//Egyéb esetben a munkás nem tud mozogni, ezt tudatjuk a felhasználóval is.
				return false;
			}
			
			
			//A tolódás jelentő függvény, hasonlít a mozgásra, de most a surlódással is számolni kell.
			//A munkás mindenképpen el tud tolódni, ha nincs hely, akkor összenyomódik.
			public boolean Push(Direction d, int force) {
						
				Field neighbor = actual.getNeighborAt(d);
				Pushable neighbor_item = neighbor.getItem();
				
				
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
				Die();
				return true;
			}
			
			//olajat önt a mezőre, csökkenti a surlódást.
			public void DropOil() {
				actual.changeFriction(oil);
			}
			
			//mézet önt a mezőre, növeli a surlódást.
			public void DropHoney() {
				actual.changeFriction(honey);
			}
			
			//A munkás leesik, ekkor meg is hal.
			public void Fall() {
				Die();
			}
			//A munkás meghal.
			public void Die() {
				Map.workers.remove(actual);
				actual.removeItem();

			}

			public void setForce(int force) {
				this.force = force;
			}

			public void setHoney(int honey) {
				this.honey = honey;
			}

			public void setOil(int oil) {
				this.oil = oil;
			}

			@Override
	public void printType(PrintStream ps) {
		ps.print(" Worker ");		
	}

}

