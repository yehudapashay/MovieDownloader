public abstract class Level {

    protected String stateName;

    protected static double BS = 1;
    protected static double AS = 1.2;
    protected static double ES = 1.5;

    protected static double DS = BS;

    public Level() {
        this.stateName = "Level";
    }

    public String getStateName(){
        return this.stateName;
    }

    public abstract void printIn();

    public abstract void printOut();

}
