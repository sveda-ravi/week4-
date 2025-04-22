import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class GenerateInputFile {
    public static void main(String[] args) {
        String filename = "input.txt";

        String sampleText = """
                THIS is a SAMPLE Line.
                Another LINE with MIXED Case.
                JAVA Programming IS Fun!
                OpenAI GPT MAKES Life EASIER.
                """;

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename))) {
            writer.write(sampleText);
            System.out.println("Sample 'input.txt' file created successfully.");
        } catch (IOException e) {
            System.out.println("An error occurred while creating input.txt: " + e.getMessage());
        }
    }
}
