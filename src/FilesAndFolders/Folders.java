package FilesAndFolders;

import java.io.File;
import java.nio.file.Path;
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

        // Test d'un chemin absolu ou relatif
        System.out.println("==================================================================");
        System.out.println("Test d'un chemin absolu ou relatif avec java.io.File");
        String relativePath = "\\ExportXml\\";
        File testPath = new File(relativePath);
        if (testPath.isAbsolute()) {
            System.out.println(relativePath + " est un chemin absolu");
        } else {
            System.out.println(relativePath + " est un chemin relatif");
        }
        String dossierPartage = "\\\\Belrdevelapp01n\\tests\\DonneesPartagees\\";
        testPath = new File(dossierPartage);
        if (testPath.isAbsolute()) {
            System.out.println(dossierPartage + " est un chemin absolu");
        } else {
            System.out.println(dossierPartage + " est un chemin relatif");
        }
        testPath = new File(dossierPartage,relativePath);
        if (testPath.isAbsolute()) {
            System.out.println(testPath.getPath() + " est un chemin absolu");
        } else {
            System.out.println(testPath.getPath() + " est un chemin relatif");
        }

        System.out.println("==================================================================");
        System.out.println("Test d'un chemin absolu ou relatif avec java.nio.Path");
        Path path = Paths.get(relativePath);
        if (path.isAbsolute())
            System.out.println(relativePath + " est un chemin absolu");
        else
            System.out.println(relativePath + " est un chemin relatif");
        path = Paths.get(dossierPartage);
        if (path.isAbsolute()) {
            System.out.println(dossierPartage + " est un chemin absolu");
        } else {
            System.out.println(dossierPartage + " est un chemin relatif");
        }
        path = Paths.get(dossierPartage,relativePath);
        if (path.isAbsolute()) {
            System.out.println(path + " est un chemin absolu");
        } else {
            System.out.println(path + " est un chemin relatif");
        }
    }
}
