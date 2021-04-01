package MoreClasses;

import java.util.*;

public class Cars {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int n = Integer.parseInt(scan.nextLine());

        Map<String, List<Car>> cars = new LinkedHashMap<>();

        for (int i = 0; i < n; i++) {

            String[] info = scan.nextLine().split("\\s+");
            double fuelAmount = Double.parseDouble(info[1]);
            double fuelCost = Double.parseDouble(info[2]);

            Car car = new Car(fuelAmount, fuelCost);

            List<Car> cars1 = new ArrayList<>();
            cars1.add(car);
            cars.put(info[0], cars1);
        }

        String command = scan.nextLine();

        while (!command.equals("End")) {

            String[] info = command.split("\\s+");

            if (info[0].equals("Drive")) {

                int distance = Integer.parseInt(info[2]);
                Car car = cars.get(info[1]).get(0);

                car.DriveTheCar(distance);
            }

            command = scan.nextLine();
        }

        cars.entrySet().stream().forEach(e ->{
            System.out.printf("%s %.2f %d%n",e.getKey(),e.getValue().get(0).getFuelAmount(),e.getValue().get(0).getDistanceTraveled());
        });
    }
}
