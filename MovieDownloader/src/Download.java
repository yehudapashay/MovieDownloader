public abstract class Download {

    protected String stateName;

    public Download() {
        this.stateName = "Download";
    }

    public abstract void printIn();

    public abstract void printOut();

    public abstract Download internetOn();

    public abstract Download internetOff();

}
