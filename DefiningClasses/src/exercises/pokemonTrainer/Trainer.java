package exercises.pokemonTrainer;

import java.util.ArrayList;
import java.util.List;

public class Trainer {
    private String name;
    private int numOfBadges;
    private List<Pokemon> pokemons;


    public Trainer(String name) {
        this.setName(name);
        this.setNumOfBadges(0);
        this.pokemons = new ArrayList<>();
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNumOfBadges() {
        return this.numOfBadges;
    }

    public void setNumOfBadges(int numOfBadges) {
        this.numOfBadges = numOfBadges;
    }

    public void addPokemon(Pokemon pokemon) {
        this.pokemons.add(pokemon);
    }

    public void removePokemon(Pokemon pokemon) {
        this.pokemons.remove(pokemon);
    }

    public List<Pokemon> getPokemons() {
        return this.pokemons;
    }

    @Override
    public String toString() {
        return String.format("%s %d %d", this.getName(), this.getNumOfBadges(), this.getPokemons().size());
    }
}
