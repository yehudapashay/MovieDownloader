public abstract class Connection {

    protected String stateName;

    public Connection(){
        this.stateName = "Connection";
    }

    public abstract void printIn();

    public abstract void printOut();

    public abstract Connection internetOn();

    public abstract Connection internetOff();

}
