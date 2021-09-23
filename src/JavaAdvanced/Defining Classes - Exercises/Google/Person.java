package MoreClasses.Google;

import java.util.ArrayList;
import java.util.List;

public class Person {

    private String name;
    private Car car;
    private Company company;
    private List<Pokemon> pokemon;
    private List<Childrens> childrens;
    private List<Parent> parents;

    public Person(String name) {
        this.name = name;
        Car car1 = new Car();
        Company company1 = new Company();
        Pokemon pok = new Pokemon();
        List<Pokemon> pokemons1 = new ArrayList<>();
        pokemons1.add(pok);
        Childrens childrens1 = new Childrens();
        List<Childrens> chi = new ArrayList<>();
        chi.add(childrens1);
        Parent parent2 = new Parent();
        List<Parent> par = new ArrayList<>();
        par.add(parent2);

        this.car = car1;
        this.company = company1;
        this.pokemon = pokemons1;
        this.childrens = chi;
        this.parents = par;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public void setPokemon(List<Pokemon> pokemon) {
        this.pokemon = pokemon;
    }

    public void setChildrens(List<Childrens> childrens) {
        this.childrens = childrens;
    }

    public void setParents(List<Parent> parents) {
        this.parents = parents;
    }

    public String getName() {
        return name;
    }

    public Car getCar() {
        return car;
    }

    public Company getCompany() {
        return company;
    }

    public List<Pokemon> getPokemon() {
        return pokemon;
    }

    public List<Childrens> getChildrens() {
        return childrens;
    }

    public List<Parent> getParents() {
        return parents;
    }

    @Override
    public String toString() {

        StringBuilder str = new StringBuilder();

        if (this.company.getCompany().length() > 0) {
            str.append("Company: " + "\n");
            str.append(this.company.getCompany() + " " + this.getCompany().getDepartment() + " " + this.getCompany().getSalary() + "\n");
        } else {
            str.append("Company: " + "\n");
        }

        if (this.car.getModel().length() > 0) {
            str.append("Car: " + "\n");
            str.append(this.car.getModel() + " " + this.car.getSpeed() + "\n");
        } else {
            str.append("Car: " + "\n");
        }
        str.append("Pokemon:" + "\n");
        for (int i = 0; i < this.pokemon.size(); i++) {
            if (pokemon.get(i).getName().length() < 1 || pokemon.get(i).getType().length() < 1) {

                break;
            }
            str.append(this.pokemon.get(i).getName() + " " + this.pokemon.get(i).getType() + "\n");
        }
        str.append("Parents:" + "\n");

        for (int i = 0; i < this.parents.size(); i++) {

            if (this.parents.get(i).getName().length() < 1 || this.parents.get(i).getBirthDay().length() < 1) {

                break;
            }
            str.append(this.parents.get(i).getName() + " " + this.parents.get(i).getBirthDay() + "\n");
        }

        str.append("Children:" + "\n");

        for (int i = 0; i < this.childrens.size(); i++) {

            if (this.childrens.get(i).getName().length() < 1 || this.childrens.get(i).getBirthday().length() < 1) {
                break;
            }
            str.append(this.childrens.get(i).getName() + " " + this.getChildrens().get(i).getBirthday() + "\n");
        }

        return str.toString();
    }
}
