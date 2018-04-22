package game;

import java.io.IOException;
//Lyukat reprezent�l� oszt�ly
public class Hole extends Field{
	
	//A lyukba be�ll�tjuk az itemet, val�j�ban a leesik, majd kit�r�lj�k.
	public void setItem(Pushable p)  {
		//System.out.println("--- Hole setItem()");
		item = p;
		if(item != null) {
			item.Fall();
			removeItem();
		}
	}
}
