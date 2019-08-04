import javax.xml.bind.SchemaOutputResolver;

public class DownloadFileProcess extends DownloadProgress {

    public DownloadFileProcess() {
        super();
        this.stateName = "DownloadFileProcess";
        printIn();
    }

    @Override
    public void setDownloadPercentage() {
        DP += (Level.DS / CS) * 100;
        //System.out.println(" ----- downloaded  " + DP + "%");
        if (State._view instanceof ViewIdle && DP > percentageTarget && Main._downloadProgress instanceof DownloadFileProcess) {
            State._view.printOut();
            State._view = new MovieViewingOption();
        }
    }

    @Override
    public DownloadProgress downloadError() {
        printOut();
        State._view = State._view.downloadError();
        return new FixingError();
    }

    @Override
    public DownloadProgress errorFixed() {
        return this;
    }

    @Override
    public DownloadProgress downloadFinished() {
        printOut();
        US += CS;
        State._userScore = State._userScore.handleUpgrade();
        State._view = State._view.downloadFinished();
        return new AvailableIdle();
    }


}
