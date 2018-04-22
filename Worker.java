package game;

import java.io.IOException;
//A munk�st reprezent�l� oszt�ly.
public class Worker extends Pushable {
	//A munk�s pontsz�ma.
	protected int score = 0;
	protected int weight= 10;
	protected int force= 200;
	protected int honey= 2;
	protected int oil= -2;
	
	//A munk�s mozg�s f�ggv�nye a megadott ir�nyba.
	public boolean Move(Direction d) {
		//A Main f�ggv�nyben n�velj�k a t�vols�g v�ltoz� �rt�k�t, mivel a szomsz�dokat fogjuk vizsg�lni.
		Main.DIST++;
	
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
			return true; 
		}
		//Egy�b esetben a munk�s nem tud mozogni, ezt tudatjuk a felhaszn�l�val is.
		return false;
	}
	//A tol�d�s jelent� f�ggv�ny, hasonl�t a mozg�sra, de most a surl�d�ssal is sz�molni kell.
	//A munk�s mindenk�ppen el tud tol�dni, ha nincs hely, akkor �sszenyom�dik.
	public boolean Push(Direction d, int force) {
		Main.DIST++;
		
		Field neighbor = actual.getNeighborAt(d);
		Pushable neighbor_item = neighbor.getItem();
		
		if(neighbor_item != null)
			neighbor_item.actual=neighbor;
		
		if(force <= (neighbor.friction * neighbor_item.weight))
			return false;
		
		int newforce= force - (neighbor.friction * neighbor_item.weight);
		if( neighbor_item==null || neighbor_item.Push(d, newforce) ) {
			neighbor.setItem(this);
			actual.removeItem();
			return true; 
		}
		Die()
		return true;
	}
	
	//olajat �nt a mez�re, cs�kkenti a surl�d�st.
	public void DropOil() {
		actual.changeFriction(oil);
	}
	
	//m�zet �nt a mez�re, n�veli a surl�d�st.
	public void DropHoney() {
		actual.changeFriction(honey);
	}
	
	//A munk�s leesik, ekkor meg is hal.
	public void Fall() {
		Die();
	}
	//A munk�s meghal.
	public void Die() {
		actual.removeItem();
		actual= null;
	}
}