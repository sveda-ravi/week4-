import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class UsernameValidator {
    public static boolean isValidUsername(String username) {
        String regex = "^[a-zA-Z][a-zA-Z0-9_]{4,14}$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(username);
        return matcher.matches();
    }

    public static void main(String[] args) {
        System.out.println(isValidUsername("user_123"));  // ✅ true
        System.out.println(isValidUsername("123user"));   // ❌ false
        System.out.println(isValidUsername("us"));        // ❌ false
        System.out.println(isValidUsername("User_Name15")); // ✅ true
    }
}
