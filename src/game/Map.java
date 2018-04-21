package game;

import java.io.IOException;
import java.util.ArrayList;
//A térképet reprezentáló osztály.
//A szkeletonban nem használjuk, mivel a futás során kérjük be a felhasználótól
//a térképen található fieldeket és itemeket.
public class Map {
	//A térképen található mezõk listája.
	private ArrayList<Field> fields = new ArrayList<Field>();
	//A térképen található munkások listája.
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




