package Polymorphism.Vehicles;

import java.text.DecimalFormat;

public abstract class Vehicle implements IVehicle {

    private double fuel;
    private double fuelConsumation;
    private double tankCapacity;

    public Vehicle(double fuel, double fuelConsumation, double tankCapacity) {

        this.fuel = fuel;
        this.fuelConsumation = fuelConsumation;
        this.tankCapacity = tankCapacity;
    }

    public double getFuelConsumation() {

        return fuelConsumation;
    }

    public double getFuel() {

        return fuel;
    }

    protected void setFuelConsumation(double fuelConsumation) {

        this.fuelConsumation = fuelConsumation;
    }

    protected void setFuel(double fuel) {

        this.fuel = fuel;
    }


    @Override
    public void refuel(double litters) {

        if (this.fuel + litters > this.tankCapacity) {

            throw new IllegalArgumentException("Cannot fit fuel in tank");
        }else if(litters <= 0){

            throw new IllegalArgumentException("Fuel must be a positive number");
        }


        this.fuel += litters;
    }

    @Override
    public String drive(double distance) {

        DecimalFormat decimalFormat = new DecimalFormat("###.##");

        double needFuel = distance * this.getFuelConsumation();

        if (needFuel > this.getFuel()) {

            return "needs refueling";
        }

        this.setFuel(this.getFuel() - needFuel);

        return "travelled " + decimalFormat.format(distance) + " km";

    }
}
