package game;

import java.io.IOException;
import java.io.PrintStream;
		//A munkást reprezentáló osztály.
public class Worker extends Pushable {
			//A munkás pontszáma.
			protected int score = 0;
			protected int weight= 10;
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
			//A tolódás jelentő függvény, hasonlít a mozgásra, de most a surlódással is számolni kell.
			//A munkás mindenképpen el tud tolódni, ha nincs hely, akkor összenyomódik.
			public boolean Push(Direction d, int force) {
						
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
				actual.removeItem();
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

