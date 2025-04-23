import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class EmailExtractorr {
    public static void extractEmails(String text) {
        String regex = "[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(text);

        while (matcher.find()) {
            System.out.println(matcher.group());
        }
    }

    public static void main(String[] args) {
        String exampleText = "Contact us at support@example.com and info@company.org";
        extractEmails(exampleText);
    }
}
