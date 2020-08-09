package exercises.pokemonTrainer;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, Trainer> trainersMap = new LinkedHashMap<>();

        addTrainerData(scanner, trainersMap);
        tournamentBattle(scanner, trainersMap);

        trainersMap.values()
                .stream()
                .sorted((t1, t2) -> t2.getNumOfBadges() - t1.getNumOfBadges())
                .forEach(System.out::println);
    }

    private static void tournamentBattle(Scanner scanner, Map<String, Trainer> trainersMap) {
        String pokemonElement = scanner.nextLine();
        while (!pokemonElement.equalsIgnoreCase("end")) {
            for (var trainer : trainersMap.values()) {
                boolean foundOne = false;
                for (Pokemon pokemon : trainer.getPokemons()) {
                    if (pokemon.getElement().equalsIgnoreCase(pokemonElement)) {
                        foundOne = true;
                        break;
                    }
                }

                if (foundOne) {
                    trainer.setNumOfBadges(trainer.getNumOfBadges() + 1);
                } else {
                    for (int i = trainer.getPokemons().size() - 1; i >= 0; i--) {
                        trainer.getPokemons().get(i).takeDamage();
                        if (trainer.getPokemons().get(i).getHealth() <= 0) {
                            trainer.removePokemon(trainer.getPokemons().get(i));
                        }
                    }
                }
            }

            pokemonElement = scanner.nextLine();
        }
    }

    private static void addTrainerData(Scanner scanner, Map<String, Trainer> trainersMap) {
        String[] pokemonParams = scanner.nextLine().split("\\s+");
        while (!pokemonParams[0].equalsIgnoreCase("tournament")) {
            String trainerName = pokemonParams[0];
            String pokemonName= pokemonParams[1];
            String pokemonElement = pokemonParams[2];
            int pokemonHealth = Integer.parseInt(pokemonParams[3]);

            if (!trainersMap.containsKey(trainerName)) {
                Trainer trainer = new Trainer(trainerName);
                trainersMap.put(trainerName, trainer);
            }

            Pokemon pokemon = new Pokemon(pokemonName, pokemonElement, pokemonHealth);
            trainersMap.get(trainerName).addPokemon(pokemon);

            pokemonParams = scanner.nextLine().split("\\s+");
        }
    }
}
