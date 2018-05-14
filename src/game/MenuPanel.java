package game;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.GraphicsEnvironment;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class MenuPanel extends JComponent{
	
	public MenuPanel() {

        GameFrame.map = new Map();
        GameFrame.map.CreatedMap("map.txt");
        System.out.println("@@@ A jatek betoltve!");


    	//Betűtípus importálása
    	try {
    		GraphicsEnvironment ge =  GraphicsEnvironment.getLocalGraphicsEnvironment();
    		 ge.registerFont(Font.createFont(Font.TRUETYPE_FONT, new File("World of Water.ttf")));
    		 ge.registerFont(Font.createFont(Font.TRUETYPE_FONT, new File("K26ToyBlocks123.ttf")));
    		} catch (IOException|FontFormatException e) {
    			e.printStackTrace();
    		}
    	
    	
    	//Beállítjuk a menü elrendezését
    	this.setLayout(new BorderLayout());
    	
    	//Létrehozzuk a címet tartalmazó panelt
    	JPanel gametitle = new JPanel(new FlowLayout(FlowLayout.CENTER));
    	gametitle.setBorder(new EmptyBorder(20,50,0,50));
    	
    	//Létrehozunk új betűtípusokat a címhez és a menühöz
    	Font titlefont = new Font("K26ToyBlocks123", Font.PLAIN, 100);
    	Font menufont = new Font("World of Water", Font.BOLD, 50);
    	
    	//HTML kóddal konstruálva (könnyebb) létrehozzuk a címet, beállítjuk a betűtípusát majd a panelhez adjuk
    	JLabel titletext = new JLabel("<html><font color=#FF0000>S</font><html><font color=#23a517>O</font>"
    			+ "<html><font color=#0000FF>K</font><html><font color=#eae604>O</font>"
    			+ "<html><font color=#e5b30d>B</font><html><font color=#FF0000>A</font>"
    			+ "<html><font color=#0000FF>N</font>");
    	titletext.setFont(titlefont); 
    	gametitle.add(titletext);
    	
    	//Létrehozzuk a menüt tartalmazó panelt
    	JPanel menugrid = new JPanel(new GridLayout(0,1,50,50));
    	
    	//Létrehozzuk a menü gombjait, a feliratait megadjuk és a feliratok színét is
    	JButton newgamebutton = new JButton("Új játék kezdése");
    	newgamebutton.setForeground(Color.BLACK);
    	newgamebutton.setBackground(new Color(255, 94, 94));
    	JButton loadbutton = new JButton("Példa térkép betöltése");
    	loadbutton.setForeground(Color.BLACK);
    	loadbutton.setBackground(new Color(107, 118, 229));
    	JButton ownloadbutton = new JButton("Saját térkép betöltése");
    	ownloadbutton.setForeground(Color.BLACK);
    	ownloadbutton.setBackground(new Color(73, 239, 55));
    	JButton exitbutton = new JButton("Kilépés");
    	exitbutton.setForeground(Color.BLACK);
    	exitbutton.setBackground(new Color(173, 97, 249));
    	
    	//Hozzáadjuk a menühöz a gombokat
    	menugrid.add(newgamebutton);
    	menugrid.add(loadbutton);
    	menugrid.add(ownloadbutton);
    	menugrid.add(exitbutton);
    	
    	//minden gombra elvégezünk néhány módosítást
    	for (Component comp : menugrid.getComponents()) {
    	    if (comp instanceof JButton) {
    	        ((JButton)comp).setFont(menufont); //betűtípus
    	        ((JButton)comp).setFocusPainted(false); //a focus nem látszik
    	    }
    	}
    	
    	//Beállítjuk a menü keretét
    	menugrid.setBorder(new EmptyBorder(50,50,50,50));
    	
    	//Beállítjuk a háttérszínt
    	Color bgcolor = new Color(253, 255, 186);
    	menugrid.setBackground(bgcolor);
    	gametitle.setBackground(bgcolor);
    	
    	//Hozzáadjuk a menühöz a menüpontokat (gombok) és a címet
    	this.add(gametitle, BorderLayout.NORTH);
    	this.add(menugrid, BorderLayout.CENTER);
    	
    	
    	//Hozzáadjuk a gombokhoz az eseményfigyelőket
    	
    	
    	//Az Új játék kezdése gomb megnyomásával elkezdődik a játék
    	newgamebutton.addActionListener(new ActionListener() {
    		@Override
    		public void actionPerformed(ActionEvent ae) {
    			System.out.println("@@@ A jatek elkezdodott!");
    			try {
					GameFrame.Game();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
    		}
    	});
    	
    	//A Példa térkép betöltése gomb megnyomásával betöltődik a map.txt
    	loadbutton.addActionListener(new ActionListener() {
    		@Override
    		public void actionPerformed(ActionEvent ae) {
    			GameFrame.map = new Map();
    	        GameFrame.map.CreatedMap("map.txt");
    	        System.out.println("@@@ A jatek betoltve!");
    		}
    	});
    	
    	//A Saját térkép betöltése gomb megnyomásával betöltödik a megadott térkép
    	ownloadbutton.addActionListener(new ActionListener() {
    		@Override
    		public void actionPerformed(ActionEvent ae) {
    			try {
					load();
				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}   			  			
    		}
    	});
    	
    	//A Kilépés gomb megnyomásával bezáródik az ablak
    	exitbutton.addActionListener(new ActionListener() {
    		@Override
    		public void actionPerformed(ActionEvent ae) {
    			setVisible(false); //Hide frame
    			System.exit(0); // Exit program
    			System.out.println("@@@ Kilepes a jatekbol!");
    		}
    	});
    	
    	
    }
	
	public void load() throws IOException, ClassNotFoundException {
		File file = null;
		JFileChooser choose=new JFileChooser();
		int var= choose.showDialog(this,"Betölt");
		if(var== JFileChooser.APPROVE_OPTION) {
			file=choose.getSelectedFile();
		}
		if(file.exists() && file!= null) {
			GameFrame.map = new Map();
	        GameFrame.map.CreatedMap(file.getCanonicalPath());
	        System.out.println("@@@ A jatek betoltve!");
			}
	}
	
	}


