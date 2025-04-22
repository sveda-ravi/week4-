import java.io.*;

class Student {
    private int rollNumber;
    private String name;
    private double gpa;

    public Student(int rollNumber, String name, double gpa) {
        this.rollNumber = rollNumber;
        this.name = name;
        this.gpa = gpa;
    }

    public int getRollNumber() {
        return rollNumber;
    }

    public String getName() {
        return name;
    }

    public double getGpa() {
        return gpa;
    }
}

public class StudentDataStream {
    private static final String FILE_NAME = "student_data.dat";

    public static void main(String[] args) {
        // Example student data
        Student student1 = new Student(101, "John Doe", 3.75);
        Student student2 = new Student(102, "Jane Smith", 3.9);

        // Store student details in binary file
        storeStudentData(student1);
        storeStudentData(student2);

        // Retrieve student details from binary file
        retrieveStudentData();
    }

    private static void storeStudentData(Student student) {
        try (DataOutputStream dos = new DataOutputStream(new FileOutputStream(FILE_NAME, true))) {
            dos.writeInt(student.getRollNumber());
            dos.writeUTF(student.getName());
            dos.writeDouble(student.getGpa());
            System.out.println("Stored student: " + student.getName());
        } catch (IOException e) {
            System.out.println("Error writing data: " + e.getMessage());
        }
    }

    private static void retrieveStudentData() {
        try (DataInputStream dis = new DataInputStream(new FileInputStream(FILE_NAME))) {
            while (dis.available() > 0) {
                int rollNumber = dis.readInt();
                String name = dis.readUTF();
                double gpa = dis.readDouble();
                System.out.println("Retrieved student: Roll No. " + rollNumber + ", Name: " + name + ", GPA: " + gpa);
            }
        } catch (IOException e) {
            System.out.println("Error reading data: " + e.getMessage());
        }
    }
}
