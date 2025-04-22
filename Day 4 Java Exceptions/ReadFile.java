import java.io.File;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.IOException;

public class ReadFile {
    public static void main(String[] args) {
        File file = new File("data.txt");

        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            System.out.println("File not found");
        }
    }
}
