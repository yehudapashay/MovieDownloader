public class FixingError extends DownloadProgress {

    public FixingError() {
        super();
        this.stateName = "FixingError";
        printIn();
    }

    @Override
    public void setDownloadPercentage() {

    }

    @Override
    public DownloadProgress downloadError() {
        return this;
    }

    @Override
    public DownloadProgress errorFixed() {
        printOut();
        State._view = State._view.errorFixed();
        return new DownloadFileProcess();
    }

    @Override
    public DownloadProgress downloadFinished() {
        return this;
    }
}
