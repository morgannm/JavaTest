/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FilesAndFolders;

import java.io.*;
import java.util.*;
import java.text.DateFormat;
import static java.text.DateFormat.SHORT;
import static java.text.DateFormat.MEDIUM;

/**
 *
 * @author morgannm
 */
public class WriteTextFile {
    String newline = System.getProperty("line.separator");
    
    public static void main(String[] arguments) {
        try {
            Date now = new Date();
            String datestring = DateFormat.getDateTimeInstance(SHORT, MEDIUM).format(now);
            datestring = datestring.replace(':', '-');
            datestring = datestring.replace('/', '-');
            datestring = datestring.replace(' ', '_');
            File fichier = new File("C:\\Temp\\" + datestring + ".txt");
            FileOutputStream fileStream = new FileOutputStream(fichier);
            String text = "Test2";
            //byte[] data = text.getBytes();
            byte[] data = datestring.getBytes();
            fileStream.write(data, 0, data.length);
            fileStream.close();
        } catch (IOException ioe) {
            System.out.println("Could not write file");
        }        
    }

}
