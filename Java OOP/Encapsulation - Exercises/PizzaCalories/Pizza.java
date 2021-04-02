package Encapsulation.PizzaCalories;

import java.util.ArrayList;
import java.util.List;

public class Pizza {

    private String name;
    private Dough dough;
    private List<Topping> toppings;


    public Pizza(String name, int numberOfToppings) {

        setName(name);
        setToppings(numberOfToppings);

    }

    private void setName(String name) {

        if (name == null || name.trim().isEmpty() || name.length() > 15 || name.isEmpty()) {
            throw new IllegalArgumentException("Pizza name should be between 1 and 15 symbols.");
        }

        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    private void setToppings(int numberOfToppings) {

        if (numberOfToppings < 0 || numberOfToppings > 10) {
            throw new IllegalArgumentException("Number of toppings should be in range [0..10].");
        }

        this.toppings = new ArrayList<>(numberOfToppings);
    }

    public void setDough(Dough dough) {

        this.dough = dough;
    }

    public void addTopping(Topping topping) {

        toppings.add(topping);
    }

    public double getOverallCalories() {
        int toppingWholeSum = 0;

        for (int i = 0; i < toppings.size(); i++) {
            toppingWholeSum += this.toppings.get(i).calculateCalories();
        }

        return this.dough.calculateCalories() + toppingWholeSum;
    }
}
