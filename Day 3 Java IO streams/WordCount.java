import java.io.*;
import java.util.*;

public class WordCount {
    public static void main(String[] args) {
        String filePath = "sample.txt";  // Path to the file to read

        // Create a HashMap to store word counts
        HashMap<String, Integer> wordCountMap = new HashMap<>();

        // Read the file and count word occurrences
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] words = line.split("\\W+");  // Split by non-word characters (whitespace, punctuation)
                for (String word : words) {
                    if (!word.isEmpty()) {
                        word = word.toLowerCase();  // Convert to lowercase to count case-insensitively
                        wordCountMap.put(word, wordCountMap.getOrDefault(word, 0) + 1);
                    }
                }
            }
        } catch (IOException e) {
            System.out.println("Error reading the file: " + e.getMessage());
        }

        // Sort the words by frequency
        List<Map.Entry<String, Integer>> sortedList = new ArrayList<>(wordCountMap.entrySet());
        sortedList.sort((entry1, entry2) -> entry2.getValue().compareTo(entry1.getValue()));

        // Display the top 5 most frequent words
        System.out.println("Top 5 most frequent words:");
        for (int i = 0; i < 5 && i < sortedList.size(); i++) {
            Map.Entry<String, Integer> entry = sortedList.get(i);
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }
}
