import java.io.*;
import java.nio.file.Files;
import java.util.Arrays;

public class ImageByteArrayCopy {
    public static void main(String[] args) {
        String sourceImage = "source_image.jpg";
        String targetImage = "copied_image.jpg";

        try {
            // Read image into byte array
            byte[] imageBytes = imageToByteArray(sourceImage);

            // Write byte array back to a new image file
            byteArrayToImage(imageBytes, targetImage);

            // Verify if both files are identical
            if (verifyFiles(sourceImage, targetImage)) {
                System.out.println("Success: The copied image is identical to the original.");
            } else {
                System.out.println("Warning: The copied image differs from the original.");
            }

        } catch (IOException e) {
            System.out.println("An I/O error occurred: " + e.getMessage());
        }
    }

    private static byte[] imageToByteArray(String filePath) throws IOException {
        try (FileInputStream fis = new FileInputStream(filePath);
             ByteArrayOutputStream baos = new ByteArrayOutputStream()) {

            byte[] buffer = new byte[4096]; // 4 KB buffer
            int bytesRead;
            while ((bytesRead = fis.read(buffer)) != -1) {
                baos.write(buffer, 0, bytesRead);
            }

            System.out.println("Image successfully read into byte array.");
            return baos.toByteArray();
        }
    }

    private static void byteArrayToImage(byte[] data, String filePath) throws IOException {
        try (ByteArrayInputStream bais = new ByteArrayInputStream(data);
             FileOutputStream fos = new FileOutputStream(filePath)) {

            byte[] buffer = new byte[4096]; // 4 KB buffer
            int bytesRead;
            while ((bytesRead = bais.read(buffer)) != -1) {
                fos.write(buffer, 0, bytesRead);
            }

            System.out.println("Byte array successfully written to new image file.");
        }
    }

    private static boolean verifyFiles(String file1, String file2) throws IOException {
        byte[] original = Files.readAllBytes(new File(file1).toPath());
        byte[] copied = Files.readAllBytes(new File(file2).toPath());
        return Arrays.equals(original, copied);
    }
}
