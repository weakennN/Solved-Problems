package MoreClasses.RawData;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        int n = Integer.parseInt(scan.nextLine());
        List<Car> cars = new ArrayList<>();
        for (int i = 0; i < n; i++) {

            String[] info = scan.nextLine().split("\\s+");
            int engineSpeed = Integer.parseInt(info[1]);
            int enginePower = Integer.parseInt(info[2]);
            String cargoType = info[4];
            int cargoWeight = Integer.parseInt(info[3]);
            String model = info[0];

            Engine engine = new Engine(engineSpeed, enginePower);
            Cargo cargo = new Cargo(cargoType, cargoWeight);
            Tire[] tires = new Tire[4];
            int counter = 0;
            for (int j = 5; j < info.length; j += 2) {

                double pressure = Double.parseDouble(info[j]);
                int age = Integer.parseInt(info[j + 1]);
                Tire tire = new Tire(pressure, age);
                tires[counter] = tire;
                counter++;
            }

            Car car = new Car(model, engine, cargo, tires);
            cars.add(car);
        }

        String cargoType = scan.nextLine();

        if (cargoType.equals("fragile")) {
            for (int i = 0; i < cars.size(); i++) {

                Car currentCar = cars.get(i);
                if (currentCar.getCargo().getType().equals(cargoType)) {

                    if (currentCar.isPressureBelow1()) {
                        System.out.println(currentCar.getModel());
                    }
                }
            }
        } else {

            for (int i = 0; i < cars.size(); i++) {

                Car currentCar = cars.get(i);

                if (currentCar.getCargo().getType().equals(cargoType)) {

                    Engine engine = currentCar.getEngine();

                    if (engine.getPower() > 250){
                        System.out.println(currentCar.getModel());
                    }
                }
            }
        }


    }
}
