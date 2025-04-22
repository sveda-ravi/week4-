import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class GenerateDummyFile {
    public static void main(String[] args) {
        String filename = "sample.txt";
        String content = """
            Hello world! This is a test file.
            The world is big and full of opportunities.
            Hello again, this is a simple test file to check word counting.
            Enjoy the world of programming!
            Programming is fun and challenging. Hello to all!
            """;

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename))) {
            writer.write(content);
            System.out.println("Dummy file 'sample.txt' created successfully.");
        } catch (IOException e) {
            System.out.println("Error creating dummy file: " + e.getMessage());
        }
    }
}
