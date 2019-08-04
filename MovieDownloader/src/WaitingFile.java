public class WaitingFile extends FileWaiting {

    public WaitingFile(){
        super();
        this.stateName = "WaitingFile";
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
        return this;
    }

    @Override
    public FileWaiting internetOff() {
        printOut();
        return new WaitingIdle();
    }

    @Override
    public FileWaiting fileRequest(String name, double size) {
        FileWaiting.queue.add(new File(name, size));
        printOut();
        return new WaitingFile();
    }
}
