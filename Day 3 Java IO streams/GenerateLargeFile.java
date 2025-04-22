import java.io.FileOutputStream;
import java.io.IOException;

public class GenerateLargeFile {
    public static void main(String[] args) {
        String filename = "largefile.dat";
        int sizeInMB = 100;
        byte[] buffer = new byte[1024 * 1024]; // 1 MB buffer

        try (FileOutputStream fos = new FileOutputStream(filename)) {
            for (int i = 0; i < sizeInMB; i++) {
                fos.write(buffer); // writes 1 MB of zero bytes
            }
            System.out.println("Generated " + sizeInMB + "MB file: " + filename);
        } catch (IOException e) {
            System.out.println("Error generating file: " + e.getMessage());
        }
    }
}
