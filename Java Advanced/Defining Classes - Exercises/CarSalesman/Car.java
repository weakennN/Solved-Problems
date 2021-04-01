package MoreClasses.CarSalesman;

public class Car {

    private String model;
    private Engine engine;
    private String weight;
    private String color;

    public Car(String model, Engine engine, String weight, String color) {
        this.model = model;
        this.engine = engine;
        this.weight = weight;
        this.color = color;
    }

    public Car(String model, Engine engine, String weight) {
        this(model, engine, "n/a", weight);
    }

    public Car(String model, String color, Engine engine) {
        this(model, engine, color, "n/a");
    }

    public Car(String model, Engine engine) {
        this(model, engine, "n/a", "n/a");
    }

    @Override
    public String toString() {
        return String.format("%s: %n%s: %nPower: %s %nDisplacement: %s%nEfficiency: %s%nWeight: %s%nColor: %s", this.model, this.engine.getModel(), this.engine.getPower(), this.engine.getDisplacement(), this.engine.getEfficiency()
                , this.weight, this.color);

    }
}
