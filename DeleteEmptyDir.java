import java.io.*; 
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*; 
import java.net.*; 
import java.time.*;
import java.text.*;
import java.sql.*;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.Path;
import java.time.format.DateTimeFormatter;  
import java.time.LocalDateTime;  
import java.time.Instant;
import java.util.Date;
import java.util.Timer;
import java.nio.file.FileStore;
import java.util.zip.GZIPInputStream;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DeleteEmptyDir {
private static  String FOLDER_LOCATION = "";
private static boolean isFinished = false;

public static void main(String[] args) {



     if(args.length == 0)
    {
        System.out.println("Proper Usage is: java ListFiles <PATH>");
        System.exit(0);
    }


		FOLDER_LOCATION = 	args[0].replaceAll("\"", "\\\\\"");



    do {
        isFinished = true;
        replaceText(FOLDER_LOCATION);
    } while (!isFinished);
}

private static void replaceText(String fileLocation) {
    File folder = new File(fileLocation);
    File[] listofFiles = folder.listFiles();
	
	
	 if(folder.getAbsolutePath().contains("$RECYCLE.BIN") || folder.getAbsolutePath().contains("System Volume Information"))
	 {
		 	 System.out.println("Recycle bin or System Vol Files , skipping");
	 }
	 else
	 {
	
    if (listofFiles.length == 0) {
        System.out.println("Folder Name :: " + folder.getAbsolutePath() + " is deleted.");
        folder.delete();
        isFinished = false;
    } else {
        for (int j = 0; j < listofFiles.length; j++) {
            File file = listofFiles[j];
            if (file.isDirectory()) {
                replaceText(file.getAbsolutePath());
            }
        }
    }
	 }
}
}
