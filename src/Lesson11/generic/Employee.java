package Lesson11.generic;

public class Employee extends Person {
    public Employee(int age, String name) {
        super(age, name);
    }

    public Employee(int age, String name, String secondName) {
        super(age, name, secondName);
    }
}
