package InterfacesAndAbstraction.CarShop;

import java.io.Serializable;

public interface Car extends Serializable {

    int tires = 4;

    String getModel();

    String getColor();

    int getHorsePower();

    String getCountryProduced();


}
