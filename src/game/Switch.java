package game;
//Kapcsol�t reprezent�l� oszt�ly.
public class Switch extends Field {
	//Az itemet be�ll�tjuk a kapcsol�ra.
	public void setItem(Pushable p) {
		//System.out.println("--- Switch setItem()");
	}
	//A doboz h�vja meg, amikor r�toljuk. A hozz� tartoz� csap�ajt�t nyitja ki.
	public void activate() {
		//System.out.println("--- Switch activate()");
		System.out.println("@@@ A switch aktiv�l�dott!");
	}
}
