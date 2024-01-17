package FilesAndFolders;

import java.io.File;
import java.nio.file.Paths;

// Tests sur les dossiers
public class Folders {
    public static void main(String[] args) {
        // Construction d'un chemin et test de son existence
        String baseFolderPath = "\\\\8XHV9T3\\EFI_GamSys\\Updates_8.1";
        File baseFolder = new File(baseFolderPath);
        if (baseFolder.exists())
            System.out.println("Le dossier '" + baseFolderPath + "' existe");
        else
            System.out.println("Le dossier '" + baseFolderPath + "' n'existe pas");

        File updateBackendsFolder = Paths.get(baseFolderPath,"backend").toFile();
        if (updateBackendsFolder.exists())
            System.out.println("Le dossier '" + updateBackendsFolder + "' existe");
        else
            System.out.println("Le dossier '" + updateBackendsFolder + "' n'existe pas");

        File updateBackendsFilesFolder = Paths.get(baseFolderPath,"backend","files").toFile();
        if (updateBackendsFilesFolder.exists())
            System.out.println("Le dossier '" + updateBackendsFilesFolder + "' existe");
        else
            System.out.println("Le dossier '" + updateBackendsFilesFolder + "' n'existe pas");

        File badFolder = Paths.get(baseFolderPath,"backend","test").toFile();
        if (badFolder.exists())
            System.out.println("Le dossier '" + badFolder + "' existe");
        else
            System.out.println("Le dossier '" + badFolder + "' n'existe pas");
    }
}
