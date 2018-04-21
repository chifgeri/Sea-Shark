package game;

import java.io.IOException;
import java.util.ArrayList;
//A t�rk�pet reprezent�l� oszt�ly.
//A szkeletonban nem haszn�ljuk, mivel a fut�s sor�n k�rj�k be a felhaszn�l�t�l
//a t�rk�pen tal�lhat� fieldeket �s itemeket.
public class Map {
	//A t�rk�pen tal�lhat� mez�k list�ja.
	private ArrayList<Field> fields = new ArrayList<Field>();
	//A t�rk�pen tal�lhat� munk�sok list�ja.
	private ArrayList<Worker> workers = new ArrayList<Worker>();

	private int actualWorkerNumber = 0;

	private int sizeX;

	private int sizeY;


	public void CreatedMap(String filename){

	}

	public void Save(String filename){

	}

	public  void Print(){

	}

	public boolean EndGame(){
		return true;
	}

	public Worker TopScorePlayer(){
		return new Worker();
	}

	public void NextWorker(){
		if(workers.size() > actualWorkerNumber)
		    actualWorkerNumber++;
        else
            actualWorkerNumber = 0;
	}

	public  void MoveWorker(Direction d){
	        if(workers.size() > 0)
			    workers.get(actualWorkerNumber).Move(d);
		}

	}




