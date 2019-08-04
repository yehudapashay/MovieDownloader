public class WaitingIdle extends FileWaiting {

    public WaitingIdle() {
        super();
        this.stateName = "WaitingIdle";
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
    public FileWaiting internetOn() {
        printOut();
        return new WaitingFile();
    }

    @Override
    public FileWaiting internetOff() {
        return this;
    }

    @Override
    public FileWaiting fileRequest(String name, double size) {
        return this;
    }
}
