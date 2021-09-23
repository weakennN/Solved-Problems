package InterfacesAndAbstraction.CarShop;

public class Seat extends CarImpl implements Sellable {

    private double price;

    public Seat(String model, String color, int horsePower, String countryProduced, double price) {
        super(model, color, horsePower, countryProduced);

        this.price = price;
    }

    @Override
    public String toString(){

        return String.format("This is %s produced in %s and have %d tires", super.getModel(), super.getCountryProduced(), tires);
    }

    @Override
    public double getPrice() {
        return this.price;
    }
}
