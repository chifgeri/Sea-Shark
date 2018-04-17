package game;

import java.io.IOException;
//Csap�ajt�t reprezent�l� oszt�ly.
public class Trapdoor extends Field{
	//Azt jelzi, hogy nyilva van-e a csap�ajt�.
	protected boolean open = false;
	
	//A csap�ajt�ra be�ll�tunk itemet.
	//Ha csukva van, akkor �gy viselkedik, mint egy egyszer� mez�.
	//Ha nyitva van, akkor pedig �gy, mint egy lyuk.
	public void setItem(Pushable p) throws IOException {
		//System.out.println("--- Trapdoor setItem()");
		//Megk�rdezz�k a felhaszn�l�t�la a csap�ajt� �llapot�t.
		System.out.println("??? Nyitva van a trapdoor? {true, false}");
		//Parancsbek�r�s.
		Main.getcommand();
		//Be�ll�tjuk az �j �llapotot
		if(Main.cmd[0].equals("true")) 
			switch_(true);
		if(Main.cmd[0].equals("false")) 
			switch_(false);
		//Be�ll�tjuk az itemet, majd a specifikus viselked�st v�grehajtjuk.
		item = p;
		//Ha nyitva van, akkor az item leesik, majd elt�vol�tjuk a csap�ajt�b�l.
		//(Felt�ve, ha az a item nem null).
		if(open) {
			if(item != null) {
				item.Fall();
				removeItem();
			}
		}
	}
	//A csap�ajt� �llapot�t �ll�tja be a megadott �rt�kre.
	public void switch_(boolean b) {
		open=b;
	}
}
