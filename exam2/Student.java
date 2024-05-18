package exam2;

import java.io.Serializable;

public class Student implements Serializable {
    private static final long serialVersionUID = 1L;
    private String enrolID;
    private String firstName;
    private String lastName;
    private int age;

    public Student(String enrolID, String firstName, String lastName, int age) {
        this.enrolID = enrolID;
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
    }

    public String getEnrolID() {
        return enrolID;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public int getAge() {
        return age;
    }

    @Override
    public String toString() {
        return String.format("%-10s %-20s %-20s %d", enrolID, firstName + " " + lastName, age);
    }
}
