package ir.freeland.lambda.model;

public class Student implements Comparable<Student> {
    private String fName;
    private String lName;
    private int age;
    private int grade;

    public Student(String fName, String lName, int age, int grade) {
        this.fName = fName;
        this.lName = lName;
        this.age = age;
        this.grade = grade;
    }

    public String getfName() {
        return fName;
    }

    public String getlName() {
        return lName;
    }

    public int getAge() {
        return age;
    }

    public int getGrade() {
        return grade;
    }

    @Override
    public String toString() {
        return "Student{" + "fName='" + fName + '\'' + ", lName='" + lName + '\'' + ", age=" + age
                + ", grade=" + grade + '}';
    }

    @Override
    public int compareTo(Student s) {
        return Integer.compare(this.grade, s.grade);
    }
}
