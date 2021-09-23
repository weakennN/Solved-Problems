package MoreClasses.Google;

public class Parent {

    private String name;
    private String birthDay;

    public Parent(String name, String birthDay) {

        this.name = name;
        this.birthDay = birthDay;
    }

    public Parent() {

        this.name = "";
        this.birthDay = "";
    }

    public String getName() {
        return name;
    }

    public String getBirthDay() {
        return birthDay;
    }
}
