package MoreClasses.CarSalesman;

import java.util.*;

public class Main {


    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        Map<String, Engine> engines = new LinkedHashMap<>();

        List<Car> cars = new ArrayList<>();
        int n = Integer.parseInt(scan.nextLine());

        for (int i = 0; i < n; i++) {

            String[] info = scan.nextLine().split("\\s+");

            String engineType = info[0];
            int power = Integer.parseInt(info[1]);
            Engine engine;
            if (info.length == 4) {

                engine = new Engine(engineType, power, info[2], info[3]);
            } else if (info.length == 2) {
                engine = new Engine(engineType, power);
            } else {

                if (Character.isAlphabetic(info[2].charAt(0))) {
                    engine = new Engine(engineType, info[2], power);
                } else {
                    engine = new Engine(engineType, power, info[2]);
                }
            }

            engines.put(engineType, engine);
        }

        int m = Integer.parseInt(scan.nextLine());

        for (int i = 0; i < m; i++) {

            String[] info = scan.nextLine().split("\\s+");
            String model = info[0];
            String engine = info[1];
            Engine engine1 = engines.get(engine);
            Car car;
            if (info.length == 4) {
                car = new Car(model, engine1, info[2], info[3]);
            } else if (info.length == 2) {
                car = new Car(model, engine1);
            } else {
                if (Character.isAlphabetic(info[2].charAt(0))) {
                    car = new Car(model, engine1, info[2]);
                } else {
                    car = new Car(model, info[2], engine1);
                }
            }

            cars.add(car);
        }

        for (int i = 0; i < cars.size(); i++) {
            Car currentCar = cars.get(i);
            System.out.println(currentCar.toString());
        }
    }
}
