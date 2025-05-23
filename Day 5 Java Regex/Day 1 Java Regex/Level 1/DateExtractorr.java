import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class DateExtractorr {
    public static void extractDates(String text) {
        String regex = "\\b\\d{2}/\\d{2}/\\d{4}\\b";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(text);

        while (matcher.find()) {
            System.out.print(matcher.group() + ", ");
        }
    }

    public static void main(String[] args) {
        String exampleText = "The events are scheduled for 12/05/2023, 15/08/2024, and 29/02/2020.";
        extractDates(exampleText);
    }
}
