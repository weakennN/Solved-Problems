package Polymorphism.Vehicles;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String[] vehicleInfo = scan.nextLine().split("\\s+");

        double fuel = Double.parseDouble(vehicleInfo[1]);
        double fuelConsume = Double.parseDouble(vehicleInfo[2]);
        double tankCapacity = Double.parseDouble(vehicleInfo[3]);

        vehicleInfo = scan.nextLine().split("\\s+");

        Car car = new Car(fuel, fuelConsume, tankCapacity);

        fuel = Double.parseDouble(vehicleInfo[1]);
        fuelConsume = Double.parseDouble(vehicleInfo[2]);
        tankCapacity = Double.parseDouble(vehicleInfo[3]);
        Truck truck = new Truck(fuel, fuelConsume, tankCapacity);

        vehicleInfo = scan.nextLine().split("\\s+");

        fuel = Double.parseDouble(vehicleInfo[1]);
        fuelConsume = Double.parseDouble(vehicleInfo[2]);
        tankCapacity = Double.parseDouble(vehicleInfo[3]);

        Bus bus = new Bus(fuel, fuelConsume, tankCapacity);

        int n = Integer.parseInt(scan.nextLine());

        for (int i = 0; i < n; i++) {

            String[] token = scan.nextLine().split("\\s+");
            double distance = Double.parseDouble(token[2]);
            String command = token[0];

            if (command.equals("Drive")) {

                if (token[1].equals("Car")) {

                    System.out.println("Car " + car.drive(distance));
                } else if (token[1].equals("Truck")) {

                    System.out.println("Truck " + truck.drive(distance));
                } else if (token[1].equals("Bus")) {

                    System.out.println("Bus " + bus.drive(distance));
                }

            } else if (command.equals("Refuel")) {
                try {

                    if (token[1].equals("Car")) {

                        car.refuel(distance);
                    } else if (token[1].equals("Truck")) {

                        truck.refuel(distance);
                    } else if (token[1].equals("Bus")) {

                        bus.refuel(distance);
                    }

                } catch (Exception e) {

                    System.out.println(e.getMessage());
                }

            } else if (command.equals("DriveEmpty")) {

                System.out.println("Bus " + bus.driveWithOutPeople(distance));
            }
        }

        System.out.printf("Car: %.2f%n", car.getFuel());
        System.out.printf("Truck: %.2f%n", truck.getFuel());
        System.out.printf("Bus: %.2f", bus.getFuel());
    }
}
