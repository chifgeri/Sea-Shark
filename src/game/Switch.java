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
       item=p;
       trapdoor.switch_(false);
    }
    //A doboz hívja meg, amikor rátoljuk. A hozzá tartozó csapóajtót nyitja ki.
    public void activate() {
    	trapdoor.switch_(true);
    }

    public void setTrapdoor(Trapdoor trapdoor) {
        this.trapdoor = trapdoor;
    }
	
  //A kimeneti nyelvnek megfelelően kiírja az információkat a megadott streambe
	public void print(PrintStream ps) {
		ps.print("Switch ");
		if(item!=null)
			item.printType(ps);
			else
			ps.print("empty ");
		ps.print(friction);
	}
}

