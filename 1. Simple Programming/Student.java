import java.util.Arrays;
import java.util.List;

public class Student {
    private String name;
    private int roll;
    private double cgpa;


    public Student() {
    }

    public Student(String name, int roll, double cgpa) {
        this.name = name;
        this.roll = roll;
        this.cgpa = cgpa;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getRoll() {
        return roll;
    }

    public void setRoll(int roll) {
        this.roll = roll;
    }

    public double getCgpa() {
        return cgpa;
    }

    public void setCgpa(double cgpa) {
        this.cgpa = cgpa;
    }

    @Override
    public String toString() {
        return "Student Name: " + name +'\n' +
                "Roll: " + roll + '\n' +
                "CGPA: " + cgpa ;
    }

    private static List<Student> getStudentList() {
        Student student1 = new Student();
        student1.setName("Ahmed Hasin Neehal");
        student1.setRoll(16101142);
        student1.setCgpa(3.12);


        Student student2 = new Student();
        student2.setName("Fahad Hasan");
        student2.setRoll(16104041);
        student2.setCgpa(2.57);

        return Arrays.asList(student1, student2);
    }

    public static Student getStudentByRoll(int roll) {
        return getStudentList().stream()
                .filter(student -> student.getRoll()==roll)
                .findFirst().orElse(null);
    }

    public static void printAllStudentInfo() {
        getStudentList().forEach(student -> {
            System.out.println(student.toString());
        });
    }


    public static void main(String[] args) {
        System.out.println("Printing automatically");
        printAllStudentInfo();
        System.out.println('\n');
        System.out.println("Printing by searching...");
        Student expectedStudent = getStudentByRoll(16101142);
        if (expectedStudent == null) {
            System.out.println("Didn't find any student by the given ID");
            return;
        } else {
            System.out.println(expectedStudent.toString());
        }

    }
}