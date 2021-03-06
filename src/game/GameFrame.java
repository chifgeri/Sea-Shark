package game;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import javax.swing.JFrame;

/**
 * Main osztálya.
 * Itt található az az állapotgép-szerű logika, amely meghatározza a program működési folyamatát.
 */

public class GameFrame extends JFrame {
	public static final int FRAME_WIDTH = 800;
	public static final int FRAME_HEIGHT = 800;
	private static final long serialVersionUID = 1L;
	private static InputStreamReader isr = new InputStreamReader(System.in);
    private static BufferedReader reader = new BufferedReader(isr);
    public static Map map;
    private static boolean end = false;
    private static GamePanel gamepanel;
    private static MenuPanel menupanel;
    public static void Log(String msg) {
        if(Tester.message == true)
            System.out.println(msg);
    }
    /**
     * A játék főmenüjét reprezentáló logika
     */
    public void MainMenu (){
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
    /**
     * A játékot reprezentáló logika.
     * @throws IOException 
     */
    public void Game() throws IOException{
       	getContentPane().removeAll();
       	gamepanel = new GamePanel(map);
    	getContentPane().add(gamepanel,BorderLayout.CENTER);
    	setVisible(true);
    	setFocusable(true);
    	pack();

        while (end != true)
            GameMenu();
    }
    /**
     * A játék menüjét reprezentáló logika
     */
    private static void GameMenu(){
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
    /**
     * Ezt a függvényt használjuk az összes osztályban, ahol a parancssorból utasítást kérünk be.
     */
    private static List<String> getcommand() throws IOException {
        String command = "";
        command = reader.readLine();
        if(command != "")
            cmd = Arrays.asList(command.split(" "));
        return cmd;
    }
    
    
    GameFrame() throws IOException{
    	super("Sokoban Game");
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		setMinimumSize(new Dimension(FRAME_WIDTH, FRAME_HEIGHT));
		setResizable(false);
		setLocationRelativeTo(null);
		setVisible(true);
		menupanel = new MenuPanel();
		add(menupanel,BorderLayout.CENTER);
		setFocusable(true);
		pack();
    	}
}