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
    private static Map map = new Map();
    private static boolean end = false;


	public  static  void  MainMenu (){
        boolean running = true;

        System.out.println("@@@ A program elindult!");
        try {
        while(running) {
            cmd = getcommand();
            switch (cmd.get(0)){
                case "Load" :
                    map.CreatedMap(cmd.get(1));
                    System.out.println("@@@ A jatek betoltve!");
                    break;
                case "Start":
                    System.out.println("@@@ A jatek elkezdodott!");
                    Game();
                    break;
                case "Exit":
                    running = false;
                    break;
                case "Strength":
                    if( cmd.size() == 2)
                        map.setStrange(Integer.parseInt(cmd.get(1)));
                    break;
                case "Wight":
                    if( cmd.size() == 2)
                        map.setWeight(Integer.parseInt(cmd.get(1)));
                    break;
                case "Honey":
                    if( cmd.size() == 2)
                        map.setHoney(Integer.parseInt(cmd.get(1)));
                    break;
                case "Oil":
                    if( cmd.size() == 2)
                        map.setOil(Integer.parseInt(cmd.get(1)));
                    break;
                default:
                    System.out.println("@@@ Ervenytelen parancs");
            }
        }
        }catch (Exception e){}
    }

	private   static  void Game(){
	    while (map.EndGame() && end != true){
	        GameMenu();

        }
    }

	private   static  void GameMenu(){
	    try {
            List<String> com = getcommand();

	        switch (com.get(0)){
                case "Left":
                    map.MoveWorker(Direction.LEFT);
                    break;
                case "Right":
                    map.MoveWorker(Direction.RIGHT);
                    break;
                case "Up":
                    map.MoveWorker(Direction.UP);
                    break;
                case "Down":
                    map.MoveWorker(Direction.DOWN);
                    break;
                case "End":
                    end = true;
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
                    map.save("test");
                    break;
                case "Next":
                    map.NextWorker();
                    break;
                case "DropOil":
                    map.DropOil();
                    break;
                case "DropHoney":
                    map.DropHoney();
                    break;

	        }
        }catch (Exception e){}
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
//	    MainMenu();
			map.CreatedMap("testcases/test19.txt");
			map.printFields(System.out);
			map.printBoxes(System.out);
			map.printWorkers(System.out);

    }
}



