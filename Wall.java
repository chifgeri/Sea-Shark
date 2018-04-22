package game;
//Falat reprezentáló osztály, nem lehet eltolni.
public class Wall extends Pushable {
	//A falat nem tudjuk eltolni, ezért mindig false-al tér vissza.
	public boolean Push(Direction d) {
		return false;
	}
	//A fal leesik. Ilyen alapesetben nem történik meg.
	public void Fall() {
	}
}
