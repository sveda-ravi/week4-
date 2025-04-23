import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class LinkExtractorr {
    public static void extractLinks(String text) {
        String regex = "https?://[a-zA-Z0-9.-]+(?:/[a-zA-Z0-9%_.-]*)*";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(text);

        while (matcher.find()) {
            System.out.print(matcher.group() + ", ");
        }
    }

    public static void main(String[] args) {
        String exampleText = "Visit https://www.google.com and http://example.org for more info.";
        extractLinks(exampleText);
    }
}
