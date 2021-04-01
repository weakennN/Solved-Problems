package MoreClasses.Google;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        Map<String, Person> person = new LinkedHashMap<>();

        String command = scan.nextLine();

        while (!command.equals("End")) {

            String[] info = command.split("\\s+");

            String name = info[0];
            String typeClass = info[1];

            Person currentPerson;

            if (!person.containsKey(name)) {
                currentPerson = new Person(name);
            } else {
                currentPerson = person.get(name);
            }

            if (typeClass.equals("company")) {
                addCompany(currentPerson, person, info);

            } else if (typeClass.equals("car")) {
                addCar(currentPerson, person, info);

            } else if (typeClass.equals("pokemon")) {
                addPokemon(currentPerson, person, info);

            } else if (typeClass.equals("parents")) {
                addParents(currentPerson, person, info);

            } else if (typeClass.equals("children")) {
                addChildren(currentPerson, person, info);

            }

            command = scan.nextLine();
        }

        command = scan.nextLine();
        if (person.containsKey(command)) {
            System.out.println(command);
            System.out.println(person.get(command).toString());
        }
    }

    public static void fill(Person currentPerson, Map<String, Person> person, String key) {

        person.put(key, currentPerson);
    }

    public static void addCompany(Person currentPerson, Map<String, Person> person, String[] info) {
        String name = info[0];
        String companyName = info[2];
        String position = info[3];
        String salary = info[4];
        Company company = new Company(companyName, position, salary);
        currentPerson.setCompany(company);
        fill(currentPerson, person, name);
    }

    public static void addCar(Person currentPerson, Map<String, Person> person, String[] info) {
        String name = info[0];
        String carModel = info[2];
        String carSpeed = info[3];
        Car car = new Car(carModel, carSpeed);
        currentPerson.setCar(car);
        fill(currentPerson, person, name);

    }

    public static void addPokemon(Person currentPerson, Map<String, Person> person, String[] info) {
        String name = info[0];
        String pokemonName = info[2];
        String pokemonType = info[3];
        Pokemon pokemon = new Pokemon(pokemonName, pokemonType);
        if (currentPerson.getPokemon().size() > 1 || currentPerson.getPokemon().get(0).getType().length() > 0) {
            List<Pokemon> a = person.get(name).getPokemon();
            a.add(pokemon);
        } else {
            List<Pokemon> a = new ArrayList<>();
            a.add(pokemon);
            currentPerson.setPokemon(a);
            fill(currentPerson, person, name);
        }
    }

    public static void addParents(Person currentPerson, Map<String, Person> person, String[] info) {
        String name = info[0];
        String parentName = info[2];
        String parentBirthDay = info[3];
        Parent parent = new Parent(parentName, parentBirthDay);

        if (currentPerson.getParents().size() > 1 || currentPerson.getParents().get(0).getName().length() > 0) {
            List<Parent> parents = person.get(name).getParents();
            parents.add(parent);
        } else {
            List<Parent> parents = new ArrayList<>();
            parents.add(parent);
            currentPerson.setParents(parents);
            fill(currentPerson, person, name);
        }
    }

    public static void addChildren(Person currentPerson, Map<String, Person> person, String[] info) {
        String name = info[0];
        String childName = info[2];
        String childBirthDay = info[3];

        Childrens child = new Childrens(childName, childBirthDay);

        if (currentPerson.getChildrens().size() > 1 || currentPerson.getChildrens().get(0).getName().length() > 0) {

            List<Childrens> childrens = person.get(name).getChildrens();
            childrens.add(child);
        } else {
            List<Childrens> childrens = new ArrayList<>();
            childrens.add(child);
            currentPerson.setChildrens(childrens);
            fill(currentPerson, person, name);
        }
    }

}
