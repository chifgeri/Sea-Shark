package game;

import java.io.IOException;
import java.io.PrintStream;
import java.util.HashMap;
//A mezőt reprezentáló osztály
public class Field {
	int friction=10;

    //A mezőn lévő tolható dolog
    protected Pushable item;
    //Az iránnyal indexelt szomszédok
    protected HashMap<Direction, Field> neighbours = new HashMap<Direction, Field>();

    public Field(){};
    public Field(Pushable p){
        item = p;
    }


    //Minden fieldnek van activate függvénye, a field nem csinál semmit a függvény meghívásakor.
    public void activate() {
        //System.out.println("--- Field activate()");
        System.out.println("@@@ A field aktiválódott (nem történik semmi)!");
    }
    //Beállítja a fielden lévő itemet.
    public void setItem(Pushable p) {
        //System.out.println("--- Field setItem()");
        item = p;
    }
    //Lekéri a fielden lévő itemet.
    //A szkeletonban, mivel a futás során derül ki, hogy mi van a térképen,
    //ezért itt jön létre a fielden lévő item.
    public Pushable getItem()  {
        //System.out.println("--- Field getItem()");
        //Megkérdezzük a felhasználótól, hogy mi található a fielden.
        System.out.println("??? Mi található a fielden "+Main.DIR+" irányban "+Main.DIST+
                " távolságra a munkástól? {box, worker, wall, null}");
        //Parancsbekérés

        //Attól függően, hogy mit mond a felhasználó, beállítjuk az itemet.
        //Valójában itt hozzuk létre.

        return item;
    }
    //Eltávolítjuk az itemet a fieldről.
    public void removeItem() {
        //System.out.println("--- Field removeItem()");
        item = null;
    }
    //Lekérdezzük az adott irányban a field szomszédját.
    //A szkeletonban, mivel a futás során derül ki, hogy mi van a térképen,
    //ezért itt jön létre a fielden szomszédja is.
    public Field getNeighborAt(Direction d)  {
        //System.out.println("--- Field getNeighborAt()");
        //Megkérdezzük a felhasználótól, hogy mi található a field szomszédságában.
        System.out.println("??? Milyen field található "+Main.DIR+" irányban "+
                Main.DIST+" távolságra a munkástól? {field, hole, switch, goal, trapdoor}");
        //Parancsbekérés

        //Attól függően, hogy mit mond a felhasználó, beállítjuk az szomszédot.
        //Valójában itt hozzuk létre.
      return null;
        }

    public void setNeighboursAt(Direction d, Field f) {
        neighbours.put(d, f);
    }
	
	public void print( PrintStream ps) {
		ps.print("Field ");
		if(item!=null)
		item.printType(ps);
		else
		ps.print("empty ");
		ps.print(friction);
	}
}
