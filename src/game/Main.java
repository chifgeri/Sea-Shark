package game;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// Main osztálya.
//Itt található az az állapotgép-szerű logika, amely meghatározza a program működési folyamatát.
public class Main {

    private static InputStreamReader isr = new InputStreamReader(System.in);
    private static BufferedReader reader = new BufferedReader(isr);
    private static Map map = new Map();
	
	//Egy kétállapotú enum:
	// - mozgásra készen áll a játékos
	// - mozgás közben van a játékos

	public enum State {
		READY_TO_MOVE,
		MOVE
	}

	public  static  void  MainMenu(){}

	public  static  void Game(){}

	public  static  void GameMenu(){}
	

	//Itt találhatók azok a publikus statikus változók, amelyek a parancssor kezeléséhez szükségesek.

	
	

	//Irány és távolság. A felhasználónak szánt információ, hogy legyen elképzelése a mozgásról.
	//Megtudhatja, hogy merre mozog a munkás, illetve, hogy milyen irányba.
	public static Direction DIR = null;
	public static int DIST = 0;
	
	//Az éppen feldolgozott utasítást mentjük el mindig ebbe a változóba.
	public static String command = "";
	//Ebben a string tömbben szóközök mentén feldarabolva találhatjuk meg a kiadott parancsot.
	private static String[] cmd = null;
	
	//A munkás, akit a szkeleton során irányítunk.
	public static Worker worker = new Worker();
	
	//Ezt a függvényt használjuk az összes osztályban, ahol a parancssorból utasítást kérünk be.

	public static String[] getcommand() throws IOException {
		command = reader.readLine();
		cmd = command.split(" ");
		return cmd;
	}

	//A Main oszt�ly main f�ggv�nye, az IOException a beolvas�s miatt kell.
	public static void main(String[] args) throws IOException {



        //Boolean �rt�k, azt jelzi, hogy fut-e a programunk, alap�rtelmezetten igen.
        boolean running = true;

        //A j�t�k elej�n �rjuk ki, t�j�koztatjuk a felhaszn�l�t.
        System.out.println("@@@ A jatek elkezdodott!");

        //Egy ciklus, addig fut, am�g  a j�t�k befejez�dik.


		while(running) {
		    String[] cmd = getcommand();
            switch (cmd[0]){
                case "Load" :
                    map.CreatedMap(cmd[1]);
                    System.out.println("@@@ A jatek betoltve!");
                    break;
                case "Start":
                    Game();
                    break;
                case "Exit":
                    running = false;
                    break;
                case "Strength":
                    if( cmd.length == 2)
                        map.setStrange(Integer.parseInt(cmd[1]));
                    break;
                case "Wight":
                    if( cmd.length == 2)
                     map.setWeight(Integer.parseInt(cmd[1]));
                    break;
                case "Honey":
                    if( cmd.length == 2)
                        map.setHoney(Integer.parseInt(cmd[1]));
                    break;
                case "Oil":
                    if( cmd.length == 2)
                        map.setOil(Integer.parseInt(cmd[1]));
                    break;
                default:
                    System.out.println("@@@ Ervenytelen parancs");
            }
        }
    }
			
//			map.CreatedMap("map");
//			map.printFields(System.out);
//			map.printBoxes(System.out);
//			map.printWorkers(System.out);
}



