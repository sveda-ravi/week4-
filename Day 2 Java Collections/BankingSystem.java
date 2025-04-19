import java.util.*;

public class BankingSystem {

    // HashMap to store customer accounts (AccountNumber -> Balance)
    private static Map<String, Double> accounts = new HashMap<>();

    // TreeMap to sort customers by balance (AccountNumber -> Balance) in descending order
    private static Map<String, Double> sortedAccounts = new TreeMap<>((a, b) -> Double.compare(accounts.get(b), accounts.get(a)));

    // Queue to process withdrawal requests (AccountNumber -> WithdrawalAmount)
    private static Queue<Map.Entry<String, Double>> withdrawalQueue = new LinkedList<>();

    // Method to add a new customer account
    public static void addAccount(String accountNumber, double balance) {
        accounts.put(accountNumber, balance);
        sortedAccounts.put(accountNumber, balance);
    }

    // Method to deposit money into an account
    public static void deposit(String accountNumber, double amount) {
        if (accounts.containsKey(accountNumber)) {
            double newBalance = accounts.get(accountNumber) + amount;
            accounts.put(accountNumber, newBalance);
            sortedAccounts.put(accountNumber, newBalance);  // Update the TreeMap for sorted order
            System.out.println("Deposited $" + amount + " to account " + accountNumber + ". New balance: $" + newBalance);
        } else {
            System.out.println("Account number " + accountNumber + " not found.");
        }
    }

    // Method to withdraw money from an account (queued request)
    public static void withdraw(String accountNumber, double amount) {
        if (accounts.containsKey(accountNumber)) {
            withdrawalQueue.offer(new AbstractMap.SimpleEntry<>(accountNumber, amount)); // Queue the withdrawal request
            System.out.println("Withdrawal request of $" + amount + " from account " + accountNumber + " added to the queue.");
        } else {
            System.out.println("Account number " + accountNumber + " not found.");
        }
    }

    // Method to process all withdrawal requests in the queue
    public static void processWithdrawals() {
        while (!withdrawalQueue.isEmpty()) {
            Map.Entry<String, Double> request = withdrawalQueue.poll();
            String accountNumber = request.getKey();
            double withdrawalAmount = request.getValue();

            if (accounts.get(accountNumber) >= withdrawalAmount) {
                // Process the withdrawal
                double newBalance = accounts.get(accountNumber) - withdrawalAmount;
                accounts.put(accountNumber, newBalance);
                sortedAccounts.put(accountNumber, newBalance); // Update TreeMap for sorting
                System.out.println("Processed withdrawal of $" + withdrawalAmount + " from account " + accountNumber + ". New balance: $" + newBalance);
            } else {
                System.out.println("Insufficient balance in account " + accountNumber + " for withdrawal of $" + withdrawalAmount);
            }
        }
    }

    // Method to view all accounts sorted by balance (highest to lowest)
    public static void viewSortedAccounts() {
        System.out.println("\nAccounts sorted by balance (highest to lowest):");
        for (Map.Entry<String, Double> entry : sortedAccounts.entrySet()) {
            System.out.println("Account " + entry.getKey() + " has balance: $" + entry.getValue());
        }
    }

    // Main method to demonstrate functionality
    public static void main(String[] args) {

        // Adding some accounts
        addAccount("ACC1001", 5000);
        addAccount("ACC1002", 3000);
        addAccount("ACC1003", 10000);

        // Viewing accounts sorted by balance
        viewSortedAccounts();

        // Depositing money
        deposit("ACC1001", 2000);
        deposit("ACC1002", 1500);

        // Viewing accounts sorted by balance after deposit
        viewSortedAccounts();

        // Making withdrawal requests
        withdraw("ACC1001", 1000);
        withdraw("ACC1002", 5000);  // Insufficient funds

        // Processing withdrawals
        processWithdrawals();

        // Viewing accounts sorted by balance after processing withdrawals
        viewSortedAccounts();
    }
}
