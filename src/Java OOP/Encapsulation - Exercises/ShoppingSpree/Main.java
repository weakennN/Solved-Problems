package Encapsulation.ShoppingSpree;

import java.util.LinkedHashMap;
import java.util.Map;

public class Main {

    public static void main(String[] args) {

    /*    Scanner scan = new Scanner(System.in);
        String[] peopleInput = scan.nextLine().split("[=;]");

        Map<String, Person> people = readPeople(peopleInput);

        String[] productInput = scan.nextLine().split("[=;]");

        Map<String, Product> products = readProducts(productInput);

        String command = scan.nextLine();

        while (!command.equals("END")) {

            String[] tokens = command.split("\\s+");

            String buyer = tokens[0];
            String productToBuy = tokens[1];

            Person person = people.get(buyer);
            Product product = products.get(productToBuy);

            person.buyProduct(product);

            command = scan.nextLine();
        }

        for (Map.Entry<String, Person> entry : people.entrySet()) {

            if (entry.getValue().getProducts().isEmpty()) {
                System.out.printf("%s - Nothing bought%n", entry.getKey());
                continue;
            }

            StringBuilder str = new StringBuilder();
            for (int i = 0; i < entry.getValue().getProducts().size(); i++) {
                str.append(entry.getValue().getProducts().get(i).getName() + ", ");
            }
            str.deleteCharAt(str.lastIndexOf(","));
            System.out.println(entry.getKey() + " - " + str);
        }

     */

    }

    public static Map<String, Person> readPeople(String[] peopleInput) {

        Map<String, Person> people = new LinkedHashMap<>();

        for (int i = 0; i < peopleInput.length; i += 2) {

            String name = peopleInput[i];
            double money = Double.parseDouble((peopleInput[i + 1]));

            Person person = new Person(name, money);
            people.put(name, person);
        }

        return people;
    }

    public static Map<String, Product> readProducts(String[] productInput) {

        Map<String, Product> products = new LinkedHashMap<>();

        for (int i = 0; i < productInput.length; i += 2) {

            String name = productInput[i];
            double cost = Double.parseDouble((productInput[i + 1]));

            Product product = new Product(name, cost);

            products.put(name, product);
        }

        return products;
    }
}
