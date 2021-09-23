package MoreClasses;

public class Employee {
    private String name;
    private double salary;
    private String position;
    private String email;
    private int age;

    public Employee(String name, double salary, String position, String email, int age) {

        this.name = name;
        this.salary = salary;
        this.position = position;
        this.email = email;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public double getSalary() {
        return salary;
    }

    public String getPosition() {
        return position;
    }

    public String getEmail() {
        return email;
    }

    public int getAge() {
        return age;
    }

    public Employee(String name, double salary, String position) {

        this(name, salary, position, "n/a", -1);
    }

    public Employee(String name, double salary, String position, int age) {

        this(name, salary, position, "n/a", age);
    }

    public Employee(String name, double salary, String position, String email) {

        this(name, salary, position, email, -1);
    }

    @Override
    public String toString() {
        return String.format("%s %.2f %s %d",this.name,this.salary,this.email,this.age);
    }
}
