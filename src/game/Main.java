package game;

import java.io.IOException;

public class Main {
	
	public static GameFrame mainwindow;

	public static void main(String[] args) throws IOException {
	System.setProperty("awt.useSystemAAFontSettings","on");
	System.setProperty("swing.aatext", "true");
	mainwindow = new GameFrame();
	mainwindow.MainMenu();
}


}
