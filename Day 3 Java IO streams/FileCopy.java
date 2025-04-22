import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.File;
import java.io.IOException;

public class FileCopy {

    public static void main(String[] args) {
        String sourcePath = "source.txt";
        String destPath = "destination.txt";

        FileInputStream fis = null;
        FileOutputStream fos = null;

        try {
            File sourceFile = new File(sourcePath);
            File destFile = new File(destPath);

            if (!sourceFile.exists()) {
                System.out.println("Source file does not exist: " + sourcePath);
                return;
            }

            // Create destination file if it does not exist
            if (!destFile.exists()) {
                destFile.createNewFile();
            }

            fis = new FileInputStream(sourceFile);
            fos = new FileOutputStream(destFile);

            byte[] buffer = new byte[1024];
            int bytesRead;

            while ((bytesRead = fis.read(buffer)) != -1) {
                fos.write(buffer, 0, bytesRead);
            }

            System.out.println("File copied successfully from " + sourcePath + " to " + destPath);

        } catch (IOException e) {
            System.out.println("An error occurred during file operation: " + e.getMessage());
        } finally {
            try {
                if (fis != null) fis.close();
                if (fos != null) fos.close();
            } catch (IOException e) {
                System.out.println("Failed to close streams: " + e.getMessage());
            }
        }
    }
}
