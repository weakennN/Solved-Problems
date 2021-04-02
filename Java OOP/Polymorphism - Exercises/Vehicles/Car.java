package Polymorphism.Vehicles;

public class Car extends Vehicle {

    public Car(double fuel, double fuelConsumation,double tankCapacity) {
        super(fuel, fuelConsumation + 0.9,tankCapacity);

    }



}
