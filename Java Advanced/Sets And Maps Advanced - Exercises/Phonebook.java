package SetsAntMaps;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Phonebook {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        Map<String, String> phoneBook = new HashMap<>();

        String command = scan.nextLine();

        while (!command.equals("search")) {

            fillTheMap(phoneBook, command);

            command = scan.nextLine();
        }

        command = scan.nextLine();

        while (!command.equals("stop")) {

            printIfExistOrNot(command, phoneBook);

            command = scan.nextLine();
        }
    }

    public static void fillTheMap(Map<String, String> phoneBook, String command) {

        String[] info = command.split("-");

        phoneBook.put(info[0], info[1]);

    }

    public static void printIfExistOrNot(String command, Map<String, String> phoneBook) {

        String name = command;
        if (phoneBook.containsKey(command)) {
            System.out.println(command + " -> " + phoneBook.get(command));
        } else {
            System.out.println("Contact " + name + " does not exist.");
        }

    }
}
