package InterfacesAndAbstraction.CarShop;

public class CarImpl implements Car {

    private String model;
    private String color;
    private int horsePower;
    private String countryProduced;

    public CarImpl(String model, String color, int horsePower, String countryProduced) {

        this.model = model;
        this.color = color;
        this.horsePower = horsePower;
        this.countryProduced = countryProduced;
    }


    @Override
    public String getModel() {
        return this.model;
    }

    @Override
    public String getColor() {
        return this.color;
    }

    @Override
    public int getHorsePower() {
        return this.horsePower;
    }

    @Override
    public String getCountryProduced() {
        return this.countryProduced;
    }

    @Override
    public String toString() {

        return String.format("%s is %s color and have %s horse power", this.model, this.color, this.horsePower);
    }
}
