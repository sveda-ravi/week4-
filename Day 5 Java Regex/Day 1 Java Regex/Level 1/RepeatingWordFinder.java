import java.util.regex.Pattern;
import java.util.regex.Matcher;
import java.util.HashSet;

public class RepeatingWordFinder {
    public static void findRepeatingWords(String text) {
        String regex = "\\b(\\w+)\\b\\s+\\b\\1\\b";
        Pattern pattern = Pattern.compile(regex, Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(text);
        HashSet<String> foundWords = new HashSet<>();

        while (matcher.find()) {
            foundWords.add(matcher.group(1));
        }

        for (String word : foundWords) {
            System.out.print(word + ", ");
        }
    }

    public static void main(String[] args) {
        String inputText = "This is is a repeated repeated word test.";
        findRepeatingWords(inputText);
    }
}
