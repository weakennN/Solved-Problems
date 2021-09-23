package Encapsulation.PizzaCalories;

import java.util.List;

public class Topping {

    private String toppingType;
    private double weight;

    public Topping(String toppingType, double weight) {

        setToppingType(toppingType);
        setWeight(weight);
    }

    private void setToppingType(String toppingType) {

        validate(toppingType);

        this.toppingType = toppingType;
    }

    private void setWeight(double weight) {

        if (weight < 1 || weight > 50) {
            throw new IllegalArgumentException(this.toppingType + " weight should be in the range [1..50].");
        }

        this.weight = weight;
    }

    private void validate(String value) {

        List<String> validate = List.of("Meat", "Veggies", "Cheese", "Sauce");

        if (!validate.contains(value)) {
            throw new IllegalArgumentException("Cannot place " + value + " on top of your pizza.");
        }
    }

    public double calculateCalories() {

        double modifier = 0;

        if (this.toppingType.equals("Meat")) {
            modifier = 1.2;
        } else if (this.toppingType.equals("Veggies")) {
            modifier = 0.8;
        } else if (this.toppingType.equals("Cheese")) {
            modifier = 1.1;
        } else if (this.toppingType.equals("Sauce")) {
            modifier = 0.9;
        }


        return (2 * this.weight) * modifier;
    }
}
