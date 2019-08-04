public class Beginner extends Level {

    public Beginner(){
        super();
        this.stateName = "Beginner";
        DS = BS;
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
