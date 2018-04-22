package game;
//Falat reprezent�l� oszt�ly, nem lehet eltolni.
public class Wall extends Pushable {
	//A falat nem tudjuk eltolni, ez�rt mindig false-al t�r vissza.
	public boolean Push(Direction d) {
		//System.out.println("--- Wall Push()");
		System.out.println("@@@ A falakat nem lehet eltolni!");
		return false;
	}
	//A fal leesik. Ilyen alapesetben nem t�rt�nik meg.
	public void Fall() {
		//System.out.println("--- Wall Push()");
	}

	@Override
	public void setActual(Field field) {

	}
}
