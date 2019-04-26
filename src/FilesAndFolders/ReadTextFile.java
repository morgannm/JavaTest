package FilesAndFolders;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;

/**
 * Created by morga on 08/07/2018.
 */
public class ReadTextFile {
    public static void main(String[] args) throws IOException {
        // le fichier est à la racine de JavaTest
        String test = readFile("testFileWriter.txt",Charset.defaultCharset());
        System.out.println(test);

        // autre méthode
        String contents = new String(Files.readAllBytes(Paths.get("testFileWriter.txt")));
        System.out.println(contents);
    }

    static String readFile(String path, Charset encoding)
            throws IOException
    {
        byte[] encoded = Files.readAllBytes(Paths.get(path));
        return new String(encoded, encoding);
    }
}
