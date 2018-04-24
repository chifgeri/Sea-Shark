package game;

import java.io.PrintStream;
/**
 *Eltolható típusú itemeket összefoglaló absztrakt ősosztály.
 *Minden leszármazottjának implementálnia kell a függényeit.
 */
public abstract class Pushable {
	
	protected int weight=10;
	
	/**
	 * Az a mező, amelyiken az item áll.
	 */
	protected Field actual = new Field();
	
	/**
	 * Ezt a függvényt hívjuk meg, amikor az itemet eltoljuk.
	 */
	public abstract boolean Push(Direction d, int force);
	/**
	 * Ezt a függvényt híjvuk meg, amikor az item leesik.
	 */
	public abstract void Fall();

	public void setActual(Field field){
		actual = field;
	}
	/**
	 * Megadja, hogy mit írjunk ki a térkép kiírásánál.
	 */
	public abstract void printType(PrintStream ps);

	public void setWeight(int weight) {
		this.weight = weight;
	}
}