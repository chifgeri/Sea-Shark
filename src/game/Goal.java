package game;
import java.awt.Graphics;
import java.io.PrintStream;
/**
 * Célmezõt reprezentáló osztály
 */
public class Goal extends Field{

    public Goal(){super();}
    public Goal(Pushable p){
        super(p);
    }
    /**
     * Ha dobozt tolunk a célmezõre, aktiváljuk azt.
     */
    public void activate() {
    	if(Map.actualPlayer!=null)
    		Map.actualPlayer.addScore(100);
    	((Box)item).setscored(true);
    }

    /**
     * /A kimeneti nyelvnek megfelelően kiírja az információkat a megadott streambe
     */
	public void print( PrintStream ps) {
		ps.print("Goal ");
		if(item!=null)
			item.printType(ps);
			else
			ps.print("empty ");
		ps.print(friction);
	}
	
	public void Draw(Graphics g) {
		// TODO Auto-generated method stub
		g.drawImage(Images.GoalImage, x, y,null);
		if(friction>10)
			g.drawImage(Images.OilImage, x, y,null);
		if(friction<10)
			g.drawImage(Images.HoneyImage, x, y,null);
		if(item!=null)
			item.Draw(g);
	}

}