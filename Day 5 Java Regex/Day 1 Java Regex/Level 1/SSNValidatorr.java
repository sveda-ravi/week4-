import java.util.regex.Pattern;

public class SSNValidatorr {
    public static void validateSSN(String ssn) {
        String regex = "^\\d{3}-\\d{2}-\\d{4}$";

        if (Pattern.matches(regex, ssn)) {
            System.out.println("✅ \"" + ssn + "\" is valid");
        } else {
            System.out.println("❌ \"" + ssn + "\" is invalid");
        }
    }

    public static void main(String[] args) {
        validateSSN("123-45-6789");  // valid
        validateSSN("123456789");    // invalid
        validateSSN("12-345-6789");  // invalid
    }
}
