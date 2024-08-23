package ir.freeland.spring.lifecycle.beans;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.beans.factory.BeanNameAware;

public class Student implements BeanNameAware {
    private String name;
    private int studentID;
    private String beanName;


    public Student(String name, int studentID) {
        System.out.println("Instantiation: A new student has been created.");
        this.name = name;
        this.studentID = studentID;
    }

    @Override
    public void setBeanName(String name) {
        System.out.println("BeanNameAware: Setting bean name: " + name);
        this.beanName = name;
    }

    @PostConstruct
    public void init() {
        System.out.println("@PostConstruct: " + getName() + " is preparing for action.");
    }

    @PreDestroy
    public void destroy() {
        System.out
                .println("@PreDestroy: " + getName() + " is saying goodbye and preparing to rest.");
    }

    public String getName() {
        return name;
    }

    public int getStudentID() {
        return studentID;
    }
}
