package game;

import java.io.PrintStream;


public class Wall extends Pushable {
	//A falat nem tudjuk eltolni, ezért mindig false-al tér vissza.

	public boolean Push(Direction d, int force) {
		return false;
	}


	public void Fall() {
		//System.out.println("--- Wall Push()");
	}


	@Override
	public void setActual(Field field) {

	}


	@Override
	public void printType(PrintStream ps) {
		ps.print("Wall ");
		
	}


}