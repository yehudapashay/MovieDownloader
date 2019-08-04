public class FullStorage extends DownloadProgress {

    public FullStorage() {
        super();
        this.stateName = "FullStorage";
        printIn();
    }

    @Override
    public void setDownloadPercentage() {}

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

    public boolean checkAvailableSpace(){   // returns true if there is available space
        if (US+CS > storageSize){
            return false;
        }
        return true;
    }
}
