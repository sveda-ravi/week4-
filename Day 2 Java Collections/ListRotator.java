import java.util.*;

public class ListRotator {

    public static <T> List<T> rotateList(List<T> list, int positions) {
        int size = list.size();
        if (size == 0) return list;

        // Handle rotations larger than the list size
        positions = positions % size;

        // Split and combine
        List<T> rotated = new ArrayList<>();
        rotated.addAll(list.subList(positions, size));  // from 'positions' to end
        rotated.addAll(list.subList(0, positions));    // from start to 'positions'

        return rotated;
    }

    public static void main(String[] args) {
        List<Integer> inputList = Arrays.asList(10, 20, 30, 40, 50);
        int rotateBy = 2;

        List<Integer> rotatedList = rotateList(inputList, rotateBy);

        System.out.println("Original List: " + inputList);
        System.out.println("Rotated List: " + rotatedList);
    }
}
