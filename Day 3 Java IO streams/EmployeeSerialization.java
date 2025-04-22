import java.io.*;
import java.util.ArrayList;
import java.util.List;

// Employee class must implement Serializable
class Employee implements Serializable {
    private static final long serialVersionUID = 1L;

    private int id;
    private String name;
    private String department;
    private double salary;

    public Employee(int id, String name, String department, double salary) {
        this.id = id;
        this.name = name;
        this.department = department;
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Employee [ID=" + id +
                ", Name=" + name +
                ", Department=" + department +
                ", Salary=" + salary + "]";
    }
}

public class EmployeeSerialization {
    private static final String FILE_NAME = "employees.ser";

    public static void main(String[] args) {
        List<Employee> employeeList = new ArrayList<>();
        employeeList.add(new Employee(1, "Alice", "Engineering", 75000));
        employeeList.add(new Employee(2, "Bob", "Marketing", 65000));
        employeeList.add(new Employee(3, "Charlie", "HR", 60000));

        // Serialize the list
        serializeEmployees(employeeList);

        // Deserialize and display the list
        List<Employee> retrievedList = deserializeEmployees();
        if (retrievedList != null) {
            System.out.println("\nDeserialized Employee List:");
            for (Employee emp : retrievedList) {
                System.out.println(emp);
            }
        }
    }

    private static void serializeEmployees(List<Employee> employees) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(FILE_NAME))) {
            oos.writeObject(employees);
            System.out.println("Employees serialized to file: " + FILE_NAME);
        } catch (IOException e) {
            System.out.println("Error during serialization: " + e.getMessage());
        }
    }

    @SuppressWarnings("unchecked")
    private static List<Employee> deserializeEmployees() {
        List<Employee> employees = null;
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(FILE_NAME))) {
            employees = (List<Employee>) ois.readObject();
            System.out.println("Employees deserialized from file: " + FILE_NAME);
        } catch (IOException e) {
            System.out.println("Error during deserialization: " + e.getMessage());
        } catch (ClassNotFoundException e) {
            System.out.println("Employee class not found: " + e.getMessage());
        }
        return employees;
    }
}
