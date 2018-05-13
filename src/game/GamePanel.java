package game;

import java.awt.Image;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.File;
import java.io.IOException;
import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.JComponent;


public class GamePanel  extends JComponent  implements KeyListener {
	static Image WallImage;
	static Image WorkerImage;
    static Image FieldImage;
    static Image BoxImage;
	static Image GoalImage;
    static Image HoleImage;
    static Image HoneyImage;
	static Image OilImage;
    static Image SwitchImage;
    static Image TrapClosedImage;
	static Image TrapOpenImage;
    static Image MarkerImage;

    Map map;	
    
	GamePanel(Map _map)throws IOException
	{
        addKeyListener(this);
		map=_map;
		this.setMinimumSize(new Dimension(map.sizeX*40,map.sizeY*40));

		WallImage=javax.imageio.ImageIO.read(new File("images/wall.png"));
	    WorkerImage=javax.imageio.ImageIO.read(new File("images/worker.png"));
	    FieldImage=javax.imageio.ImageIO.read(new File("images/field.png"));
	     BoxImage=javax.imageio.ImageIO.read(new File("images/box.png"));
		 GoalImage=javax.imageio.ImageIO.read(new File("images/goal.png"));
	     HoleImage=javax.imageio.ImageIO.read(new File("images/hole.png"));
	    HoneyImage=javax.imageio.ImageIO.read(new File("images/honey.png"));
		OilImage=javax.imageio.ImageIO.read(new File("images/oil.png"));
	     SwitchImage=javax.imageio.ImageIO.read(new File("images/switch.png"));
	     TrapClosedImage=javax.imageio.ImageIO.read(new File("images/trapdoor_closed.png"));
		 TrapOpenImage=javax.imageio.ImageIO.read(new File("images/trapdoor_open.png"));
		 MarkerImage=javax.imageio.ImageIO.read(new File("images/marker.png"));

	}
	public void paint(Graphics g) {
    	map.DrawAll(g);
	}

    @Override
    public void keyTyped(KeyEvent keyEvent) {

    }

    @Override
    public void keyPressed(KeyEvent keyEvent) {
        boolean validKey = false;
	    if(keyEvent.getKeyCode() == Map.getActualPlayer().getLeftKey()) {
            map.MoveWorker(Direction.LEFT);
            validKey = true;
	    }

        if(keyEvent.getKeyCode() == Map.getActualPlayer().getRightKey()) {
            map.MoveWorker(Direction.RIGHT);
            validKey = true;
        }

        if(keyEvent.getKeyCode() == Map.getActualPlayer().getUpKey()) {
            map.MoveWorker(Direction.UP);
            validKey = true;
	    }

        if(keyEvent.getKeyCode() ==Map.getActualPlayer().getDownKey()) {
            map.MoveWorker(Direction.DOWN);
            validKey = true;
        }


        if(keyEvent.getKeyCode() == Map.getActualPlayer().getHoneyKey()) {
            map.DropHoney();
            validKey = true;
	    }

        if(keyEvent.getKeyCode() == Map.getActualPlayer().getOilKey()) {
            map.DropOil();
            validKey = true;
        }

        if (validKey){
            repaint();
            map.NextWorker();
            System.out.println(keyEvent.getKeyChar());
            endGame();
        }
        else
            System.out.println("Wrong key");
    }

    @Override
    public void keyReleased(KeyEvent keyEvent) {

    }

    private void endGame(){
	    if(map.EndGame())
	        try {
                Main.Menu();
            }catch (Exception e){e.printStackTrace();}

    }
}
