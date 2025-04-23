import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class CurrencyExtractorr {
    public static void extractCurrency(String text) {
        String regex = "\\$?\\d+\\.\\d{2}";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(text);

        while (matcher.find()) {
            System.out.print(matcher.group() + ", ");
        }
    }

    public static void main(String[] args) {
        String inputText = "The price is $45.99, and the discount is 10.50.";
        extractCurrency(inputText);
    }
}
