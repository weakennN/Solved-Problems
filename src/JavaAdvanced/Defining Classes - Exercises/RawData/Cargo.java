package MoreClasses.RawData;

public class Cargo {

    private String type;
    private int weight;

    public String getType() {
        return type;
    }

    public int getWeight() {
        return weight;
    }

    public Cargo(String type, int weight) {
        this.type = type;
        this.weight = weight;
    }
}
