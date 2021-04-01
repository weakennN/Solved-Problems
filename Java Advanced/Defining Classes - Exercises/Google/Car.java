package MoreClasses.Google;

public class Car {

    private String model;
    private String speed;

    public Car(String model,String speed){
        this.model = model;
        this.speed = speed;
    }

    public Car(){
        this.model = "";
        this.speed = "";
    }

    public String getModel() {
        return model;
    }

    public String getSpeed() {
        return speed;
    }
}
