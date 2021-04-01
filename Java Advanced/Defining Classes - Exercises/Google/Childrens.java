package MoreClasses.Google;

public class Childrens {

    private String name;
    private String birthday;

    public Childrens(String name, String birthday) {

        this.name = name;
        this.birthday = birthday;
    }

    public Childrens() {
        this.name = "";
        this.birthday = "";
    }

    public String getName() {
        return name;
    }

    public String getBirthday() {
        return birthday;
    }
}
