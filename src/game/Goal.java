package game;
//Célmezõt reprezentáló osztály
public class Goal extends Field{

    public Goal(){super();}
    public Goal(Pushable p){
        super(p);
    }
    //Ha dobozt tolunk a célmezõre, aktiváljuk azt.
    public void activate() {
        //System.out.println("--- Goal activate()");
        System.out.println("@@@ A goal aktiválódott!");
    }
}
