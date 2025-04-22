public class ExceptionPropagation {

    // method1() throws an ArithmeticException
    public static void method1() {
        int result = 10 / 0; // This will throw ArithmeticException
    }

    // method2() calls method1()
    public static void method2() {
        method1(); // Exception is propagated to method2
    }

    public static void main(String[] args) {
        try {
            method2(); // Exception is propagated from method2 to main
        } catch (ArithmeticException e) {
            System.out.println("Handled exception in main");
        }
    }
}
