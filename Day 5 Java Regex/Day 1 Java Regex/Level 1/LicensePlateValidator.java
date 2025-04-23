import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class LicensePlateValidator {
    public static boolean isValidLicensePlate(String plate) {
        String regex = "^[A-Z]{2}[0-9]{4}$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(plate);
        return matcher.matches();
    }

    public static void main(String[] args) {
        System.out.println(isValidLicensePlate("AB1234"));  // ✅ true
        System.out.println(isValidLicensePlate("A12345"));  // ❌ false
        System.out.println(isValidLicensePlate("AB123"));   // ❌ false
        System.out.println(isValidLicensePlate("ab1234"));  // ❌ false (lowercase letters)
    }
}
