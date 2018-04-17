package game;

import java.io.IOException;
import java.util.HashMap;
//A mezõt reprezentáló osztály
public class Field {
	//A mezõn lévõ tolható dolog
	protected Pushable item;
	//Az iránnyal indexelt szomszédok
	protected HashMap<Direction, Field> neighbours = new HashMap<Direction, Field>();
	
	//Minden fieldnek van activate függvénye, a field nem csinál semmit a függvény meghívásakor.
	public void activate() {
		//System.out.println("--- Field activate()");
		System.out.println("@@@ A field aktiválódott (nem történik semmi)!");
	}
	//Beállítja a fielden lévõ itemet.
	public void setItem(Pushable p) throws IOException {
		//System.out.println("--- Field setItem()");
		item = p;
	}
	//Lekéri a fielden lévõ itemet.
	//A szkeletonban, mivel a futás során derül ki, hogy mi van a térképen,
	//ezért itt jön létre a fielden lévõ item.
	public Pushable getItem() throws IOException {
		//System.out.println("--- Field getItem()");
		//Megkérdezzük a felhasználótól, hogy mi található a fielden.
		System.out.println("??? Mi található a fielden "+Main.DIR+" irányban "+Main.DIST+
				" távolságra a munkástól? {box, worker, wall, null}");
		//Parancsbekérés
		Main.getcommand();
		//Attól függõen, hogy mit mond a felhasználó, beállítjuk az itemet.
		//Valójában itt hozzuk létre.
		switch(Main.cmd[0]) {
			case "box":    item = new Box(); break;
			case "worker": item = new Worker();  break;
			case "wall":   item = new Wall(); break;
			case "null":   item = null; break;
			default:	   item = null;
		}	
		return item;
	}
	//Eltávolítjuk az itemet a fieldrõl.
	public void removeItem() {
		//System.out.println("--- Field removeItem()");
		item = null;
	}
	//Lekérdezzük az adott irányban a field szomszédját.
	//A szkeletonban, mivel a futás során derül ki, hogy mi van a térképen,
	//ezért itt jön létre a fielden szomszédja is.
	public Field getNeighborAt(Direction d) throws IOException {
		//System.out.println("--- Field getNeighborAt()");
		//Megkérdezzük a felhasználótól, hogy mi található a field szomszédságában.
		System.out.println("??? Milyen field található "+Main.DIR+" irányban "+
		Main.DIST+" távolságra a munkástól? {field, hole, switch, goal, trapdoor}");
		//Parancsbekérés
		Main.getcommand();
		//Attól függõen, hogy mit mond a felhasználó, beállítjuk az szomszédot.
		//Valójában itt hozzuk létre.
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
