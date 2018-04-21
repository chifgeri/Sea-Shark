package game;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
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

	//Egy k�t�llapot� enum:
	// - mozg�sra k�szen �ll a j�t�kos
	// - mozg�s k�zben van a j�t�kos
	public enum State {
		READY_TO_MOVE,
		MOVE
	}

	//Itt tal�lhat�k azok a publikus statikus v�ltoz�k, amelyek a parancssor kezel�s�hez sz�ks�gesek.

	//Input streamek a parancssorb�l val� sorok beolvas�s�hoz.
	public static InputStreamReader isr = new InputStreamReader(System.in);
	public static BufferedReader reader = new BufferedReader(isr);

	//Ir�ny �s t�vols�g. A felhaszn�l�nak sz�nt inform�ci�, hogy legyen elk�pzel�se a mozg�sr�l.
	//Megtudhatja, hogy merre mozog a munk�s, illetve, hogy milyen ir�nyba.
	public static Direction DIR = null;
	public static int DIST = 0;

	//Az �ppen feldolgozott utas�t�st mentj�k el mindig ebbe a v�ltoz�ba.
	public static String command = "";
	//Ebben a string t�mbben sz�k�z�k ment�n feldarabolva tal�lhatjuk meg a kiadott parancsot.
	public static String[] cmd = null;

	//A munk�s, akit a szkeleton sor�n ir�ny�tunk.
	public static Worker worker = new Worker();

	//Ezt a f�ggv�nyt haszn�ljuk az �sszes oszt�lyban, ahol a parancssorb�l utas�t�st k�r�nk be.
	public static String[] getcommand() throws IOException {
		command = reader.readLine();
		cmd = command.split(" ");
		return cmd;
	}
	//A Main oszt�ly main f�ggv�nye, az IOException a beolvas�s miatt kell.
	public static void main(String[] args) throws IOException {

		//Boolean �rt�k, azt jelzi, hogy fut-e a programunk, alap�rtelmezetten igen.
		boolean running = true;
		//Az alap�rtelmezett �llapot szerint a munk�s k�szen �ll a mozg�sra.
		Main.State state = Main.State.READY_TO_MOVE;

		//A j�t�k elej�n �rjuk ki, t�j�koztatjuk a felhaszn�l�t.
		System.out.println("@@@ A j�t�k elkezd�d�tt!");

		//Egy ciklus, addig fut, am�g  a j�t�k befejez�dik.
		while(running) {
			//A munk�s ekkor mozoghat vagy kil�phet
			if(state == Main.State.READY_TO_MOVE) {
				//A vizsg�lt t�vols�g kezdetben 0, teh�t a worker mez�j�n �llunk a vizsg�lattal
				DIST = 0;
				//Inform�ci�s �zenetek
				System.out.println("@@@ Mozoghatsz, befejezheted a j�t�kot, vagy kil�phetsz.");
				System.out.println("@@@ Seg�ts�g: move [direction] {right, left, up, down}, exit, end.");
				//Parancsbek�r�s
				getcommand();
				//move parancs eset�n a megadott ir�nyba mozgunk
				//Az ir�nyt �gy kapjuk, hogy a parancs m�sodik szav�t nagybet�s�tj�k, majd enum
				//t�pus�v� konvert�ljuk a valueOf() f�ggv�nnyel.
				if(cmd[0].equals("move")) {
					DIR = Direction.valueOf(cmd[1].toUpperCase());
					state = Main.State.MOVE;
				}
				//exit vagy end eset�n kil�p�nk ciklusb�l
				else if(cmd[0].equals("exit") || cmd[0].equals("end") ) {
					System.out.println("@@@ A j�t�k v�get �rt. K�sz�n�m, hogy kirp�b�ltad a szkeletont!");
					running = false;
				}
			}
			//Ha mozg�s k�zben vagyunk, akkor ez a felt�teles �g fut le.
			//A mozg�s parancs kiad�sa ut�n ker�l�nk ide.
			//A munk�st mozgatjuk a megadott ir�nyba.
			//A mozg�s lefut�sa ut�n ism�t k�szen �llunk az �j mozg�sra.
			else if(state == Main.State.MOVE) {
				worker.Move(DIR);
				state = Main.State.READY_TO_MOVE;
			}
		}
	}
}
