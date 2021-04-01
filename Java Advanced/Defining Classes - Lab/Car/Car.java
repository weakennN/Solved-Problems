package MoreClasses;

import java.util.List;

public class Car {

    private double fuelAmount;
    private double fuelCost;
    private int distanceTraveled;

    public double getFuelAmount() {
        return fuelAmount;
    }

    public double getFuelCost() {
        return fuelCost;
    }

    public int getDistanceTraveled() {
        return distanceTraveled;
    }

    public Car(double fuelAmount, double fuelCost) {

        this.fuelAmount = fuelAmount;
        this.fuelCost = fuelCost;
        this.distanceTraveled = 0;
    }

    public void DriveTheCar(int distance) {

        if ((distance * this.fuelCost) <= fuelAmount) {
            this.fuelAmount -= distance * this.fuelCost;
            distanceTraveled += distance;
        }else {
            System.out.println("Insufficient fuel for the drive");
        }

    }
}
