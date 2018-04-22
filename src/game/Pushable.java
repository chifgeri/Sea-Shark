package game;

import java.io.IOException;

//Eltolható típusú itemeket összefoglaló absztrakt ősosztály.
//Minden leszármazottjának implementálnia kell a függényeit.
public abstract class Pushable {
	//Az a mező, amelyiken az item áll.
	protected Field actual = new Field();
	
	//Ezt a függvényt hívjuk meg, amikor az itemet eltoljuk.
	public abstract boolean Push(Direction d, int force);
	//Ezt a függvényt híjvuk meg, amikor az item leesik.
	public abstract void Fall();
}
