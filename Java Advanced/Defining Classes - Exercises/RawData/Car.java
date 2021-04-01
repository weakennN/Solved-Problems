package MoreClasses.RawData;

public class Car {

    private String model;
    private Engine engine;
    private Cargo cargo;
    private Tire[] tire;

    public Car(String model, Engine engine, Cargo cargo, Tire[] tire) {

        this.model = model;
        this.engine = engine;
        this.cargo = cargo;
        this.tire = tire;
    }

    public Cargo getCargo() {
        return this.cargo;
    }

    public String getModel() {
        return this.model;
    }

    public Tire[] getTires() {
        return this.tire;
    }

    public Engine getEngine() {
        return engine;
    }

    public boolean isPressureBelow1() {

        for (int j = 0; j < tire.length; j++) {

            if (tire[j].getTirePressure() < 1) {
                return true;
            }
        }
        return false;
    }
}
