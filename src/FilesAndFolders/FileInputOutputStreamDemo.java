package FilesAndFolders;

import java.io.*;

/**
 * Created by morgannm on 19/07/2018.
 */
public class FileInputOutputStreamDemo {
    public static void main(String[] args) {
        try {
            byte bWrite [] = {11,21,3,40,5};
            OutputStream os = new FileOutputStream("test.txt");
            for(int x = 0; x < bWrite.length ; x++) {
                os.write( bWrite[x] );   // writes the bytes
            }
            os.close();

            InputStream is = new FileInputStream("test.txt");
            int size = is.available();

            for(int i = 0; i < size; i++) {
                System.out.print((char)is.read() + "  ");
            }
            is.close();

            // Lit le contenu d'un fichier image et l'écrit dans un nouveau fichier
            byte[] image = new byte[(int)new File("efi_gsoft.png").length()];
            InputStream is2 = new FileInputStream("efi_gsoft.png");
            is2.read(image);
            OutputStream os2 = new FileOutputStream("ef_gsoft2.png");
            os2.write(image);
            is2.close();

        } catch (IOException e) {
            System.out.print("Exception");
        }
    }
}
