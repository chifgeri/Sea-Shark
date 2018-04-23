package game;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;

// Main osztálya.
//Itt található az az állapotgép-szerű logika, amely meghatározza a program működési folyamatát.
public class Main {

    private static InputStreamReader isr = new InputStreamReader(System.in);
    private static BufferedReader reader = new BufferedReader(isr);
    private static Map map;
    private static boolean end = false;
    
    public static void Log(String msg) {
    	if(Tester.message == true)
    	System.out.println(msg);
    }

	public  static  void  MainMenu (){
        boolean running = true;
        
        Log("@@@ A program elindult!");
        try {
        while(running) {
            Log("@@@ Kovetkezo parancsok elerhetoek: Load <filename>, Start, Exit, Strength <int>, Weight <int>, Honey <int>, Oil <int>");
            cmd = getcommand();
            switch (cmd.get(0)){
                case "Load" :
                    map = new Map();
                    map.CreatedMap(cmd.get(1));
                    Log("@@@ A jatek betoltve!");
                    break;
                case "Start":
                	Log("@@@ A jatek elkezdodott!");
                    Game();
                    break;
                case "Exit":
                	Log("@@@ Kilepes a jatekbol!");
                    running = false;
                    break;
                case "Strength":
                    if( cmd.size() == 2)
                        map.setForce(Integer.parseInt(cmd.get(1)));
                    Log("@@@ Ero beallitva!");
                    break;
                case "Weight":
                    if( cmd.size() == 2)
                        map.setWeight(Integer.parseInt(cmd.get(1)));
                    Log("@@@ Suly beallitva!");
                    break;
                case "Honey":
                    if( cmd.size() == 2)
                        map.setHoney(Integer.parseInt(cmd.get(1)));
                    Log("@@@ Mez beallitva!");
                    break;
                case "Oil":
                    if( cmd.size() == 2)
                        map.setOil(Integer.parseInt(cmd.get(1)));
                    Log("@@@ Olaj beallitva!");
                    break;
                default:
                	Log("@@@ Ervenytelen parancs");
            }
        }
        }catch (Exception e){
        	e.printStackTrace(System.out);
        }
    }

	private   static  void Game(){
			while (end != true)
				GameMenu();	
    }

	private   static  void GameMenu(){
	    try {
	    	Log("@@@ Kovetkezo parancsok elerhetoek: Left, Right, Up, Down, End, listWorkers, listBoxes, listMap, save <filename>, Next, DropOil, DropHoney");
            List<String> com = getcommand();
	        switch (com.get(0)){
                case "Left":
                    map.MoveWorker(Direction.LEFT);
                    Log("@@@ Worker mozgott!");
                    break;
                case "Right":
                    map.MoveWorker(Direction.RIGHT);
                    Log("@@@ Worker mozgott!");
                    break;
                case "Up":
                    map.MoveWorker(Direction.UP);
                    Log("@@@ Worker mozgott!");
                    break;
                case "Down":
                    map.MoveWorker(Direction.DOWN);
                    Log("@@@ Worker mozgott!");
                    break;
                case "End":
                    end = true;
                    Log("@@@ Visszaleptel a menube!");
                    break;
                case "listWorkers":
                    map.printWorkers(System.out);
                    break;
                case "listBoxes":
                    map.printBoxes(System.out);
                    break;
                case "listMap":
                    map.printFields(System.out);
                    break;
                case "save":
                    map.save(com.get(1));
                    Log("@@@ Allas kimentve-->" + com.get(1));
                    break;
                case "Next":
                    map.NextWorker();
                    Log("@@@ Kovetkezo Worker jon");
                    break;
                case "DropOil":
                    map.DropOil();
                    Log("@@@ Worker olajat rakott le!");
                    break;
                case "DropHoney":
                    map.DropHoney();
                    Log("@@@ Worker mezet rakott le!");
                    break;
                default:
                	Log("Ervenytelen parancs");
	        }
        }catch (Exception e){

	        e.printStackTrace();

        }
    }

	private static List<String> cmd = null;

	//Ezt a függvényt használjuk az összes osztályban, ahol a parancssorból utasítást kérünk be.

	private static List<String> getcommand() throws IOException {
        String command = "";
		command = reader.readLine();
		cmd = Arrays.asList(command.split(" "));
		return cmd;
	}

	public static void main(String[] args) throws IOException {
	    MainMenu();
    }
}


