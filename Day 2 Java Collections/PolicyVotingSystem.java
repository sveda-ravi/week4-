import java.util.*;
import java.time.LocalDate;

class InsurancePolicy {
    private String policyNumber;
    private String policyholderName;
    private LocalDate expiryDate;
    private String coverageType;
    private double premiumAmount;

    public InsurancePolicy(String policyNumber, String policyholderName, LocalDate expiryDate, String coverageType, double premiumAmount) {
        this.policyNumber = policyNumber;
        this.policyholderName = policyholderName;
        this.expiryDate = expiryDate;
        this.coverageType = coverageType;
        this.premiumAmount = premiumAmount;
    }

    public String getPolicyNumber() {
        return policyNumber;
    }

    public String getPolicyholderName() {
        return policyholderName;
    }

    public LocalDate getExpiryDate() {
        return expiryDate;
    }

    public String getCoverageType() {
        return coverageType;
    }

    public double getPremiumAmount() {
        return premiumAmount;
    }

    @Override
    public String toString() {
        return "PolicyNumber: " + policyNumber + ", Policyholder: " + policyholderName + ", Expiry: " + expiryDate + ", Coverage: " + coverageType + ", Premium: " + premiumAmount;
    }
}

public class PolicyVotingSystem {

    // 1. Insurance Policy Management System
    public static class InsurancePolicyManagement {

        // Maps to store policies
        private static Map<String, InsurancePolicy> policyHashMap = new HashMap<>();
        private static Map<String, InsurancePolicy> policyLinkedHashMap = new LinkedHashMap<>();
        private static Map<String, InsurancePolicy> policyTreeMap = new TreeMap<>(Comparator.comparing((String key) -> policyHashMap.get(key).getExpiryDate())); // Corrected TreeMap comparator

        // Method to store policies
        public static void storePolicy(InsurancePolicy policy) {
            policyHashMap.put(policy.getPolicyNumber(), policy);
            policyLinkedHashMap.put(policy.getPolicyNumber(), policy);
            policyTreeMap.put(policy.getPolicyNumber(), policy);
        }

        // Method to retrieve a policy by its number
        public static InsurancePolicy getPolicyByNumber(String policyNumber) {
            return policyHashMap.get(policyNumber);
        }

        // Method to list policies expiring within the next 30 days
        public static List<InsurancePolicy> getPoliciesExpiringSoon() {
            List<InsurancePolicy> expiringSoon = new ArrayList<>();
            LocalDate today = LocalDate.now();
            LocalDate thirtyDaysLater = today.plusDays(30);

            for (InsurancePolicy policy : policyHashMap.values()) {
                if (!policy.getExpiryDate().isBefore(today) && policy.getExpiryDate().isBefore(thirtyDaysLater)) {
                    expiringSoon.add(policy);
                }
            }
            return expiringSoon;
        }

        // Method to list policies for a specific policyholder
        public static List<InsurancePolicy> getPoliciesByPolicyholder(String policyholderName) {
            List<InsurancePolicy> policies = new ArrayList<>();
            for (InsurancePolicy policy : policyHashMap.values()) {
                if (policy.getPolicyholderName().equalsIgnoreCase(policyholderName)) {
                    policies.add(policy);
                }
            }
            return policies;
        }

        // Method to remove expired policies
        public static void removeExpiredPolicies() {
            LocalDate today = LocalDate.now();
            Iterator<Map.Entry<String, InsurancePolicy>> iterator = policyHashMap.entrySet().iterator();
            while (iterator.hasNext()) {
                Map.Entry<String, InsurancePolicy> entry = iterator.next();
                if (entry.getValue().getExpiryDate().isBefore(today)) {
                    iterator.remove();
                }
            }
        }
    }

    // 2. Voting System
    public static class VotingSystem {

        // Maps to store votes
        private static Map<String, Integer> candidateVotesHashMap = new HashMap<>();
        private static Map<String, Integer> candidateVotesLinkedHashMap = new LinkedHashMap<>();
        private static Map<String, Integer> candidateVotesTreeMap = new TreeMap<>(Comparator.comparingInt(candidateVotesHashMap::get).reversed()); // Sort by votes

        // Method to add a vote
        public static void vote(String candidate) {
            candidateVotesHashMap.put(candidate, candidateVotesHashMap.getOrDefault(candidate, 0) + 1);
            candidateVotesLinkedHashMap.put(candidate, candidateVotesLinkedHashMap.getOrDefault(candidate, 0) + 1);
        }

        // Method to display the results in sorted order
        public static void displayResults() {
            System.out.println("Voting Results (Sorted by Votes):");
            candidateVotesTreeMap.entrySet().forEach(entry -> System.out.println(entry.getKey() + " = " + entry.getValue() + " votes"));
        }

        // Method to display the results in the order of voting
        public static void displayOrderedResults() {
            System.out.println("Voting Results (In Voting Order):");
            candidateVotesLinkedHashMap.entrySet().forEach(entry -> System.out.println(entry.getKey() + " = " + entry.getValue() + " votes"));
        }
    }

    public static void main(String[] args) {

        // Test Insurance Policy Management System
        System.out.println("Insurance Policy Management System:");

        InsurancePolicy policy1 = new InsurancePolicy("P001", "Alice", LocalDate.of(2025, 5, 30), "Health", 500);
        InsurancePolicy policy2 = new InsurancePolicy("P002", "Bob", LocalDate.of(2025, 6, 15), "Auto", 300);
        InsurancePolicy policy3 = new InsurancePolicy("P003", "Alice", LocalDate.of(2025, 4, 10), "Home", 200);
        InsurancePolicy policy4 = new InsurancePolicy("P004", "Carol", LocalDate.of(2025, 5, 10), "Health", 450);

        InsurancePolicyManagement.storePolicy(policy1);
        InsurancePolicyManagement.storePolicy(policy2);
        InsurancePolicyManagement.storePolicy(policy3);
        InsurancePolicyManagement.storePolicy(policy4);

        System.out.println("Policy with number P001: " + InsurancePolicyManagement.getPolicyByNumber("P001"));
        System.out.println("Policies expiring soon: " + InsurancePolicyManagement.getPoliciesExpiringSoon());
        System.out.println("Policies by Alice: " + InsurancePolicyManagement.getPoliciesByPolicyholder("Alice"));
        InsurancePolicyManagement.removeExpiredPolicies();
        System.out.println("Policies after removing expired ones: " + InsurancePolicyManagement.policyHashMap);

        System.out.println("\n");

        // Test Voting System
        System.out.println("Voting System:");

        VotingSystem.vote("Alice");
        VotingSystem.vote("Bob");
        VotingSystem.vote("Alice");
        VotingSystem.vote("Carol");
        VotingSystem.vote("Alice");
        VotingSystem.vote("Bob");

        VotingSystem.displayResults();
        VotingSystem.displayOrderedResults();
    }
}
