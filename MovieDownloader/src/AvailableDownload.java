public class AvailableDownload extends DownloadProgress {

    public AvailableDownload() {
        super();
        this.stateName = "AvailableDownload";
        printIn();
    }

    @Override
    public void setDownloadPercentage() { }

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

    public boolean checkAvailableSpace(){
        if (US+CS > storageSize){
            return false;
        }
        return true;
    }
}
