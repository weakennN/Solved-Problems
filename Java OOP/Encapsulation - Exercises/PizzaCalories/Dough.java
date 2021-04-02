package Encapsulation.PizzaCalories;

import java.util.List;

public class Dough {

    private String flourType;
    private String bakingTechnique;
    private double weight;

    public Dough(String flourType, String bakingTechnique, double weight) {

        setFlourType(flourType);
        setBakingTechnique(bakingTechnique);
        setWeight(weight);
    }

    private void setFlourType(String flourType) {

        validateDough(flourType);

        this.flourType = flourType;
    }

    private void setBakingTechnique(String bakingTechnique) {

        validateDough(bakingTechnique);

        this.bakingTechnique = bakingTechnique;
    }

    private void setWeight(double weight) {

        if (weight < 1 || weight > 200) {
            throw new IllegalArgumentException("Dough weight should be in the range [1..200].");
        }

        this.weight = weight;
    }

    private void validateDough(String value) {

        List<String> validate = List.of("White", "Wholegrain", "Crispy", "Chewy", "Homemade");

        if (!validate.contains(value)) {

            throw new IllegalArgumentException("Invalid type of dough.");
        }
    }

    public double calculateCalories() {
        double firstModifier = 0;
        double secondModifier = 0;

        if (this.flourType.equals("White")) {
            firstModifier = 1.5;
        } else if (this.flourType.equals("Wholegrain")) {
            firstModifier = 1;
        } else if (this.flourType.equals("Crispy")) {
            firstModifier = 0.9;
        } else if (this.flourType.equals("Chewy")) {
            firstModifier = 1.1;
        } else if (this.flourType.equals("Homemade")) {
            firstModifier = 1;
        }

        if (this.bakingTechnique.equals("White")) {
            secondModifier = 1.5;
        } else if (this.bakingTechnique.equals("Wholegrain")) {
            secondModifier = 1;
        } else if (this.bakingTechnique.equals("Crispy")) {
            secondModifier = 0.9;
        } else if (this.bakingTechnique.equals("Chewy")) {
            secondModifier = 1.1;
        } else if (this.bakingTechnique.equals("Homemade")) {
            secondModifier = 1;
        }

        return (2 * this.weight) * firstModifier * secondModifier;
    }
}
