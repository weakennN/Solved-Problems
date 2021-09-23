package Inheritance.Animals;

public class Tomcat extends Cat {

    private static final String gender = "Male";

    public Tomcat(String name, int age) {
        super(name, age, gender);
    }

    @Override
    public String produceSound() {
        return "MEOW";
    }

    @Override

    public String toString(){

        StringBuilder builder = new StringBuilder();

        builder.append(this.getClass().getSimpleName() + "\n");
       return builder.toString();
    }
}
