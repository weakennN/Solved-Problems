package Encapsulation.SortByNameAndAge;


public class Person1 {

    private String firstName;
    private String lastName;
    private int age;
    private double salary;

    public Person1(String firstName, String lastName, int age, double salary) {

        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.salary = salary;

    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public double getSalary() {
        return salary;
    }

    public String getFirstName() {
        return firstName;
    }

    public int getAge() {
        return age;
    }

    @Override
    public String toString() {

        return String.format("%s %s gets %f leva.", this.firstName, this.lastName, this.salary);
    }

    public void increaseSalary(double bonus) {

        if (this.age < 30) {
            bonus /= 2;
        }

        this.salary *= (1 + bonus);
    }
}
