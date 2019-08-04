public class NotConnected extends Connection {

    public NotConnected(){
        super();
        this.stateName = "NotConnected";
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
        printOut();
        return new Connected();
    }

    @Override
    public Connection internetOff() {
        return this;
    }
}
