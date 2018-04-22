package game;

import java.io.IOException;
//A munk�st reprezent�l� oszt�ly.
public class Worker extends Pushable {
	//A munk�s pontsz�ma.
	protected int score = 0;
	
	//Lek�rdezz�k a munk�s pontsz�m�t.
	public int getScore() {
		//System.out.println("--- Worker getScore()");
		return score;
	}
	//Be�ll�tjuk a munk�s pontsz�m�t.
	public void setScore(int s) {
		System.out.println("--- Worker setScore()");
		score = s;
	}
	//A munk�s mozg�s f�ggv�nye a megadott ir�nyba.
	public boolean Move(Direction d) {
		//System.out.println("--- Worker Move()");
		//A Main f�ggv�nyben n�velj�k a t�vols�g v�ltoz� �rt�k�t, mivel a szomsz�dokat fogjuk vizsg�lni.
		Main.DIST++;
		//Inform�ci�s �zenet.
		System.out.println("@@@ Mozogni pr�b�l a munk�s!");
		//Lek�rdezz�k a szomsz�dot.
		Field neighbor = actual.getNeighborAt(d);
		//Lek�rdezz�k a szomsz�don l�v� itemet.
		Pushable neighbor_item = neighbor.getItem();
		//A szomsz�don l�v� itemnek be�ll�tjuk a szomsz�dot annak fieldjek�nt.
		//(Persze a szomsz�don van item, csak akkor.)
		if(neighbor_item != null)
			neighbor_item.actual=neighbor;
		//Ha a szomsz�don l�v� item null, akkor true-val t�r�nk vissza, mert el tud mozdulni oda az item.
		//Ha a szomsz�don l�v� itemet el tudjuk tolni, akkor is.
		//Ekkor egy sor keletkezik, teh�t az �sszes szomsz�dos itemet meg pr�b�ljuk eltolni.
		if( neighbor_item==null || neighbor_item.Push(d) ) {
			//Az eltol�s sor�n a szomsz�d item�t be�ll�tjuk a munk�sra,
			//Az aktu�lis fieldr�l pedig elt�vol�tjuk a munk�st.
			neighbor.setItem(this);
			actual.removeItem();
			//Inform�ci�s �zenet.
			System.out.println("@@@ A munk�s "+Main.DIR+" ir�nyba mozgott!");
			return true; 
		}
		//Egy�b esetben a munk�s nem tud mozogni, ezt tudatjuk a felhaszn�l�val is.
		System.out.println("@@@ A munk�s nem tud mozogni!");
		return false;
	}
	//A tol�d�s jelent� f�ggv�ny, nagyon hasonl�t a mozg�sra.
	//A munk�s mindenk�ppen el tud tol�dni, ha nincs hely, akkor �sszenyom�dik.
	public boolean Push(Direction d) {
		//System.out.println("--- Box Push()");
		Main.DIST++;
		System.out.println("@@@ Tol�dni pr�b�l a munk�s!");
		
		Field neighbor = actual.getNeighborAt(d);
		Pushable neighbor_item = neighbor.getItem();
		if(neighbor_item != null)
			neighbor_item.actual=neighbor;
		if( neighbor_item==null || neighbor_item.Push(d) ) {
			neighbor.setItem(this);
			actual.removeItem();
			System.out.println("@@@ A munk�s "+Main.DIR+" ir�nyba tol�dott!");
			return true; 
		}
		System.out.println("@@@ A munk�s a falnak nyom�dott!");
		Die();
		return true;
	}
	//A munk�s leesik, ekkor meg is hal.
	public void Fall() {
		//System.out.println("--- Worker Fall()");
		System.out.println("@@@ A munk�s leesett!");
		Die();
	}
	//A munk�s meghal.
	public void Die() {
		//System.out.println("--- Worker Die()");
		System.out.println("@@@ A munk�s meghalt!");
	}

	@Override
	public void setActual(Field field) {
		actual = field;
	}
}
