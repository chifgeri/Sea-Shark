package game;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Scanner;

public class Tester {
	
	final static String success = "A teszt SIKERESEN lefutott!";
	final static String failure = "A teszt HIBÁSAN futott le!";
	
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
				System.out.println("Nem sikerült megnyitni egy vagy több fájlt!");
			
			map = setAttributes(mapsrc);
			command = setAttributes(commandsrc);
			output = setAttributes(outputsrc);	
	}
	
	public static void main(String args[]) throws IOException, InterruptedException {

		//TESZT 1
		//Create the environment
		presetTest(1);
		//Process and execute commands...
		//String[] array = command.toArray(new String[0]);
		
		
		//Thread mainThread = Thread.currentThread();
		
		
		
		//String data = "Exit";
		//InputStream testInput = new ByteArrayInputStream( data.getBytes("UTF-8") );
		InputStream testInput = new FileInputStream(new File("test/testinputs/test1/cmd1.txt"));
		InputStream old = System.in;
		
		try {
			
		    System.setIn( testInput );
		   Main.main(args);

		} finally {
		    System.setIn( old );
		}
		//Scanner scanner = new Scanner(System.in);
		//scanner.
		
		//ByteArrayInputStream stream = new ByteArrayInputStream("Start".getBytes(StandardCharsets.UTF_8));
		//System.in.
		//Save the output to a file
		//TODO
		//Compare saved file to reference file
		//TODO
		

	}
}
