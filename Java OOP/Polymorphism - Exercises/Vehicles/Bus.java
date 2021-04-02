package Polymorphism.Vehicles;

import java.text.DecimalFormat;

public class Bus extends Vehicle {

    public Bus(double fuel, double fuelConsumation, double tankCapacity) {
        super(fuel, fuelConsumation, tankCapacity);
    }

    public String drive(double distance) {

        DecimalFormat decimalFormat = new DecimalFormat("###.##");

        double needFuel = distance * (super.getFuelConsumation() + 1.4);

        if (needFuel > super.getFuel()) {

            return "needs refueling";
        }

        super.setFuel(super.getFuel() - needFuel);

        return "travelled " + decimalFormat.format(distance) + " km";

    }

    public String driveWithOutPeople(double distance) {

        return super.drive(distance);
    }


}
