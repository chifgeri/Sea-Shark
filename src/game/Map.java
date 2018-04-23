package game;


import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import java.io.File;
import java.io.PrintStream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;


public class Map {

	
	private List<Field> fields = new ArrayList<>();
	private List<Worker> workers = new ArrayList<>();
    private List<Box> boxes = new ArrayList<>();

    public static Worker actualPlayer;
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
        BufferedReader br = null;
        try {    
        br=new BufferedReader(new FileReader(filename));
        String line = br.readLine();
        List<String> cmd = Arrays.asList(line.split("x"));
        sizeX = Integer.parseInt(cmd.get(0));
        sizeY = Integer.parseInt(cmd.get(1));

        while ((line = br.readLine()) != null && line.equals("")){
            cmd = Arrays.asList(line.split(" "));
            for(String parm : cmd){
                Pushable p;
                List<String> subcmd =  Arrays.asList(pushableCmd(parm));
                switch(parm.charAt(0)){
                    case 'F' :
                        p = createPushable(subcmd.get(0));
                        Field f = new Field(p);
                        if(p!=null)
                        p.setActual(f);
                        fields.add(f);
                        if(subcmd.size() == 2)
                            f.changeFriction(Integer.parseInt(subcmd.get(1)));
                        break;
                    case 'W' :
                        fields.add(new Field(new Wall()));
                        break;
                    case 'S' :
                        if(subcmd.size() == 2) {
                            p = createPushable(subcmd.get(0));
                            Switch s = new Switch(p);
                            if(p!=null)
                            p.setActual(s);
                            switchMap.put(subcmd.get(1), s);
                            fields.add(s);
                            if(subcmd.size() == 3)
                                s.changeFriction(Integer.parseInt(subcmd.get(2)));
                        }
                        else throw new IllegalArgumentException();
                        break;
                    case 'T' :
                        if(subcmd.size() == 2) {
                            p = createPushable(subcmd.get(0));
                            Trapdoor t = new Trapdoor(p);
                            if(p!=null)
                            p.setActual(t);
                            trapdoorMap.put(subcmd.get(1), t);
                            fields.add(t);
                            if(subcmd.size() == 3)
                                t.changeFriction(Integer.parseInt(subcmd.get(2)));
                        }
                        else throw new IllegalArgumentException();
                        break;
                    case 'H' :
                        fields.add(new Hole());
                        break;
                    case 'G' :
                        p = createPushable(subcmd.get(0));
                        Goal g = new Goal(p);
                        if(p!=null)

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
        	e.printStackTrace();
        }
        finally {
        	if(br!=null) {
        		 try {
                     br.close();
                 } catch (IOException e) {
                    e.printStackTrace();
                 }
        	}
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

	public boolean EndGame(){
//	    if(workers.size() == 1)
//	        return false;
//	    for(Box b : boxes)
//            if (b.movable())
//                return true;
//        return false;
    return true;
	}

	public Worker TopScorePlayer(){
	    int maxScore = 0;
	    Worker maxW = null;
	    for(Worker w : workers)
	        if(w.getScore() > maxScore) {
                maxScore = w.getScore();
                maxW = w;
            }
	    return maxW;
	}

	public void NextWorker(){
		if(workers.size() > actualWorkerNumber)
		    actualWorkerNumber++;
        else
            actualWorkerNumber = 0;
		actualPlayer=workers.get(actualWorkerNumber);
	}

	public  void MoveWorker(Direction d){
	        if(workers.size() > 0)
			    workers.get(actualWorkerNumber).Move(d);
		}
    public void setWeight(int weight){
	    for(Worker w: workers)
	        w.setWeight(weight);

	    for(Box b: boxes)
	        b.setWeight(weight);
    }

    public  void setForce(int strange){
	    for(Worker w: workers)
	        w.setForce(strange);
    }

    public  void setOil(int oil){
	    for(Worker w: workers)
	        w.setOil(oil);
    }

    public  void setHoney(int honey){
	    for(Worker w: workers)
	        w.setHoney(honey);
    }

    public void DropOil(){
	    actualPlayer.DropOil();
    }

    public void DropHoney(){
	    actualPlayer.DropHoney();
    }

	
	public void printWorkers(PrintStream ps) {
		int i=1;
		ps.println("Workers");
		for (Worker w : workers) {
			ps.print(i+". ");
			int j=fields.indexOf(w.actual);
			ps.print("["+j/sizeX+","+j%sizeX+"]"+" ");
			ps.print(w.score);
			ps.print("\n");
			i++;
		}
}

public void printBoxes(PrintStream ps) {
		int i=1;
		ps.println("Boxes:");
		for (Box b : boxes) {
				ps.print(i+". ");
			int j=fields.indexOf(b.actual);
			ps.print("["+j/sizeX+","+j%sizeX+"]"+" ");
			ps.print(b.weight);
			ps.print("\n");
			i++;
		}
	}
	
	
public void printFields(PrintStream ps) {
		int i=0;
		ps.println("Fields:");
		for (Field f : fields) {
			ps.print((i+1)+". ");
			ps.print("["+i/sizeX+","+i%sizeX+"]"+" ");
			f.print(ps);
			ps.print("\n");
			i++;
		}
}

public void save(String filename)  {
		File file=new File(filename);
		try {
		if(!file.exists())
			file.createNewFile();
		
			PrintStream ps=new PrintStream(file);
			printWorkers(ps);
			printBoxes(ps);
			printFields(ps);
			ps.close();
		} catch (IOException e ) {
			e.printStackTrace();
}
}
}

