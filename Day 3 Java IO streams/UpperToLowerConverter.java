import java.io.*;

public class UpperToLowerConverter {
    public static void main(String[] args) {
        String sourceFile = "input.txt";
        String destinationFile = "output.txt";

        // You can change "UTF-8" to another charset if needed
        String charset = "UTF-8";

        try (
                BufferedReader reader = new BufferedReader(
                        new InputStreamReader(new FileInputStream(sourceFile), charset));
                BufferedWriter writer = new BufferedWriter(
                        new OutputStreamWriter(new FileOutputStream(destinationFile), charset))
        ) {
            String line;
            while ((line = reader.readLine()) != null) {
                writer.write(line.toLowerCase());
                writer.newLine();
            }
            System.out.println("Successfully converted all uppercase letters to lowercase in '" + destinationFile + "'.");

        } catch (IOException e) {
            System.out.println("An I/O error occurred: " + e.getMessage());
        }
    }
}
