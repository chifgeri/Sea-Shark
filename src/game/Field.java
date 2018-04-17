package game;

import java.io.IOException;
import java.util.HashMap;
//A mez�t reprezent�l� oszt�ly
public class Field {
	//A mez�n l�v� tolhat� dolog
	protected Pushable item;
	//Az ir�nnyal indexelt szomsz�dok
	protected HashMap<Direction, Field> neighbours = new HashMap<Direction, Field>();
	
	//Minden fieldnek van activate f�ggv�nye, a field nem csin�l semmit a f�ggv�ny megh�v�sakor.
	public void activate() {
		//System.out.println("--- Field activate()");
		System.out.println("@@@ A field aktiv�l�dott (nem t�rt�nik semmi)!");
	}
	//Be�ll�tja a fielden l�v� itemet.
	public void setItem(Pushable p) throws IOException {
		//System.out.println("--- Field setItem()");
		item = p;
	}
	//Lek�ri a fielden l�v� itemet.
	//A szkeletonban, mivel a fut�s sor�n der�l ki, hogy mi van a t�rk�pen,
	//ez�rt itt j�n l�tre a fielden l�v� item.
	public Pushable getItem() throws IOException {
		//System.out.println("--- Field getItem()");
		//Megk�rdezz�k a felhaszn�l�t�l, hogy mi tal�lhat� a fielden.
		System.out.println("??? Mi tal�lhat� a fielden "+Main.DIR+" ir�nyban "+Main.DIST+
				" t�vols�gra a munk�st�l? {box, worker, wall, null}");
		//Parancsbek�r�s
		Main.getcommand();
		//Att�l f�gg�en, hogy mit mond a felhaszn�l�, be�ll�tjuk az itemet.
		//Val�j�ban itt hozzuk l�tre.
		switch(Main.cmd[0]) {
			case "box":    item = new Box(); break;
			case "worker": item = new Worker();  break;
			case "wall":   item = new Wall(); break;
			case "null":   item = null; break;
			default:	   item = null;
		}	
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
	public Field getNeighborAt(Direction d) throws IOException {
		//System.out.println("--- Field getNeighborAt()");
		//Megk�rdezz�k a felhaszn�l�t�l, hogy mi tal�lhat� a field szomsz�ds�g�ban.
		System.out.println("??? Milyen field tal�lhat� "+Main.DIR+" ir�nyban "+
		Main.DIST+" t�vols�gra a munk�st�l? {field, hole, switch, goal, trapdoor}");
		//Parancsbek�r�s
		Main.getcommand();
		//Att�l f�gg�en, hogy mit mond a felhaszn�l�, be�ll�tjuk az szomsz�dot.
		//Val�j�ban itt hozzuk l�tre.
		switch(Main.cmd[0]) {
			case "field":    return new Field(); 
			case "hole":     return new Hole();
			case "switch":   return new Switch();
			case "goal":     return new Goal();
			case "trapdoor": return new Trapdoor();
			default:         return null;
		}
	}
}
