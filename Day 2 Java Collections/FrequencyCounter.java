import java.util.*;

public class FrequencyCounter {

    public static Map<String, Integer> countFrequencies(List<String> list) {
        Map<String, Integer> frequencyMap = new HashMap<>();

        for (String item : list) {
            // Get current count or default to 0, then add 1
            frequencyMap.put(item, frequencyMap.getOrDefault(item, 0) + 1);
        }

        return frequencyMap;
    }

    public static void main(String[] args) {
        List<String> inputList = Arrays.asList("apple", "banana", "apple", "orange");

        Map<String, Integer> result = countFrequencies(inputList);

        System.out.println("Input List: " + inputList);
        System.out.println("Frequency Map: " + result);
    }
}
