import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

public abstract class FileWaiting {

    protected String stateName;
    public static ConcurrentLinkedQueue<File> queue = new ConcurrentLinkedQueue<File>();


    public FileWaiting(){
        this.stateName = "FileWaiting";
    }

    public abstract void printIn();

    public abstract void printOut();

    public abstract FileWaiting internetOn();

    public abstract FileWaiting internetOff();

    public abstract FileWaiting fileRequest(String name, double size);
}


