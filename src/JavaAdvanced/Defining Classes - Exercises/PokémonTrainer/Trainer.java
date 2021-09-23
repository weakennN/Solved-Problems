package MoreClasses.PokémonTrainer;

import java.util.List;

public class Trainer {

    private String name;
    private int numberOfBadges;
    private List<Pokemon> pokemons;

    public Trainer(String name, List<Pokemon> pokemons) {

        this.name = name;
        this.pokemons = pokemons;

    }

    public boolean have(String element) {

        for (int i = 0; i < pokemons.size(); i++) {

            if (pokemons.get(i).getElement().equals(element)) {
                this.numberOfBadges += 1;
                return true;
            }
        }

        for (int i = 0; i < pokemons.size(); i++) {

            pokemons.get(i).setHealth(pokemons.get(i).getHealth() - 10);
            if (pokemons.get(i).getHealth() <= 0) {
                this.pokemons.remove(i);
            }
        }

        return false;


    }

    public List<Pokemon> getPokemons() {
        return this.pokemons;
    }

    public String getName() {
        return this.name;
    }

    public int getNumberOfBadges() {
        return this.numberOfBadges;
    }

}
