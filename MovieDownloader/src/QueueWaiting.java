public class QueueWaiting extends Thread {

    private Thread t;
    private String threadName;

    QueueWaiting() {
        threadName = "QueueWaiting";
    }

    public void run() {
        while (true) {
            while (Main._state != null && Main._state instanceof On) {

                while (Main._state == null || Main._state instanceof Off || FileWaiting.queue.isEmpty()) ;

                while (Main._state == null || Main._state instanceof Off || Main._downloadProgress == null || !(Main._downloadProgress instanceof AvailableIdle) || FileWaiting.queue.isEmpty())
                    ;
                Main._state.handleQueuePop();
            }
        }
    }


    public void start() {
        t = new Thread(this, threadName);
        t.start();

    }
}
