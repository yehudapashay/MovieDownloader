public class AvailableIdle extends DownloadProgress {

    public AvailableIdle() {
        super();
        this.stateName = "AvailableIdle";
        DP = 0;
        printIn();
    }

    @Override
    public void setDownloadPercentage() {}

    @Override
    public DownloadProgress downloadAborted() {
        printOut();
        return new AvailableIdle();
    }

    @Override
    public DownloadProgress downloadError() {
        return this;
    }

    @Override
    public DownloadProgress errorFixed() {
        return this;
    }

    @Override
    public DownloadProgress downloadFinished() {
        return this;
    }

}
