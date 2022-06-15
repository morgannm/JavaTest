package FilesAndFolders;

import java.io.*;
import java.util.Base64;

public class BinaryFileReadWriteBase64 {
    public static void main(String[] args) {
        try {
            // Lit un fichier PDF, l'encode en Base64, le décode et l'écrit dans un nouveau fichier

            // Suppression du fichier de destination si déjà existant
            File pdfFileOutput = new File("d:/temp/job.pdf");
            if (pdfFileOutput.exists()) {
                pdfFileOutput.delete();
            }

            // lecture du fichier d'origine
            byte[] pdfByte = new byte[(int)new File("d:/temp/P161703_00.pdf").length()];
            InputStream is2 = new FileInputStream("d:/temp/P161703_00.pdf");
            is2.read(pdfByte);
            is2.close();

            // encodage
            String pdfContents = "";
            pdfContents = Base64.getEncoder().encodeToString(pdfByte);
            System.out.println(pdfContents);

            // décodage
            byte[] decoded = Base64.getDecoder().decode(pdfContents);

            // écriture d'un nouveau fichier
            OutputStream os2 = new FileOutputStream("d:/temp/job.pdf");
            os2.write(decoded);
            os2.close();

        } catch (IOException e) {
            System.out.print("Exception");
        }

    }
}
