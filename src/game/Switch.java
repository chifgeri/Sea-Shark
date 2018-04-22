package game;

import java.io.PrintStream;

//Kapcsolót reprezentáló osztály.
public class Switch extends Field {
    private Trapdoor trapdoor;

    public Switch(){
        super();
    }
    public Switch(Pushable p){
        super(p);
    }
    //Az itemet beállítjuk a kapcsolóra.
    public void setItem(Pushable p) {
        //System.out.println("--- Switch setItem()");
    }
    //A doboz hívja meg, amikor rátoljuk. A hozzá tartozó csapóajtót nyitja ki.
    public void activate() {
        //System.out.println("--- Switch activate()");
        System.out.println("@@@ A switch aktiválódott!");
    }

    public void setTrapdoor(Trapdoor trapdoor) {
        this.trapdoor = trapdoor;
    }

	
	public void print(PrintStream ps) {
		ps.print("Switch ");
		if(item!=null)
			item.printType(ps);
			else
			ps.print("empty ");
		ps.print(friction);
	}
}

