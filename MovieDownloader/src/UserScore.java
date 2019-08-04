public abstract class UserScore {

    protected String stateName;
    public static volatile int points = 0;

    protected static double BT = 4;
    protected static double AT = 7;

    protected static Level level = new Beginner();

    public UserScore() {
        this.stateName = "UserScore";
    }

    public abstract void printIn();

    public abstract void printOut();

    public abstract UserScore handleUpgrade();

    public abstract UserScore handleDowngrade();

}
