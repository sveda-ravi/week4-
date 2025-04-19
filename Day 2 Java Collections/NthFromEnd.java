import java.util.LinkedList;
import java.util.ListIterator;

public class NthFromEnd {

    public static <T> T findNthFromEnd(LinkedList<T> list, int n) {
        if (n <= 0) {
            throw new IllegalArgumentException("N must be positive.");
        }

        ListIterator<T> first = list.listIterator();
        ListIterator<T> second = list.listIterator();

        // Move first pointer n steps ahead
        int count = 0;
        while (count < n) {
            if (first.hasNext()) {
                first.next();
                count++;
            } else {
                throw new IllegalArgumentException("List is shorter than N.");
            }
        }

        // Move both pointers until first reaches the end
        while (first.hasNext()) {
            first.next();
            second.next();
        }

        // second is now at the Nth element from the end
        return second.next();
    }

    public static void main(String[] args) {
        LinkedList<String> linkedList = new LinkedList<>();
        linkedList.add("A");
        linkedList.add("B");
        linkedList.add("C");
        linkedList.add("D");
        linkedList.add("E");

        int N = 2;

        String result = findNthFromEnd(linkedList, N);

        System.out.println("List: " + linkedList);
        System.out.println("The " + N + "th element from the end is: " + result);
    }
}
