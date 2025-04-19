import java.util.*;
import java.text.SimpleDateFormat;

class Policy {
    private String policyNumber;
    private String policyholderName;
    private Date expiryDate;
    private String coverageType;
    private double premiumAmount;

    public Policy(String policyNumber, String policyholderName, Date expiryDate, String coverageType, double premiumAmount) {
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

    public Date getExpiryDate() {
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
        return "Policy{" +
                "Number='" + policyNumber + '\'' +
                ", Name='" + policyholderName + '\'' +
                ", Expiry=" + expiryDate +
                ", Coverage='" + coverageType + '\'' +
                ", Premium=" + premiumAmount +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Policy)) return false;
        Policy policy = (Policy) o;
        return Objects.equals(policyNumber, policy.policyNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(policyNumber);
    }
}

public class InsurancePolicyManager {
    private Set<Policy> hashSetPolicies = new HashSet<>();
    private Set<Policy> linkedHashSetPolicies = new LinkedHashSet<>();
    private Set<Policy> treeSetPolicies = new TreeSet<>(Comparator.comparing(Policy::getExpiryDate));

    public void addPolicy(Policy policy) {
        hashSetPolicies.add(policy);
        linkedHashSetPolicies.add(policy);
        treeSetPolicies.add(policy);
    }

    public void displayAllPolicies(Set<Policy> policies, String setName) {
        System.out.println("\n=== " + setName + " ===");
        policies.forEach(System.out::println);
    }

    public void displayPoliciesExpiringSoon(Set<Policy> policies) {
        System.out.println("\n=== Policies Expiring in Next 30 Days ===");
        Calendar cal = Calendar.getInstance();
        Date now = new Date();
        cal.setTime(now);
        cal.add(Calendar.DAY_OF_YEAR, 30);
        Date in30Days = cal.getTime();

        policies.stream()
                .filter(p -> p.getExpiryDate().before(in30Days))
                .forEach(System.out::println);
    }

    public void displayPoliciesByCoverage(Set<Policy> policies, String coverageType) {
        System.out.println("\n=== Policies with Coverage: " + coverageType + " ===");
        policies.stream()
                .filter(p -> p.getCoverageType().equalsIgnoreCase(coverageType))
                .forEach(System.out::println);
    }

    public void comparePerformance() {
        Policy testPolicy = new Policy("PX", "Test User", new Date(), "Health", 1000.0);

        // Add
        long start = System.nanoTime();
        hashSetPolicies.add(testPolicy);
        long end = System.nanoTime();
        System.out.println("\nHashSet Add Time: " + (end - start) + " ns");

        start = System.nanoTime();
        linkedHashSetPolicies.add(testPolicy);
        end = System.nanoTime();
        System.out.println("LinkedHashSet Add Time: " + (end - start) + " ns");

        start = System.nanoTime();
        treeSetPolicies.add(testPolicy);
        end = System.nanoTime();
        System.out.println("TreeSet Add Time: " + (end - start) + " ns");

        // Search
        start = System.nanoTime();
        hashSetPolicies.contains(testPolicy);
        end = System.nanoTime();
        System.out.println("HashSet Search Time: " + (end - start) + " ns");

        start = System.nanoTime();
        linkedHashSetPolicies.contains(testPolicy);
        end = System.nanoTime();
        System.out.println("LinkedHashSet Search Time: " + (end - start) + " ns");

        start = System.nanoTime();
        treeSetPolicies.contains(testPolicy);
        end = System.nanoTime();
        System.out.println("TreeSet Search Time: " + (end - start) + " ns");

        // Remove
        start = System.nanoTime();
        hashSetPolicies.remove(testPolicy);
        end = System.nanoTime();
        System.out.println("HashSet Remove Time: " + (end - start) + " ns");

        start = System.nanoTime();
        linkedHashSetPolicies.remove(testPolicy);
        end = System.nanoTime();
        System.out.println("LinkedHashSet Remove Time: " + (end - start) + " ns");

        start = System.nanoTime();
        treeSetPolicies.remove(testPolicy);
        end = System.nanoTime();
        System.out.println("TreeSet Remove Time: " + (end - start) + " ns");
    }

    public static void main(String[] args) throws Exception {
        InsurancePolicyManager manager = new InsurancePolicyManager();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

        // Add sample policies
        manager.addPolicy(new Policy("P001", "John Doe", sdf.parse("2025-05-10"), "Health", 1500.0));
        manager.addPolicy(new Policy("P002", "Jane Smith", sdf.parse("2025-06-05"), "Auto", 1200.0));
        manager.addPolicy(new Policy("P003", "Alice Brown", sdf.parse("2025-04-20"), "Home", 2000.0));
        manager.addPolicy(new Policy("P004", "Bob White", sdf.parse("2025-05-25"), "Health", 1800.0));

        // Display all policies from each set
        manager.displayAllPolicies(manager.hashSetPolicies, "HashSet");
        manager.displayAllPolicies(manager.linkedHashSetPolicies, "LinkedHashSet");
        manager.displayAllPolicies(manager.treeSetPolicies, "TreeSet (sorted by expiry)");

        // Show expiring soon (within 30 days)
        manager.displayPoliciesExpiringSoon(manager.hashSetPolicies);

        // Show policies by coverage type
        manager.displayPoliciesByCoverage(manager.hashSetPolicies, "Health");

        // Compare performance
        manager.comparePerformance();
    }
}
