public abstract class DownloadProgress extends Download {

    public static double CS = 0;
    public static double US = 0;
    public static double DP = 0;
    public static int storageSize = 100;
    public static File currentMovie = null;
    public static int percentageTarget = 20;


    public DownloadProgress() {
        super();
        this.stateName = "DownloadProgress";
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
    public Download internetOn() {
        return this;
    }

    @Override
    public Download internetOff() {
        printOut();
        return new DownloadIdle();
    }

    public abstract void setDownloadPercentage();

    public abstract DownloadProgress downloadError();

    public abstract DownloadProgress errorFixed();

    public abstract DownloadProgress downloadFinished();


    public DownloadProgress downloadAborted() {
        printOut();
        handleDownloadFailed();
        return new AvailableIdle();
    }

    public void handleDownloadFailed() {
        currentMovie = null;
        CS = 0;
        State._userScore = State._userScore.handleDowngrade();
        State._view = State._view.downloadAborted();

    }

}
