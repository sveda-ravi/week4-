// Custom exception for insufficient balance
class InsufficientBalanceException extends Exception {
    public InsufficientBalanceException(String message) {
        super(message);
    }
}

public class BankAccount {

    private double balance;

    // Constructor to initialize the account balance
    public BankAccount(double balance) {
        this.balance = balance;
    }

    // Method to withdraw money
    public void withdraw(double amount) throws InsufficientBalanceException {
        if (amount < 0) {
            throw new IllegalArgumentException("Invalid amount!");
        }
        if (amount > balance) {
            throw new InsufficientBalanceException("Insufficient balance!");
        }
        balance -= amount;
        System.out.println("Withdrawal successful, new balance: " + balance);
    }

    public static void main(String[] args) {
        BankAccount account = new BankAccount(500.0); // Initial balance is 500

        try {
            // Attempting withdrawal
            account.withdraw(600.0); // Insufficient balance
            // account.withdraw(-100.0); // Invalid amount
            // account.withdraw(100.0); // Valid withdrawal
        } catch (InsufficientBalanceException e) {
            System.out.println(e.getMessage());
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
}
