package SetsAntMaps;


import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;

public class ParkingLot {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String command = scan.nextLine();

        Set<String> parkingSlots = new LinkedHashSet<>();

        while (!command.equals("END")) {

            String[] info = command.split(", ");

            if (info[0].equals("IN")) {

                parkingSlots.add(info[1]);
            } else if (info[0].equals("OUT")) {

                parkingSlots.remove(info[1]);
            }

            command = scan.nextLine();
        }

        if (parkingSlots.isEmpty()){
            System.out.println("Parking Lot is Empty");
            return;
        }

        for (String parkingSlot : parkingSlots) {
            System.out.println(parkingSlot);
        }

    }
}
