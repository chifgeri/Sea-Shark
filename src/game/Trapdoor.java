package game;

import java.io.IOException;
//Csapóajtót reprezentáló osztály.
public class Trapdoor extends Field{
	//Azt jelzi, hogy nyilva van-e a csapóajtó.
	protected boolean open = false;
	
	//A csapóajtóra beállítunk itemet.
	//Ha csukva van, akkor úgy viselkedik, mint egy egyszerû mezõ.
	//Ha nyitva van, akkor pedig úgy, mint egy lyuk.
	public void setItem(Pushable p) throws IOException {
		//System.out.println("--- Trapdoor setItem()");
		//Megkérdezzük a felhasználótóla a csapóajtó állapotát.
		System.out.println("??? Nyitva van a trapdoor? {true, false}");
		//Parancsbekérés.
		Main.getcommand();
		//Beállítjuk az új állapotot
		if(Main.cmd[0].equals("true")) 
			switch_(true);
		if(Main.cmd[0].equals("false")) 
			switch_(false);
		//Beállítjuk az itemet, majd a specifikus viselkedést végrehajtjuk.
		item = p;
		//Ha nyitva van, akkor az item leesik, majd eltávolítjuk a csapóajtóból.
		//(Feltéve, ha az a item nem null).
		if(open) {
			if(item != null) {
				item.Fall();
				removeItem();
			}
		}
	}
	//A csapóajtó állapotát állítja be a megadott értékre.
	public void switch_(boolean b) {
		open=b;
	}
}
