public class InterestCalculator {

    // Method to calculate interest
    public static double calculateInterest(double amount, double rate, int years) throws IllegalArgumentException {
        if (amount < 0 || rate < 0) {
            throw new IllegalArgumentException("Invalid input: Amount and rate must be positive");
        }
        // Simple interest calculation (SI = P * R * T / 100)
        return (amount * rate * years) / 100;
    }

    public static void main(String[] args) {
        double amount = 1000.0;
        double rate = 5.0;
        int years = 10;

        try {
            double interest = calculateInterest(amount, rate, years);
            System.out.println("Calculated interest: " + interest);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
}
