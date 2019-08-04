public class DownloadIdle extends Download {

    public DownloadIdle() {
        super();
        this.stateName = "DownloadIdle";
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
    public Download internetOn() {
        if(Main._downloadProgress == null){
            Main._downloadProgress = new AvailableIdle();
            printOut();
        }
        else{
            printOut();
            Main._downloadProgress.printIn();
        }
        return Main._downloadProgress;
    }

    @Override
    public Download internetOff() {
        return this;
    }


}
