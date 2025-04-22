import java.io.*;
import java.nio.file.*;

public class ReadLargeFile {
    public static void main(String[] args) {
        String filePath = "input.txt";  // Specify your large file path here

        try (BufferedReader br = Files.newBufferedReader(Paths.get(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                if (line.toLowerCase().contains("error")) {
                    System.out.println(line);
                }
            }
        } catch (IOException e) {
            System.out.println("Error reading the file: " + e.getMessage());
        }
    }
}
