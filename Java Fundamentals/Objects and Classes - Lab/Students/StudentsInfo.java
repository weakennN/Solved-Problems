package ObjectsAndClasses;

public class StudentsInfo {

    private String firstName;
    private String lastName;
    private int age;
    private String home;


    public StudentsInfo(String firstName, String lastName, int age, String home) {

        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.home = home;
    }

    public String getHome() {
        return this.home;
    }

    public String getFirstName() {
        return this.firstName;
    }

    public String getLastName() {
        return this.lastName;
    }

    public int getAge() {
        return this.age;
    }
}
