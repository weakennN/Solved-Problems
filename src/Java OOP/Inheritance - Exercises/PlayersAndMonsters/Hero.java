package Inheritance.PlayersAndMonsters;

public class Hero {

    private String username;
    private int level;

    public Hero(String username, int level) {

        this.username = username;
        this.level = level;
    }

    public String getUsername() {

        return this.username;
    }

    public int getLevel() {
        return this.level;
    }

    @Override
    public String toString() {

        String claz = this.getClass().getName().substring(this.getClass().getName().lastIndexOf('.'));

        return String.format("Type: %s Username: %s Level: %s", claz, this.getUsername(), this.getLevel());
    }


}
