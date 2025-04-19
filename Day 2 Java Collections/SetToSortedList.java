import java.util.*;

public class SetToSortedList {

    public static List<Integer> convertToSortedList(Set<Integer> set) {
        // TreeSet automatically sorts the elements
        Set<Integer> sortedSet = new TreeSet<>(set);
        return new ArrayList<>(sortedSet);  // Convert the sorted set to a List
    }

    public static void main(String[] args) {
        Set<Integer> inputSet = new HashSet<>(Arrays.asList(5, 3, 9, 1));

        List<Integer> sortedList = convertToSortedList(inputSet);

        System.out.println("Original Set: " + inputSet);
        System.out.println("Sorted List: " + sortedList);
    }
}
