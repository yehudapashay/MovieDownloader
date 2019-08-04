public class Off extends  State {

    public Off() {
        super();
        this.stateName = "Off";
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
    public State turnOn() {
        printOut();
        return new On();
    }

    @Override
    public State turnOff() {
        return this;
    }

    @Override
    public Download get_download() {
        return null;
    }

    @Override
    public Connection get_connection() {
        return null;
    }

    @Override
    public DownloadProgress get_downloadProgress() {
        return null;
    }

    @Override
    public void handleQueuePop() {}

    @Override
    public void internetOn() {}

    @Override
    public void internetOff() {

    }

    @Override
    public void setStorage(int diskSize) {}

    @Override
    public void fileRequest(String name, String size) {}

    @Override
    public void downloadAborted() {}

    @Override
    public void downloadError() {}

    @Override
    public void errorFixed() {}

    @Override
    public void movieOn() {

    }

    @Override
    public void movieOff() {

    }

    @Override
    public void restartMovie() {

    }

    @Override
    public void holdMovie() {

    }

    @Override
    public void resume() {

    }
}
