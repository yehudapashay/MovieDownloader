import java.util.Scanner;

public class Main {
    public static volatile State _state;
    public static volatile Timer_Event TM_3 = null;
    public static volatile Timer_Event TM_4 = null;
    public static volatile Timer_Event TM_download = null;
    public static volatile DownloadProgress _downloadProgress = null;

    public static void main(String[] args) {
        TM_3 = new Timer_Event("TM_3_SEC");
        TM_4 = new Timer_Event("TM_4_SEC");
        TM_download = new Timer_Event("TM_download");
        _state = new Off();
        QueueWaiting q = new QueueWaiting();
        q.start();
        handleEvents();
    }


    public static void handleEvents() {
        try {
            Scanner _scanner = new Scanner(System.in);
            String _str = "";
            while (true) {
                _str = _scanner.nextLine();
                String[] inputs = _str.split(" ");
                if(inputs[0].equals("exit")){
                    System.exit(0);
                }
                else if (inputs[0].equals("turnOn")) {
                    _state = _state.turnOn();
                } else if (inputs[0].equals("turnOff")) {
                    _state = _state.turnOff();
                } else {
                    if (_state instanceof On) {
                        if (inputs[0].equals("internetOn")) {
                            _state.internetOn();
                        } else if (inputs[0].equals("internetOff")) {
                            _state.internetOff();
                        } else if (inputs[0].equals("fileRequest")) {
                            if (inputs.length == 2) {
                                _state.fileRequest(inputs[1], "1");
                            } else if (inputs.length == 3) {
                                _state.fileRequest(inputs[1], inputs[2]);
                            } else {
                                _state.fileRequest("newMovie", "1");
                            }
                        } else if (inputs[0].equals("downloadAborted")) {
                            _state.downloadAborted();
                        } else if (inputs[0].equals("downloadError")) {
                            _state.downloadError();
                        } else if (inputs[0].equals("errorFixed")) {
                            _state.errorFixed();
                        } else if (inputs[0].equals("movieOn")) {
                            _state.movieOn();
                        } else if (inputs[0].equals("restartMovie")) {
                            _state.restartMovie();
                        } else if (inputs[0].equals("holdMovie")) {
                            _state.holdMovie();
                        } else if (inputs[0].equals("movieOff")) {
                            _state.movieOff();
                        } else if (inputs[0].equals("resume")) {
                            _state.resume();
                        } else if (inputs[0].equals("setStorage")) {
                            if (inputs.length == 2) {
                                try{
                                    _state.setStorage(Integer.parseInt(inputs[1]));
                                }catch(Exception e){
                                    _state.setStorage(100);
                                }
                            }
                            else{
                                _state.setStorage(100);
                            }
                        } else {
                            System.out.println("Invalid Command");
                        }
                    }
                }


            }
        } catch (Exception e) { }
    }


}

