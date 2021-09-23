package MoreClasses.Google;

public class Pokemon {

    private String name;
    private String type;

    public Pokemon(String name, String type) {

        this.name = name;
        this.type = type;
    }

    public Pokemon() {

        this.name = "";
        this.type = "";
    }

    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }
}
