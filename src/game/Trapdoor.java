package game;

import java.awt.Graphics;
import java.io.PrintStream;

/**
 * Csapóajtót reprezentáló osztály.
 */
public class Trapdoor extends Field{

	/**
	 * Azt jelzi, hogy nyilva van-e a csapóajtó.
	 */
    private boolean open = false;

    public Trapdoor(){super();}
    public Trapdoor(Pushable p){
        super(p);
    }
    /**
     *A csapóajtóra beállítunk itemet.
     *Ha csukva van, akkor úgy viselkedik, mint egy egyszerű mező.
     *Ha nyitva van, akkor pedig úgy, mint egy lyuk.
     */
    public void setItem(Pushable p){
        /**
         * Beállítjuk az itemet, majd a specifikus viselkedést végrehajtjuk.
         */
        item = p;
        /**
         * Ha nyitva van, akkor az item leesik, majd eltávolítjuk a csapóajtóból.
         * (Feltéve, ha az a item nem null).
         */
        if(open) {
            if(item != null) {
                item.Fall();
                removeItem();
            }
        }
    }
    /**
     * A csapóajtó állapotát állítja be a megadott értékre.
     */
    public void switch_(boolean b) {
        open = b;
        if(open) {
            if(item != null) {
                item.Fall();
                removeItem();
            }
        }
    }

	/**
	 * A kimeneti nyelvnek megfelelően kiírja az információkat a megadott streambe
	 */
	public void print( PrintStream ps) {
		ps.print("Trapdoor ");
		if(item!=null)
			item.printType(ps);
		else
			ps.print("empty ");
		ps.print(friction+" ");
		if(open)
		ps.print("open");
		else
		ps.print("closed");	
	}
	
	public void Draw(Graphics g) {
		// TODO Auto-generated method stub
		if(open)
			g.drawImage(GamePanel.TrapOpenImage, x, y,null);
		else
			g.drawImage(GamePanel.TrapClosedImage, x, y,null);
		if(friction>10)
			g.drawImage(GamePanel.OilImage, x, y,null);
		if(friction<10)
			g.drawImage(GamePanel.HoneyImage, x, y,null);
	}
}