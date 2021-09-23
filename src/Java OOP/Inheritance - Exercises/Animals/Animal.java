package Inheritance.Animals;

public class Animal {

    private String name;
    private int age;
    private String gender;

    public Animal(String name, int age, String gender) {

        setName(name);
        setAge(age);
        setGender(gender);
    }

    public String produceSound() {
        return "";
    }

    private void setGender(String gender) {

        if (!gender.equals("Male") && !gender.equals("Female")) {

            throw new IllegalArgumentException("Invalid input!");
        }

        this.gender = gender;
    }

    private void setAge(int age) {

        if (age < 0) {

            throw new IllegalArgumentException("Invalid input!");
        }

        this.age = age;
    }

    private void setName(String name) {

        if (name == null || name.isEmpty() || name.trim().isEmpty()) {

            throw new IllegalArgumentException("Invalid input!");
        }

        this.name = name;
    }

    public String getName() {

        return this.name;
    }

    public int getAge() {

        return this.age;
    }

    public String getGender() {

        return this.gender;
    }

    @Override
    public String toString() {

        StringBuilder builder = new StringBuilder();
        builder.append(this.getClass().getSimpleName() + "\n");
        builder.append(String.format("%s %d %s",this.name,this.age,this.gender));
        return builder.toString();
    }
}
