package game;

import java.util.ArrayList;
//A térképet reprezentáló osztály.
//A szkeletonban nem használjuk, mivel a futás során kérjük be a felhasználótól
//a térképen található fieldeket és itemeket.
public class Map {
	//A térképen található mezõk listája.
	protected ArrayList<Field> fields = new ArrayList<Field>();
	//A térképen található munkások listája.
	protected ArrayList<Worker> workers = new ArrayList<Worker>();
	
	//Mezõt adunk hozzá a térképhez.
	public void addField(Field f) {
		fields.add(f);
	}
	//Munkást adunk hozzá a térképhez.
	public void addWorker(Worker w) {
		workers.add(w);
	}
}
