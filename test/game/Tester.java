package game;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Tester {
	
	final static String success = "A teszt SIKERESEN lefutott!";
<<<<<<< HEAD
	final static String failure = "A teszt HIBÃSAN futott le!";
=======
	final static String failure = "A teszt HIBÁSAN futott le!";
>>>>>>> ca84dfc30a409f04547de1b870c94343fe0416c5
	
	static FileReader fr;
	static BufferedReader reader;
	
	static ArrayList<String> map;
	static ArrayList<String> command;
	static ArrayList<String> output;
	
	public static void printAttribute(ArrayList<String> attribute) {
		for(int i = 0; i<attribute.size(); ++i) {
			System.out.println(attribute.get(i));
		}
	}
	
	public static ArrayList<String> setAttributes(File file) throws IOException {
		fr = new FileReader(file);
		reader = new BufferedReader(fr);
		ArrayList<String> strlist = new ArrayList<String>();
		while(true) {
			String line = reader.readLine();
			if(line != null)
				strlist.add(line);
			else
				break;
		}
		return strlist;
	}
	
	public static void presetTest(int n) throws IOException {
			File mapsrc = new File("test/testinputs/test"+n+"/test"+n+".txt");
			File commandsrc = new File("test/testinputs/test"+n+"/cmd"+n+".txt");
			File outputsrc = new File("test/testinputs/test"+n+"/output"+n+".txt");
			
			if(!mapsrc.exists() || !commandsrc.exists() || !outputsrc.exists())
<<<<<<< HEAD
				System.out.println("Nem sikerÃ¼lt megnyitni egy vagy tÃ¶bb fÃ¡jlt!");
=======
				System.out.println("Nem sikerült megnyitni egy vagy több fájlt!");
>>>>>>> ca84dfc30a409f04547de1b870c94343fe0416c5
			
			map = setAttributes(mapsrc);
			command = setAttributes(commandsrc);
			output = setAttributes(outputsrc);	
	}
	
	public static void main(String args[]) throws IOException {

		//TESZT 1
		//Create the environment
		presetTest(1);
		//Process and execute commands...
		//TODO
		//Save the output to a file
		//TODO
		//Compare saved file to reference file
		//TODO
		
		//TESZT 2
		//Create the environment
		presetTest(2);
		//Process and execute commands...
		//TODO
		//Save the output to a file
		//TODO
		//Compare saved file to reference file
		//TODO
		
		//...
	}
}
