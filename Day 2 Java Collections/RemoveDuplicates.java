import java.util.*;

public class RemoveDuplicates {

    public static <T> List<T> removeDuplicates(List<T> list) {
        // LinkedHashSet removes duplicates and keeps order
        Set<T> set = new LinkedHashSet<>(list);
        return new ArrayList<>(set);
    }

    public static void main(String[] args) {
        List<Integer> inputList = Arrays.asList(3, 1, 2, 2, 3, 4);

        List<Integer> result = removeDuplicates(inputList);

        System.out.println("Original List: " + inputList);
        System.out.println("List without duplicates: " + result);
    }
}
