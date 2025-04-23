import java.util.regex.Pattern;

public class CreditCardValidatorr {
    public static void validateCard(String cardNumber) {
        String visaRegex = "^4\\d{15}$";
        String masterRegex = "^5\\d{15}$";

        if (Pattern.matches(visaRegex, cardNumber)) {
            System.out.println(cardNumber + " is a valid Visa card.");
        } else if (Pattern.matches(masterRegex, cardNumber)) {
            System.out.println(cardNumber + " is a valid MasterCard.");
        } else {
            System.out.println(cardNumber + " is invalid.");
        }
    }

    public static void main(String[] args) {
        validateCard("4123456789012345");  // Valid Visa
        validateCard("5123456789012345");  // Valid MasterCard
        validateCard("6123456789012345");  // Invalid
        validateCard("41234567890123");    // Invalid (too short)
    }
}
