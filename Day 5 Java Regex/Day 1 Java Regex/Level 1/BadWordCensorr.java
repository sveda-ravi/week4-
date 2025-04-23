import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class BadWordCensorr {
    public static void censorBadWords(String text) {
        String[] badWords = {"damn", "stupid"};  // list of bad words
        String censoredText = text;

        for (String word : badWords) {
            String regex = "\\b" + word + "\\b";  // match whole word only
            censoredText = censoredText.replaceAll("(?i)" + regex, "****");
        }

        System.out.println(censoredText);
    }

    public static void main(String[] args) {
        String inputText = "This is a damn bad example with some stupid words.";
        censorBadWords(inputText);
    }
}
