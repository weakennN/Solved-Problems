package Encapsulation.PizzaCalories;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        Pizza pizza = new Pizza("piz", 10);
        pizza.getOverallCalories();
   /*     String[] piza = scan.nextLine().split("\\s+");

        int numberOfToppings = Integer.parseInt(piza[2]);

        Pizza pizza = new Pizza(piza[1], numberOfToppings);

        String[] doughInfo = scan.nextLine().split("\\s+");

        double doughWeight = Double.parseDouble(doughInfo[3]);

        Dough dough = new Dough(doughInfo[1], doughInfo[2], doughWeight);
        pizza.setDough(dough);
        String command = scan.nextLine();

        while (!command.equals("END")) {

            String[] tokens = command.split("\\s+");

            String toppingType = tokens[1];
            double toppingWeight = Double.parseDouble(tokens[2]);

            Topping topping = new Topping(toppingType, toppingWeight);
            pizza.addTopping(topping);
            command = scan.nextLine();
        }

        System.out.printf("%s - %.2f", pizza.getName(), pizza.getOverallCalories());

    */

    }
}
