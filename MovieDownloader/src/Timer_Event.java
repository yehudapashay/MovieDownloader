public class Timer_Event extends Thread {

    public Thread t;
    private String threadName;
    public volatile boolean isDownloadAborted = false;
    public volatile boolean isDownloadError = false;
    public volatile boolean isErrorFixed = false;

    Timer_Event(String name) {
        threadName = name;
    }

    public void run() {
        if (threadName.equals("TM_3_SEC")) {
            TM_3_SEC();
        } else if (threadName.equals("TM_4_SEC")) {
            TM_4_SEC();
        } else {
            TM_Download();
        }
    }

    public void TM_3_SEC() {
        while(!(Main._state instanceof  On));
        DownloadProgress currentDownloadProgress = Main._state.get_downloadProgress();
        if (currentDownloadProgress != null && currentDownloadProgress instanceof FixingError) {
            try {
                int i = 0;
                while (i < 3) {
                    Thread.sleep(1000);
                    if (isDownloadAborted) {
                        Main._downloadProgress = Main._downloadProgress.downloadAborted();
                        isDownloadAborted = false;
                        return;
                    }
                    if (isErrorFixed) {
                        Main._downloadProgress = Main._downloadProgress.errorFixed();
                        Main.TM_download.start();
                        isErrorFixed = false;
                        return;
                    }
                    i++;
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            currentDownloadProgress = Main._state.get_downloadProgress();
            if (currentDownloadProgress != null && currentDownloadProgress instanceof FixingError) {
                Main._downloadProgress.printOut();
                Main._downloadProgress.handleDownloadFailed();
                Main._downloadProgress = new AvailableIdle();
            }
        }
    }

    public void TM_4_SEC() {  // for 'Full Storage' state
        Connection _currentConnection = Main._state.get_connection();
        DownloadProgress currentDownloadProgress = Main._state.get_downloadProgress();
        if (currentDownloadProgress != null && currentDownloadProgress instanceof AvailableDownload) {
            while (!(_currentConnection instanceof Connected) || !(Main._state instanceof  On)) {
                _currentConnection = Main._state.get_connection();
            }
            if (((AvailableDownload) currentDownloadProgress).checkAvailableSpace()) {
                currentDownloadProgress.printOut();
                Main._downloadProgress = new DownloadFileProcess();
                Main.TM_download.start();
            } else {
                currentDownloadProgress.printOut();
                Main._downloadProgress = new FullStorage();
                try {
                    int i = 0;
                    while (i < 4) {
                        Thread.sleep(1000);
                        if (isDownloadAborted) {
                            Main._downloadProgress = Main._downloadProgress.downloadAborted();
                            isDownloadAborted = false;
                            return;
                        }
                        i++;
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                currentDownloadProgress = Main._state.get_downloadProgress();
                _currentConnection = Main._state.get_connection();
                while (!(_currentConnection instanceof Connected)) {
                    _currentConnection = Main._state.get_connection();
                }
                if (currentDownloadProgress != null && currentDownloadProgress instanceof FullStorage) {
                    if (((FullStorage) currentDownloadProgress).checkAvailableSpace()) {
                        currentDownloadProgress.printOut();
                        Main._downloadProgress = new DownloadFileProcess();
                        Main.TM_download.start();
                    } else {
                        currentDownloadProgress.printOut();
                        Main._downloadProgress.handleDownloadFailed();
                        Main._downloadProgress = new AvailableIdle();
                    }

                }
            }
        }
    }

    public void TM_Download() {
        Connection _currentConnection;
        boolean isDownloadFinished = false;
        while (!isDownloadError && !isDownloadFinished) {
            try {
                Thread.sleep(1000);
                _currentConnection = Main._state.get_connection();
                while (!(_currentConnection instanceof Connected) || !(Main._state instanceof On)) {
                    _currentConnection = Main._state.get_connection();
                }
                if (isDownloadAborted) {
                    Main._downloadProgress = Main._downloadProgress.downloadAborted();
                    isDownloadAborted = false;
                    return;
                }
                if (Main._downloadProgress instanceof DownloadFileProcess) {
                    Main._downloadProgress.setDownloadPercentage();
                    if (DownloadProgress.DP >= 100) {
                        isDownloadFinished = true;
                    }
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        if (isDownloadError) {
            Main._downloadProgress = Main._downloadProgress.downloadError();
            Main.TM_3.start();
            isDownloadError = false;
        } else if (isDownloadFinished) {
            Main._downloadProgress = Main._downloadProgress.downloadFinished();
        }
    }

    public void start() {
        t = new Thread(this, threadName);
        t.start();

    }

}
