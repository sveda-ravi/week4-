import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class IPAddressValidatorr {
    public static void validateIPAddress(String ip) {
        String regex = "\\b((25[0-5]|2[0-4]\\d|1\\d\\d|[1-9]?\\d)\\.){3}"
                + "(25[0-5]|2[0-4]\\d|1\\d\\d|[1-9]?\\d)\\b";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(ip);

        if (matcher.matches()) {
            System.out.println(ip + " is a valid IPv4 address.");
        } else {
            System.out.println(ip + " is invalid.");
        }
    }

    public static void main(String[] args) {
        validateIPAddress("192.168.1.1");       // valid
        validateIPAddress("255.255.255.255");   // valid
        validateIPAddress("256.100.50.25");     // invalid
        validateIPAddress("123.45.67");         // invalid
    }
}
