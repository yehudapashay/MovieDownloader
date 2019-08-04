Java state machine implementation

Events:
o turnOn – start running of the machine
o turnoff – end running of the machine
o internetOn – turn on the internet connection
o internetOff – turn off the internet connection
o downloadAborted – the download is aborted
o downloadError – there is any error in the download
o errorFixed – the error in the download has been fixed
o movieOn – start watching the movie
o restartMovie – restart the movie
o holdMovie – pause the movie’s watch
o movieOff – end watching the movie
o fileRequest  <file name>  <file size> - adding new file request 
example: fileRequest Titanic 15
o setStorage  <new storage size> - set the size of the disk storage
example: setStorage  150

 Optional:
 exit  - exit the jar file

Notes:
1.exit is used for exit from the program.
2.In file request event you have to insert the file name (without spaces) and the file size.
For example: fileRequest  firstFile 12.
3.For set the storage size of the disk you have to insert the new disk size.
For example : setStorage 250.

Variables (with initial value):
o BS (Beginner Speed) = 1   
o AS (Advanced Speed) = 1.2
o ES (Expert Speed) = 1.5
o BT (Beginner Threshold) = 4  
o AT (Advanced Threshold) = 7
o Queue (queue of files) = empty
o US(used size by downloaded movies) = 0
o CS(current movie's size) = 0
o currentMovie ( current movie in download)  = null
o DP (percentage of download of a current movie) = 0
o storageSize = 100
o points ( score points of the user) = 1
o DS (download speed) = 1
o CMT (current movie time) = 0
o entryTime = 0
o percentageTarget (the minimum value for viewing the movie while downloading) = 20%




States:
o Off – the Movie Downloader machine is off
o On - the Movie Downloader machine is on
o Not Connected – the Internet is off
o Connected – the Internet is on
o WaitingIdle – can not wait for file while Internet is disconnected
o WaitingFile – waiting for file while Internet is connected
o Beginner – first level of user’s status
o Advanced – second level of user’s status
o Expert – third level of user’s status
o Score – holds the points of user’s score
o DownloadIdle – waiting for internet connection
o AvailableIdle – waiting for available file in the system
o AvailableDownload – there is any file in the queue
o FullStorage – there is no space in the disk’s storage
o DownloadFileProcess – downloading a file in the system
o FixingError – an error happened while downloading 
o ViewIdle – waiting state for watching a movie
o MovieViewingOption – the user can turn on the movie
o WatchingMovie – the user is watching the movie
o MoviePaused – the user paused the movie’s watching
o MovieWaiting – the internet is off while watching the movie
o MovieError – an error happened while watching the movie








