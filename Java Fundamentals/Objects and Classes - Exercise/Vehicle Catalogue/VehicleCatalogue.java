package ObjectsAndClasses;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class VehicleCatalogue {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        List<VehicleCatalogueInfo> vehicles = new ArrayList<>();
        int carPower = 0;
        int truckPower = 0;
        int truckCount = 0;
        int carCount = 0;
        String com = scan.nextLine();

        while (!com.equals("End")) {

            String[] info = com.split(" ");

            int horsePower = Integer.parseInt(info[3]);

            String type = info[0];
            String result = type.substring(0, 1).toUpperCase() + type.substring(1);

            VehicleCatalogueInfo vehicle = new VehicleCatalogueInfo(result, info[1], info[2], horsePower);

            if (info[0].equals("car")) {
                carPower += vehicle.getHorsePower();
                carCount++;
            } else if (info[0].equals("truck")) {
                truckPower += vehicle.getHorsePower();
                truckCount++;
            }

            vehicles.add(vehicle);

            com = scan.nextLine();
        }

        com = scan.nextLine();

        while (!com.equals("Close the Catalogue")) {

            for (int i = 0; i < vehicles.size(); i++) {
                VehicleCatalogueInfo s = vehicles.get(i);

                if (s.getModel().equals(com)) {
                    System.out.println(s);
                }
            }
            com = scan.nextLine();
        }

        double averageCarPower = (double) carPower / carCount;
        double averageTruckPower = (double) truckPower / truckCount;

        if (carCount == 0) {
            averageCarPower = 0;
        } else if (truckCount == 0) {
            averageTruckPower = 0;
        }

        System.out.printf("Cars have average horsepower of: %.2f.%n", averageCarPower);
        System.out.printf("Trucks have average horsepower of: %.2f.", averageTruckPower);
    }
}
