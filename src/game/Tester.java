package game;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class Tester {
    static InputStream testInput;
    static InputStream standardInput = System.in;

    static File map_source;
    static File command_source;
    static File output_source;
    static File reference_output_source;

    public static boolean message = true;
    public static boolean trackend = false;

    static int testNumber;

    public static void printmsg(int testNumber, boolean success) {
        if(success)
            System.out.println("@@@ A teszt "+testNumber+" SIKERESEN lefutott!");
        else
            System.out.println("@@@ A teszt "+testNumber+" HIBÁSAN futott le!");
    }

    public static boolean compareTextFiles(File f1, File f2) throws IOException {
        BufferedReader reader1 = new BufferedReader(new FileReader(f1));
        BufferedReader reader2 = new BufferedReader(new FileReader(f2));
        String line1 = reader1.readLine();
        String line2 = reader2.readLine();
        boolean areEqual = true;
        int lineNum = 1;

        while (line1 != null || line2 != null)
        {
            if(line1 == null || line2 == null)
            {
                areEqual = false;
                break;
            }
            else if(! line1.equals(line2))
            {
                areEqual = false;
                break;
            }

            line1 = reader1.readLine();
            line2 = reader2.readLine();
            lineNum++;
        }

        if(areEqual)
        {
            System.out.println("@@@ A két fájl megegyezik!");
        }
        else
        {
            System.out.println("@@@ A két fájl mást tartalmaz. "
                    + "Különböznek a  "+lineNum+". sorban!");
            System.out.println("@@@ A helyes megoldásban ez van: \""+line1+"\"");
            System.out.println("@@@ A kimenet pedig ez: \""+line2+"\"");
        }
        reader1.close();
        reader2.close();
        return areEqual;
    }

    public static void presetTest(int n) throws IOException {
        map_source = new File("testcases/test"+n+"/test"+n+".txt");
        command_source = new File("testcases/test"+n+"/cmd"+n+".txt");
        reference_output_source = new File("testcases/test"+n+"/output"+n+".txt");
        output_source = new File("testcases/test"+n+"/save"+n+".txt");

        if(!map_source.exists() || !command_source.exists() || !reference_output_source.exists())
            System.out.println("Nem sikerült megnyitni egy vagy több fájlt!");

        testInput = new FileInputStream(command_source);
    }

    public static void Test(int n) throws IOException {
        try {
            testNumber = n;
            presetTest(testNumber);
            System.setIn(testInput);
            if(18 >= testNumber && testNumber >= 15)
                trackend = true;
            Main.main(new String[0]);
        } finally {
            System.setIn(standardInput);

        }

        if(compareTextFiles(reference_output_source,output_source))
            printmsg(testNumber,true);
        else
            printmsg(testNumber,false);
        
    }

    public static void main(String args[]) throws IOException, InterruptedException {

        message = false;
        //Tudjuk, hogy a teszt 16 nem sikeres, a grafikus beadásra javítjuk!
        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader reader = new BufferedReader(isr);
        System.out.println("ÜDV a tesztelő programban! Kérlek add meg melyik tesztet akarod futtatni!");
        System.out.println("Csak egy számot írj be 1-19 között!");
        System.out.println("(Tudunk a 16 teszt problémájáról!)");
        Test(Integer.parseInt(reader.readLine()));
    }
}

