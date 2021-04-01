package MoreClasses.PokémonTrainer;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        Map<String, List<Trainer>> trainers = new LinkedHashMap<>();
        String command = scan.nextLine();

        while (!command.equals("Tournament")) {

            String[] info = command.split("\\s+");

            String trainerName = info[0];
            String pokemonName = info[1];
            String element = info[2];
            int health = Integer.parseInt(info[3]);

            Pokemon pokemon = new Pokemon(pokemonName, element, health);
            List<Pokemon> currentPokemon;
            if (!trainers.containsKey(trainerName)) {
                currentPokemon = new ArrayList<>();
                currentPokemon.add(pokemon);
                Trainer trainer = new Trainer(trainerName, currentPokemon);
                List<Trainer> trainers1 = new ArrayList<>();
                trainers1.add(trainer);
                trainers.put(trainerName, trainers1);
            } else {
                currentPokemon = trainers.get(trainerName).get(0).getPokemons();
                currentPokemon.add(pokemon);
            }

            command = scan.nextLine();
        }

        command = scan.nextLine();

        while (!command.equals("End")) {

            for (Map.Entry<String, List<Trainer>> entry : trainers.entrySet()) {

                Trainer currentTrainer = entry.getValue().get(0);

                if (currentTrainer.have(command)) {
                    break;
                }
            }

            command = scan.nextLine();
        }

        for (Map.Entry<String, List<Trainer>> entry : trainers.entrySet()) {

            entry.getValue().stream().sorted((l, r) -> {
                if (r.getNumberOfBadges() == l.getNumberOfBadges()) {
                    return l.getNumberOfBadges();
                }
                return Integer.compare(r.getNumberOfBadges(), l.getNumberOfBadges());
            }).forEach(e -> System.out.printf("%s %d %d%n", entry.getKey(), e.getNumberOfBadges(), e.getPokemons().size()));
        }

    }
}