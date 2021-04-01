package IteratorsAndComparators.ComparingObjects;

public class Person implements Comparable<Person> {
    private String name;
    private int age;
    private String town;

    public Person(String name, int age, String town) {

        this.name = name;
        this.age = age;
        this.town = town;

    }

    @Override
    public int compareTo(Person other) {

        if (this.name.compareTo(other.name) == 0 && this.age == other.age && this.town.compareTo(other.town) == 0) {
            return 0;
        }

        return 1;
    }
}
