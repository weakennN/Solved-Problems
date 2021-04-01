package MoreClasses.CarSalesman;

public class Engine {

    private String model;
    private int power;
    private String displacement;
    private String efficiency;


    public Engine(String model, int power, String displacement, String efficiency) {

        this.model = model;
        this.power = power;
        this.displacement = displacement;
        this.efficiency = efficiency;

    }

    public String getModel() {
        return model;
    }

    public int getPower() {
        return power;
    }

    public String getDisplacement() {
        return displacement;
    }

    public String getEfficiency() {
        return efficiency;
    }

    public Engine(String model, int power, String displacement) {
        this(model, power, displacement, "n/a");
    }

    public Engine(String model, String efficiency, int power) {

        this(model, power, "n/a", efficiency);
    }

    public Engine(String model, int power) {

        this(model, power, "n/a", "n/a");
    }
}
