package game;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

//A t�rk�pet reprezent�l� oszt�ly.
//A szkeletonban nem haszn�ljuk, mivel a fut�s sor�n k�rj�k be a felhaszn�l�t�l
//a t�rk�pen tal�lhat� fieldeket �s itemeket.
public class Map {
	//A t�rk�pen tal�lhat� mez�k list�ja.
	private List<Field> fields = new ArrayList();
	//A t�rk�pen tal�lhat� munk�sok list�ja.
	private List<Worker> workers = new ArrayList<>();

    private List<Box> boxes = new ArrayList<>();


	private int actualWorkerNumber = 0;

	private int sizeX;

	private int sizeY;

	private Pushable createPushable(String cmd) throws  IllegalArgumentException{
	    switch (cmd){
            case "W":
                Worker w = new Worker();
                workers.add(w);
                return w;
            case "B":
                Box b = new Box();
                boxes.add(b);
                return b;
            case "_":
                return null;
            default:
                throw new IllegalArgumentException();
        }

    }

    private String[] pushableCmd(String s){
        String sub = s.substring(2, s.length()-1);
        return sub.split(",");
    }

	public void CreatedMap(String filename) throws IllegalArgumentException{

        java.util.Map<String, Switch> switchMap = new HashMap<>();
        java.util.Map<String, Trapdoor> trapdoorMap = new HashMap<>();
        try {
	    BufferedReader br = new BufferedReader(new FileReader(filename));
        String line = br.readLine();
        String[] cmd = line.split("x");
        sizeX = Integer.parseInt(cmd[0]);
        sizeY = Integer.parseInt(cmd[1]);

        while ((line = br.readLine()) != null){
            cmd = line.split(" ");
            for(String parm : cmd){
                Pushable p;
                String[] subcmd = pushableCmd(parm);
                switch(parm.charAt(0)){
                    case 'F' :
                        p = createPushable(subcmd[0]);
                        Field f = new Field(p);
                        p.setActual(f);
                        fields.add(f);
                        break;
                    case 'W' :
                        fields.add(new Field(new Wall()));
                        break;
                    case 'S' :
                        if(subcmd.length == 2) {
                            p = createPushable(subcmd[0]);
                            Switch s = new Switch(p);
                            p.setActual(s);
                            switchMap.put(subcmd[1], s);
                            fields.add(s);
                        }
                        else throw new IllegalArgumentException();
                        break;
                    case 'T' :
                        if(subcmd.length == 2) {
                            p = createPushable(subcmd[0]);
                            Trapdoor t = new Trapdoor(p);
                            p.setActual(t);
                            trapdoorMap.put(subcmd[1], t);
                            fields.add(t);
                        }
                        else throw new IllegalArgumentException();
                        break;
                    case 'H' :
                        fields.add(new Hole());
                        break;
                    case 'G' :
                        p = createPushable(subcmd[0]);
                        Goal g = new Goal(p);
                        p.setActual(g);
                        fields.add(g);
                        break;
                    default:
                        System.out.println("Wrong file");
                        throw new IllegalArgumentException();
                }

            }
        }
        }
        catch (Exception e){
        }
        if(fields.size() != sizeX * sizeY)
            throw  new IllegalArgumentException();

        for(int i = 0; i < fields.size(); ++i){
            Field field = fields.get(i);
            if(i%sizeX != 0)
                field.setNeighboursAt(Direction.LEFT, fields.get(i-1));
            if(i%sizeX != sizeX-1)
                field.setNeighboursAt(Direction.RIGHT, fields.get(i+1));
            if(i/sizeX != 0 )
                field.setNeighboursAt(Direction.UP, fields.get(i-sizeX));
            if(i/sizeX != sizeY-1)
                field.setNeighboursAt(Direction.DOWN, fields.get(i+sizeX));
        }
        if(switchMap.size() != trapdoorMap.size())
            throw new IllegalArgumentException();
        for(java.util.Map.Entry<String, Switch> entry : switchMap.entrySet()){
            Trapdoor t = trapdoorMap.get(entry.getKey());
            if (t != null)
                entry.getValue().setTrapdoor(t);
            else throw new  IllegalArgumentException();
        }


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




