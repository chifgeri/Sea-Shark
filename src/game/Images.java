package game;

import java.awt.Image;
import java.io.File;
import java.io.IOException;

public class Images {
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
    //static Image SwitchImage=javax.imageio.ImageIO.read(new File("images/field.png"));
	
	Images()throws IOException
	{
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
	}
	
}
