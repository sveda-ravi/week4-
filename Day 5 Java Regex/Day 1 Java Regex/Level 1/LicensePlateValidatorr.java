import java.util.regex.Pattern;

public class LicensePlateValidatorr {
    public static void validatePlate(String plate) {
        String regex = "^[A-Z]{2}\\d{4}$";

        if (Pattern.matches(regex, plate)) {
            System.out.println(plate + " is valid.");
        } else {
            System.out.println(plate + " is invalid.");
        }
    }

    public static void main(String[] args) {
        validatePlate("AB1234");  // valid
        validatePlate("A12345");  // invalid
        validatePlate("XY9999");  // valid
        validatePlate("ab1234");  // invalid (lowercase)
    }
}
