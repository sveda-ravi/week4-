import java.util.Scanner;

public class ArrayOperations {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Accept an array size and index from the user
        System.out.print("Enter the size of the array: ");
        int size = scanner.nextInt();

        // Create an array and accept values
        int[] arr = new int[size];
        System.out.println("Enter " + size + " values for the array:");
        for (int i = 0; i < size; i++) {
            arr[i] = scanner.nextInt();
        }

        // Accept an index to retrieve from the array
        System.out.print("Enter the index to retrieve the value: ");
        int index = scanner.nextInt();

        try {
            // Check for NullPointerException
            if (arr == null) {
                throw new NullPointerException();
            }

            // Retrieve and print the value at the given index
            System.out.println("Value at index " + index + ": " + arr[index]);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Invalid index!");
        } catch (NullPointerException e) {
            System.out.println("Array is not initialized!");
        } finally {
            scanner.close();
        }
    }
}
