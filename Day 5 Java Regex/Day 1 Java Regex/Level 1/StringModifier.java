public class StringModifier {
    public static void replaceMultipleSpaces(String text) {
        // Regex to replace multiple spaces with a single space
        String modifiedText = text.replaceAll("\\s{2,}", " ");
        System.out.println(modifiedText);
    }

    public static void main(String[] args) {
        String inputText = "This is an example    with multiple spaces.";
        replaceMultipleSpaces(inputText);
    }
}
