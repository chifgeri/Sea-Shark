package game;
//C�lmez�t reprezent�l� oszt�ly
public class Goal extends Field{

	public Goal(){}

	public Goal(Pushable p){
		super(p);
	}
	//Ha dobozt tolunk a c�lmez�re, aktiv�ljuk azt.
	public void activate() {
		//System.out.println("--- Goal activate()");
		System.out.println("@@@ A goal aktiv�l�dott!");
	}
}
