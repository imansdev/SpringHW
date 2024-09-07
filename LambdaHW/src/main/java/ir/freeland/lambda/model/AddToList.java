package ir.freeland.lambda.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class AddToList {
    Student iman = new Student("imans", "dev", 123, 20);
    Student hasan = new Student("hasan", "hasani", 13, 3);
    Student moji = new Student("mojtaba", "mojtabaee", 12, 12);
    Student ali = new Student("ali", "rabie", 2, 19);
    List<Student> students = new ArrayList<>();

    public void printStudent(List<Student> s) {
        s.forEach(System.out::println);
    }

    public void addStudent() {
        students.add(iman);
        students.add(hasan);
        students.add(moji);
        students.add(ali);
    }

    public List<Student> sortStudents() {
        addStudent();
        return students.stream().sorted().collect(Collectors.toList());
    }

    public List<Student> reverseSortStudents() {
        addStudent();
        return students.stream().sorted(Collections.reverseOrder()).collect(Collectors.toList());
    }

    public void groupStudentsByGradeUpper10() {
        addStudent();
        Map<Boolean, List<Student>> studentsGroup = students.stream()
                .collect(Collectors.groupingBy(student -> ((Student) student).getGrade() > 10));
        System.out.println("above 10");
        printStudent(studentsGroup.get(true));
        System.out.println("under 10");
        printStudent(studentsGroup.get(false));
    }

    public void groupStudentsByAge() {
        addStudent();
        Map<Boolean, List<Student>> studentsGroup = students.stream()
                .collect(Collectors.groupingBy(student -> ((Student) student).getAge() >= 13));
        System.out.println("above 13");
        printStudent(studentsGroup.get(true));
        System.out.println("under 13");
        printStudent(studentsGroup.get(false));
    }

    public void averageGrade() {
        addStudent();
        System.out
                .println(students.stream().collect(Collectors.averagingDouble(Student::getGrade)));
    }

    public void averageGradeAbove18yearsOld() {
        addStudent();
        System.out.println(students.stream().filter(s -> s.getAge() >= 18)
                .collect(Collectors.averagingDouble(Student::getGrade)));

    }
}
