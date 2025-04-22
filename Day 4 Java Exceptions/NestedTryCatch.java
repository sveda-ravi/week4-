import java.util.Scanner;

public class NestedTryCatch {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Take array size and elements as input
        System.out.print("Enter the size of the array: ");
        int size = scanner.nextInt();

        int[] arr = new int[size];
        System.out.println("Enter " + size + " elements:");
        for (int i = 0; i < size; i++) {
            arr[i] = scanner.nextInt();
        }

        // Take index and divisor as input
        System.out.print("Enter the index to access: ");
        int index = scanner.nextInt();

        System.out.print("Enter the divisor: ");
        int divisor = scanner.nextInt();

        try {
            try {
                // Try to access the array element at the specified index
                int element = arr[index];

                try {
                    // Try to divide the element by the divisor
                    int result = element / divisor;
                    System.out.println("Result: " + result);
                } catch (ArithmeticException e) {
                    System.out.println("Cannot divide by zero!");
                }

            } catch (ArrayIndexOutOfBoundsException e) {
                System.out.println("Invalid array index!");
            }
        } finally {
            scanner.close();
        }
    }
}
