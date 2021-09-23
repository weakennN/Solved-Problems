package Polymorphism.Vehicles;

public class Truck extends Vehicle {

    public Truck(double fuel, double fuelConsumation,double tankCapacity) {
        super(fuel, fuelConsumation + 1.6,tankCapacity);
    }

    @Override
    public void refuel(double litters) {

        double accLitters = litters * 0.95;

        super.refuel(accLitters);
    }

}
