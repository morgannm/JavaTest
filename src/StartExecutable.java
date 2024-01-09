import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

public class StartExecutable {
    public static void main(String[] args) {
        System.out.println("Lancement d'un exécutable");

        try {
            Runtime.getRuntime().exec("c:\\windows\\notepad.exe");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        // Pour les services, le module Java doit être lancé en administrateur
        try {
            Runtime runtime = Runtime.getRuntime();
            String executablePath = "C:\\EFI_GamSys\\Backend_8.1\\gamsys-backend-client-8.1-5960\\Service - START.bat";
            Process process = runtime.exec(executablePath);
            process.waitFor();
            InputStream in = process.getInputStream();
            ByteArrayOutputStream baos = new ByteArrayOutputStream();

            int c = -1;
            while((c = in.read()) != -1){
                baos.write(c);
            }

            String response = new String(baos.toByteArray());
            System.out.println("Response From Exe : "+response);
        } catch (IOException | InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
