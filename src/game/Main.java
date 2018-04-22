package game;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//A program Main osztálya.
//Itt található az az állapotgép-szerû logika, amely meghatározza a program mûködési folyamatát.
public class Main {


    //Input streamek a parancssorból való sorok beolvasásához.
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
	//A Main osztály main függvénye, az IOException a beolvasás miatt kell.
	public static void main(String[] args) throws IOException {


		
		//Boolean érték, azt jelzi, hogy fut-e a programunk, alapértelmezetten igen.
		boolean running = true;

		//A játék elején írjuk ki, tájékoztatjuk a felhasználót.
		System.out.println("@@@ A játék elkezdõdött!");

		//Egy ciklus, addig fut, amíg  a játék befejezõdik.
		while(running) {
		    String[] cmd = getcommand();
            switch (cmd[0]){
                case "Load" :
                    map.CreatedMap(cmd[1]);
                    System.out.println("@@@ A játék betoltve!");
                    break;
                case "Start" :
                    Game();
                    break;
                case "Exit" :
                    running = false;
                    break;
                case "Strength" :
                    break;
                case "Wight" :
                    break;
                case "Honey" :
                    break;
                case "Oil" :
                    break;
                default:
                    System.out.println("@@@ Ervenytelen parancs");
            }
        }
//			//A munkás ekkor mozoghat vagy kiléphet
//			if(state == State.READY_TO_MOVE) {
//				//A vizsgált távolság kezdetben 0, tehát a worker mezõjén állunk a vizsgálattal
//				DIST = 0;
//				//Információs üzenetek
//				System.out.println("@@@ Mozoghatsz, befejezheted a játékot, vagy kiléphetsz.");
//				System.out.println("@@@ Segítség: move [direction] {right, left, up, down}, exit, end.");
//				//Parancsbekérés
//				getcommand();
//				//move parancs esetén a megadott irányba mozgunk
//				//Az irányt úgy kapjuk, hogy a parancs második szavát nagybetûsítjük, majd enum
//				//típusúvá konvertáljuk a valueOf() függvénnyel.
//				if(cmd[0].equals("move")) {
//					DIR = Direction.valueOf(cmd[1].toUpperCase());
//					state = State.MOVE;
//				}
//				//exit vagy end esetén kilépünk ciklusból
//				else if(cmd[0].equals("exit") || cmd[0].equals("end") ) {
//					System.out.println("@@@ A játék véget ért. Köszönöm, hogy kirpóbáltad a szkeletont!");
//					running = false;
//				}
//			}
//			//Ha mozgás közben vagyunk, akkor ez a feltételes ág fut le.
//			//A mozgás parancs kiadása után kerülünk ide.
//			//A munkást mozgatjuk a megadott irányba.
//			//A mozgás lefutása után ismét készen állunk az új mozgásra.
//			else if(state == State.MOVE) {
//				worker.Move(DIR);
//				state = State.READY_TO_MOVE;
//				}
//		}
	}
}
