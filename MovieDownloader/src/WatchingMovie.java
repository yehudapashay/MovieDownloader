public class WatchingMovie extends View {

    public WatchingMovie() {
        super();
        this.stateName = "WatchingMovie";
        entryTime = getCurrentTime();
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
    public View internetOn() {
        return this;
    }

    @Override
    public View internetOff() {
        printOut();
        return new MovieWaiting();
    }

    @Override
    public View movieOn() {
        return this;
    }

    @Override
    public View movieOff() {
        printOut();
        CMT = 0;
        return new MovieViewingOption();
    }

    @Override
    public View holdMovie() {
        printOut();
        CMT += (getCurrentTime() - entryTime) /1000F;
        return new MoviePaused();
    }

    @Override
    public View resume() {
        return this;
    }

    @Override
    public View downloadError() {
        printOut();
        CMT += (getCurrentTime() - entryTime) /1000F;
        return new MovieError();
    }

    @Override
    public View errorFixed() {
        return this;
    }

    @Override
    public View restartMovie() {
        printOut();
        CMT = 0;
        return new WatchingMovie();
    }


}
