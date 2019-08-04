public abstract class View {

    public static float CMT = 0;
    public static long entryTime = 0;

    protected String stateName;

    public View() {
        this.stateName = "View";
    }

    public abstract void printIn();

    public abstract void printOut();

    public abstract View internetOn();

    public abstract View internetOff();

    public abstract View movieOn();

    public abstract View movieOff();

    public abstract View holdMovie();

    public abstract View resume();

    public abstract View downloadError();

    public abstract View errorFixed();

    public abstract View restartMovie();

    public View downloadFinished() {
        printOut();
        return new ViewIdle();
    }

    public View downloadAborted() {
        printOut();
        return new ViewIdle();
    }

    public long getCurrentTime() {
        return System.currentTimeMillis();
    }

}
