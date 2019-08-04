public abstract class State {
    protected String stateName;

    public Connection _connection;
    public FileWaiting _fileWaiting;
    public static volatile UserScore _userScore= null;
    public Download _download;
    protected static volatile View _view;

    public State(){
        this.stateName = "State";

    }

    public abstract void printIn();

    public abstract void printOut();

    public abstract State turnOn();

    public abstract State turnOff();

    public abstract Download get_download();

    public abstract Connection get_connection();

    public abstract DownloadProgress get_downloadProgress();

    public abstract void handleQueuePop();

    public abstract void internetOn();

    public abstract void internetOff();

    public abstract void setStorage(int diskSize);

    public abstract void fileRequest(String name , String size);

    public abstract void downloadAborted();

    public abstract void downloadError();

    public abstract void errorFixed();

    public abstract void movieOn();

    public abstract void movieOff();

    public abstract void restartMovie();

    public abstract void holdMovie();

    public abstract void resume();
}
