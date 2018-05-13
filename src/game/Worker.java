package game;

import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.io.PrintStream;

/**
 * A munkást reprezentáló osztály.
 */
public class Worker extends Pushable {

			/**
			 * A munkás pontszáma.
			 */
			private int score = 0;
			private int force= 200;
			private int honey= 2;
			private int oil= -2;
			private int leftKey = KeyEvent.VK_A;
			private int rightKey = KeyEvent.VK_D;
			private int upKey = KeyEvent.VK_W;
			private int downKey = KeyEvent.VK_S;
			private int honeyKey = KeyEvent.VK_Q;
			private int oilKey = KeyEvent.VK_E;


			
			/**
			 * Lekérdezzük a munkás pontszámát.
			 */
			
			public int getScore() {
				return score;
			}
			/**
			 * Beállítjuk a munkás pontszámát.
			 * @param s
			 */
			public void addScore(int s) {
				score += s;
			}
			/**
			 * A munkás mozgását leíró függvény
			 */
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
			
			
			/**
			 * A tolódás jelentő függvény, hasonlít a mozgásra, de most a surlódással is számolni kell.
			 *  A munkás mindenképpen el tud tolódni, ha nincs hely, akkor összenyomódik.
			 */
			public boolean Push(Direction d, int force) {
						
				Field neighbor = actual.getNeighborAt(d);
				Pushable neighbor_item = neighbor.getItem();
				
				
				if(force < (actual.friction * actual.getItem().weight)) {
						return false;					
				}
				if(neighbor_item==null) {
					neighbor.setItem(this);
					actual.removeItem();
					actual=neighbor;
					return true; 
				}
				
				int newforce= force - (actual.friction * actual.getItem().weight);
				if(neighbor_item.Push(d, newforce) ) {
					neighbor.setItem(this);
					actual.removeItem();
					actual=neighbor;
					return true; 
				}
				Die();
				return true;
			}
			
			/**
			 * Olajat önt a mezőre, csökkenti a surlódást.
			 */
			public void DropOil() {
				actual.changeFriction(oil);
			}
			
			/**
			 * Mézet önt a mezőre, növeli a surlódást.
			 */
			public void DropHoney() {
				actual.changeFriction(honey);
			}
			
			/**
			 * A munkás leesik, ekkor meg is hal.
			 */
			public void Fall() {
				Die();
			}
			/**
			 * A munkás meghal.
			 */
			public void Die() {
				Map.workers.remove(this);
				actual.removeItem();

			}
			/**
			 * Beállítjuk a munkás erejét.
			 */
			public void setForce(int force) {
				this.force = force;
			}
			/**
			 * Beállítjuk a méz hatását.
			 */
			public void setHoney(int honey) {
				this.honey = honey;
			}
			/**
			 * Beállítjuk az olaj hatását.
			 */
			public void setOil(int oil) {
				this.oil = oil;
			}

			@Override
	public void printType(PrintStream ps) {
		ps.print("Worker ");		
	}
	public void Draw(Graphics g) {
				g.drawImage(GamePanel.WorkerImage, actual.x, actual.y,null);
			}
			
	public void DrawMarker(Graphics g) {
			g.drawImage(GamePanel.MarkerImage, actual.x, actual.y,null);
		}

    public int getLeftKey() {
        return leftKey;
    }

    public int getRightKey() {
        return rightKey;
    }

    public int getUpKey() {
        return upKey;
    }

    public int getDownKey() {
        return downKey;
    }

    public int getHoneyKey() {
        return honeyKey;
    }

    public int getOilKey() {
        return oilKey;
    }
}