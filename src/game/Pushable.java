package game;

import java.io.IOException;
//Eltolhat� t�pus� itemeket �sszefoglal� absztrakt �soszt�ly.
//Minden lesz�rmazottj�nak implement�lnia kell a f�ggv�nyeit.
public abstract class Pushable {
	//Az a mez�, amelyiken az item �ll.
	protected Field actual = new Field();
	
	//Ezt a f�ggv�nyt h�vjuk meg, amikor az itemet eltoljuk.
	public abstract boolean Push(Direction d);
	//Ezt a f�ggv�nt h�jvuk meg, amikor az item leesik.
	public abstract void Fall();
}
