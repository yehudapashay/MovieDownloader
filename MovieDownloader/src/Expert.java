public class Expert extends Level {

    public Expert() {
        super();
        this.stateName = "Expert";
        DS = ES;
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
