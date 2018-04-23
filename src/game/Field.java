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
    }
    //Beállítja a fielden lévő itemet.
    public void setItem(Pushable p) {
        item = p;
    }
    //Lekéri a fielden lévő itemet.
    public Pushable getItem() {
        return item;
    }
    //Eltávolítjuk az itemet a fieldről.
    public void removeItem() {
        item = null;
    }
    //Lekérdezzük az adott irányban a field szomszédját.
    public Field getNeighborAt(Direction d)  {
    	return neighbours.get(d);
        }

    public void setNeighboursAt(Direction d, Field f) {
        neighbours.put(d, f);
    }
    public void changeFriction(int plus) {
    	friction+=plus;
    }
	
    //A kimeneti nyelvnek megfelelően kiírja az információkat a megadott streambe
	public void print( PrintStream ps) {
		ps.print("Field ");
		if(item!=null)
			item.printType(ps);
		else
			ps.print("empty ");
		ps.print(friction);
	}
}
