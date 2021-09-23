package ObjectsAndClasses;

public class VehicleCatalogueInfo {

    private String carType;
    private String model;
    private String color;
    private int horsePower;

    public VehicleCatalogueInfo(String carType, String model, String color, int horsePower) {
        this.carType = carType;
        this.model = model;
        this.color = color;
        this.horsePower = horsePower;
    }

    public String getModel() {
        return this.model;
    }

    public String getCarType() {
        return this.carType;
    }

    public int getHorsePower() {
        return this.horsePower;
    }


    @Override
    public String toString() {
        return String.format("Type: %s%nModel: %s%nColor: %s%nHorsepower: %d", this.carType, this.model, this.color, this.horsePower);
    }
}
