package game;
//Falat reprezent�l� oszt�ly, nem lehet eltolni.
public class Wall extends Pushable {
	//A falat nem tudjuk eltolni, ez�rt mindig false-al t�r vissza.
	public boolean Push(Direction d) {
		return false;
	}
	//A fal leesik. Ilyen alapesetben nem t�rt�nik meg.
	public void Fall() {
	}
}
