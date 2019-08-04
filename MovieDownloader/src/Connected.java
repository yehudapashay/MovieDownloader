public class Connected extends Connection{

    public Connected(){
        super();
        this.stateName = "Connected";
        printIn();
    }

    @Override
    public void printIn() {
        System.out.println("enter " + this.stateName + " state");
    }

    @Override
    public void printOut() {
        System.out.println("exit " + this.stateName + " state");
    }

    @Override
    public Connection internetOn() {
        return this;
    }

    @Override
    public Connection internetOff() {
        printOut();
        return new NotConnected();
    }
}
