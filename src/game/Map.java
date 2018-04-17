package game;

import java.util.ArrayList;
//A t�rk�pet reprezent�l� oszt�ly.
//A szkeletonban nem haszn�ljuk, mivel a fut�s sor�n k�rj�k be a felhaszn�l�t�l
//a t�rk�pen tal�lhat� fieldeket �s itemeket.
public class Map {
	//A t�rk�pen tal�lhat� mez�k list�ja.
	protected ArrayList<Field> fields = new ArrayList<Field>();
	//A t�rk�pen tal�lhat� munk�sok list�ja.
	protected ArrayList<Worker> workers = new ArrayList<Worker>();
	
	//Mez�t adunk hozz� a t�rk�phez.
	public void addField(Field f) {
		fields.add(f);
	}
	//Munk�st adunk hozz� a t�rk�phez.
	public void addWorker(Worker w) {
		workers.add(w);
	}
}
