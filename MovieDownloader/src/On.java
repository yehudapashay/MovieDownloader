public class On extends State {

    public On() {
        super();
        this.stateName = "On";
        printIn();
        _connection = new NotConnected();
        _fileWaiting = new WaitingIdle();
        _download = new DownloadIdle();
        _view = new ViewIdle();
        if (_userScore == null) {
            _userScore = new Score();
        }
        else{
            _userScore.printIn();
            _userScore.level.printIn();
        }


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
        return this;
    }

    @Override
    public State turnOff() {
        printOut();
        return new Off();
    }

    public Download get_download() {
        return _download;
    }

    public Connection get_connection() {
        return _connection;
    }

    public DownloadProgress get_downloadProgress() {
        return Main._downloadProgress;
    }

    public void handleQueuePop() {
        Main._downloadProgress.printOut();
        DownloadProgress.currentMovie = FileWaiting.queue.poll();
        DownloadProgress.CS = DownloadProgress.currentMovie.getSize();
        Main._downloadProgress = new AvailableDownload();
        Main.TM_4.start();
    }


    public void internetOn() {
        //------ Connection region ------//
        _connection = _connection.internetOn();
        //------ End Connection region ------//


        //------ File Waiting region ------//
        _fileWaiting = _fileWaiting.internetOn();
        //------ End File Waiting  region ------//


        //------ Download region ------//
        if (_download != null) {
            _download.printOut();
            _download = null;
        }
        if (Main._downloadProgress == null) {
            Main._downloadProgress = new AvailableIdle();
        } else {
            Main._downloadProgress.printIn();
        }
        //------ End Download region ------//

        _view = _view.internetOn();


    }

    public void internetOff() {
        try {
            _connection = _connection.internetOff();
            _fileWaiting = _fileWaiting.internetOff();
            if (_download == null) {
                _download = Main._downloadProgress.internetOff();
            }
            _view = _view.internetOff();
        } catch (Exception e) {
        }
    }

    public void setStorage(int diskSize) {
        DownloadProgress.storageSize = diskSize < 0 ? 0 : diskSize;
        System.out.println("Storage changed to " + DownloadProgress.storageSize);
    }


    public void fileRequest(String name, String size) {
        double _size = 1;
        try {
            _size = Double.parseDouble(size);
        } catch (Exception e) {
            _size = 1;
        }
        _fileWaiting = _fileWaiting.fileRequest(name, _size);
    }

    public void downloadAborted() {
        //------ Download region ------//
        try {
            if (Main.TM_4 != null && Main.TM_4.t != null && Main.TM_4.t.isAlive()) {
                Main.TM_4.isDownloadAborted = true;
                return;
            }
            if (Main.TM_3 != null && Main.TM_3.t != null && Main.TM_3.t.isAlive()) {
                Main.TM_3.isDownloadAborted = true;
                return;
            }
            Main._downloadProgress = Main._downloadProgress.downloadAborted();
        } catch (Exception e) {
        }
        //------ End Download region ------//
    }


    public void downloadError() {
        try {
            if (Main.TM_download != null && Main.TM_download.t != null && Main.TM_download.t.isAlive()) {
                Main.TM_download.isDownloadError = true;
            }
        } catch (Exception e) {
        }
    }

    public void errorFixed() {
        try {
            if (Main.TM_3 != null && Main.TM_3.t != null && Main.TM_3.t.isAlive()) {
                Main.TM_3.isErrorFixed = true;
            }
        } catch (Exception e) {
        }
    }

    @Override
    public void movieOn() {
        State._view = State._view.movieOn();
    }

    @Override
    public void movieOff() {
        State._view = State._view.movieOff();
    }

    @Override
    public void restartMovie() {
        State._view = State._view.restartMovie();
    }

    @Override
    public void holdMovie() {
        State._view = State._view.holdMovie();
    }

    @Override
    public void resume() {
        State._view = State._view.resume();
    }


}
