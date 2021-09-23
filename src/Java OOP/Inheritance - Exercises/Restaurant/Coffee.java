package Inheritance.Restaurant;

import java.math.BigDecimal;

public class Coffee extends HotBeverage {

    private static final double COFFEE_MILLILITERS = 50;
    private static final BigDecimal COFFEE_PRICE = BigDecimal.valueOf(3.50);
    private double caffeine;

    public Coffee(String name, BigDecimal price, double milliliters, double caffeine) {
        super(name, price, milliliters);
        this.caffeine = caffeine;
    }

    public double getCaffeine() {
        return this.caffeine;
    }
}
