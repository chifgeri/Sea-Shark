package game;

import java.io.PrintStream;

/**
 * Falat reprezentáló osztály.
 */
public class Wall extends Pushable {

	/**
	 * A falat nem tudjuk eltolni, ezért mindig false-al tér vissza.
	 */
	public boolean Push(Direction d, int force) {
		return false;
	}

	/**
	 * A fal nem is tud leesni
	 */
	public void Fall() {
	}


	@Override
	public void setActual(Field field) {
	}


	@Override
	public void printType(PrintStream ps) {
		ps.print("Wall ");
		
	}


}