package game;
import java.io.PrintStream;
//Célmezõt reprezentáló osztály
public class Goal extends Field{

    public Goal(){super();}
    public Goal(Pushable p){
        super(p);
    }
    //Ha dobozt tolunk a célmezõre, aktiváljuk azt.
    public void activate() {
     if(Map.actualPlayer!=null)
    	 Map.actualPlayer.addScore(100);
    }



	public void print( PrintStream ps) {
		ps.print("Goal ");
		if(item!=null)
			item.printType(ps);
			else
			ps.print("empty ");
		ps.print(friction);
	}

}
