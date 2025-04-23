import java.util.regex.Pattern;

public class HexColorValidator {
    public static void validateHexColor(String color) {
        String regex = "^#[0-9A-Fa-f]{6}$";

        if (Pattern.matches(regex, color)) {
            System.out.println(color + " → Valid");
        } else {
            System.out.println(color + " → Invalid");
        }
    }

    public static void main(String[] args) {
        validateHexColor("#FFA500");  // Valid
        validateHexColor("#ff4500");  // Valid
        validateHexColor("#123");     // Invalid
        validateHexColor("123456");   // Invalid (missing #)
    }
}
