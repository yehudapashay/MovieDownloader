public class Advanced extends Level {

    public Advanced() {
        super();
        this.stateName = "Advanced";
        DS = AS;
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
}
