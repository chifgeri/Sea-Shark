package game;

import java.io.IOException;
import java.util.HashMap;
//A mez�t reprezent�l� oszt�ly
public class Field {
	//A mez�n l�v� tolhat� dolog
	protected Pushable item;
	//Az ir�nnyal indexelt szomsz�dok
	protected HashMap<Direction, Field> neighbours = new HashMap<Direction, Field>();

	public Field(){}

	public Field(Pushable p){
	    item = p;
    }

	//Minden fieldnek van activate f�ggv�nye, a field nem csin�l semmit a f�ggv�ny megh�v�sakor.
	public void activate() {
		//System.out.println("--- Field activate()");
		System.out.println("@@@ A field aktiv�l�dott (nem t�rt�nik semmi)!");
	}
	//Be�ll�tja a fielden l�v� itemet.
	public void setItem(Pushable p)  {
		//System.out.println("--- Field setItem()");
		item = p;
	}
	//Lek�ri a fielden l�v� itemet.
	//A szkeletonban, mivel a fut�s sor�n der�l ki, hogy mi van a t�rk�pen,
	//ez�rt itt j�n l�tre a fielden l�v� item.
	public Pushable getItem()  {
		//System.out.println("--- Field getItem()");
		//Megk�rdezz�k a felhaszn�l�t�l, hogy mi tal�lhat� a fielden.
		System.out.println("??? Mi tal�lhat� a fielden "+Main.DIR+" ir�nyban "+Main.DIST+
				" t�vols�gra a munk�st�l? {box, worker, wall, null}");
		//Parancsbek�r�s

		//Att�l f�gg�en, hogy mit mond a felhaszn�l�, be�ll�tjuk az itemet.
		//Val�j�ban itt hozzuk l�tre.

		return item;
	}
	//Elt�vol�tjuk az itemet a fieldr�l.
	public void removeItem() {
		//System.out.println("--- Field removeItem()");
		item = null;
	}
	//Lek�rdezz�k az adott ir�nyban a field szomsz�dj�t.
	//A szkeletonban, mivel a fut�s sor�n der�l ki, hogy mi van a t�rk�pen,
	//ez�rt itt j�n l�tre a fielden szomsz�dja is.
	public Field getNeighborAt(Direction d)  {
		//System.out.println("--- Field getNeighborAt()");
		//Megk�rdezz�k a felhaszn�l�t�l, hogy mi tal�lhat� a field szomsz�ds�g�ban.
		System.out.println("??? Milyen field tal�lhat� "+Main.DIR+" ir�nyban "+
		Main.DIST+" t�vols�gra a munk�st�l? {field, hole, switch, goal, trapdoor}");
		//Parancsbek�r�s

		//Att�l f�gg�en, hogy mit mond a felhaszn�l�, be�ll�tjuk az szomsz�dot.
		//Val�j�ban itt hozzuk l�tre.

	       return null;

	}

	public void setNeighboursAt(Direction d, Field f){
	    neighbours.put(d, f);
    }
}
