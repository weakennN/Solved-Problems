package IteratorsAndComparators.PetClinics;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        Map<String, Clinic> clinics = new LinkedHashMap<>();
        Map<String, Pet> pets = new LinkedHashMap<>();
        int n = Integer.parseInt(scan.nextLine());

        for (int i = 0; i < n; i++) {

            String[] input = scan.nextLine().split("\\s+");

            String command = input[0];

            if (command.equals("Create") && input[1].equals("Clinic")) {
                createClinic(clinics, input);
            } else if (input[1].equals("Pet")) {
                createPet(pets, input);
            } else if (command.equals("Add")) {
                addPet(clinics, pets, input);
            } else if (command.equals("Release")) {
                System.out.println(releasePetFromClinic(clinics, pets, input));
            } else if (command.equals("HasEmptyRooms")) {
                System.out.println(hasEmptyRooms(clinics, input));
            } else if (command.equals("Print")) {

                if (input.length == 3) {
                    printPet(clinics, input[1], Integer.parseInt(input[2]));
                } else {
                    printClinic(clinics, input[1]);
                }
            }

        }
    }

    public static void createClinic(Map<String, Clinic> clinics, String[] input) {
        int clinicCapacity = Integer.parseInt(input[3]);
        String clinicName = input[2];
        if (clinicCapacity % 2 == 0) {
            System.out.println("Invalid Operation");
            return;
        }

        Clinic clinic = new Clinic(clinicCapacity);
        clinics.put(clinicName, clinic);

    }

    public static void createPet(Map<String, Pet> pets, String[] input) {

        String petName = input[2];
        int petAge = Integer.parseInt(input[3]);
        String petKind = input[4];

        Pet newPet = new Pet(petName, petAge, petKind);
        pets.put(petName, newPet);

    }

    public static void addPet(Map<String, Clinic> clinics, Map<String, Pet> pets, String[] input) {
        String petName = input[1];
        if (!pets.containsKey(petName)) {
            System.out.println("Invalid Operation");
            return;
        }

        String clinicName = input[2];

        Clinic clinic = clinics.get(clinicName);
        Pet pet = pets.get(petName);

        System.out.println(clinic.addPet(pet));
    }

    public static boolean releasePetFromClinic(Map<String, Clinic> clinics, Map<String, Pet> pets, String[] input) {

        String clinicToRelease = input[1];

        if (!clinics.containsKey(clinicToRelease)) {
            return false;
        }

        Clinic clinic = clinics.get(clinicToRelease);

        String petName = clinic.release();

        if (petName == null) {
            return false;
        }
        pets.remove(petName);

        return true;
    }

    public static boolean hasEmptyRooms(Map<String, Clinic> clinics, String[] input) {

        String checkClinic = input[1];

        Clinic clinic = clinics.get(checkClinic);

        if (!clinic.hasEmptyRooms()) {
            return true;
        }

        return false;
    }

    public static void printClinic(Map<String, Clinic> clinics, String clinicName) {

        Clinic clinic = clinics.get(clinicName);

        for (int i = 0; i < clinic.getPets().length; i++) {
            if (clinic.getPets()[i] == null) {
                System.out.println("Room empty");
            } else {
                System.out.println(clinic.getPets()[i].toString());
            }

        }
    }

    public static void printPet(Map<String, Clinic> clinics, String clinicName, int room) {

        Clinic clinic = clinics.get(clinicName);

        System.out.println(clinic.getPets()[room - 1].toString());
    }
}

