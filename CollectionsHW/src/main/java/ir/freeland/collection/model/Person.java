package ir.freeland.collection.model;

import java.util.Objects;

public class Person implements Comparable<Person> {

    private String fname;
    private String lname;
    private int age;
    private Address address;

    @Override
    public String toString() {
        return "Person{" + "fname='" + fname + '\'' + ", lname='" + lname + '\'' + ", age=" + age
                + ", address=" + address + '}';
    }

    public Person(String fname, String lname, int age, Address address) {
        this.fname = fname;
        this.lname = lname;
        this.age = age;
        this.address = address;
    }

    public Address getAddress() {
        return address;
    }

    public int getAge() {
        return age;
    }

    public String getFname() {
        return fname;
    }

    public String getLname() {
        return lname;
    }


    @Override
    public int hashCode() {
        return Objects.hash(fname);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Person other = (Person) obj;
        return Objects.equals(fname, other.fname);
    }

    @Override
    public int compareTo(Person o) {
        // TODO Auto-generated method stub
        return 0;
    }
}
