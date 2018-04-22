package game;

import java.io.File;
import java.io.IOException;
import java.io.PrintStream;

public class SerializeClass {
		
		// A megadott pályán lévõ játékosokat kiírja
		public void printWorkers(Map m, PrintStream ps) {
				int i=1;
				for (Worker w : m.workers) {
					ps.print(i+". ");
					//mezõ
					ps.print(w.score);
					i++;
				}
		}
		
		public void printBoxes(Map m, PrintStream ps) {
	/*		int i=1;
			for (Box b : m.boxes) {
				ps.print(i+". ");
				//mezõ
				ps.print(b.weigth);
				*/
			}
			
			
		public void printFields(Map m, PrintStream ps) {
				int i=1;
				for (Field f : m.fields) {
					ps.print(i+". ");
					f.print(ps);
					ps.print("\n");
					i++;
				}
	}
		
	public void save(Map m, String filename)  {
		File file=new File(filename);
		try {
		if(!file.exists())
			file.createNewFile();
		
			PrintStream ps=new PrintStream(file);
			printWorkers(m,ps);
			printBoxes(m,ps);
			printFields(m,ps);
			
		} catch (IOException e ) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
