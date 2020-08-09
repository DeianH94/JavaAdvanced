package exercises.google;

import java.util.ArrayList;
import java.util.List;

public class Person {
    private String name;
    private Company company;
    private Car car;
    private List<Parent> parents;
    private List<Child> children;
    private List<Pokemon> pokemons;

    public Person(String name) {
        this.setName(name);
        this.parents = new ArrayList<>();
        this.children = new ArrayList<>();
        this.pokemons = new ArrayList<>();
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Company getCompany() {
        return this.company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public Car getCar() {
        return this.car;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    public List<Parent> getParents() {
        return this.parents;
    }

    public void addParent(Parent parent) {
        this.parents.add(parent);
    }

    public List<Child> getChildren() {
        return this.children;
    }

    public void addChild(Child child) {
        this.children.add(child);
    }

    public List<Pokemon> getPokemons() {
        return this.pokemons;
    }

    public void addPokemon(Pokemon pokemon) {
        this.pokemons.add(pokemon);
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append(this.getName()).append(System.lineSeparator());
        builder.append("Company:").append(System.lineSeparator());
        if (this.getCompany() != null) {
            builder.append(this.getCompany()).append(System.lineSeparator());
        }

        builder.append("Car:").append(System.lineSeparator());
        if (this.getCar() != null) {
            builder.append(this.getCar()).append(System.lineSeparator());
        }

        builder.append("Pokemon:").append(System.lineSeparator());
        for (int i = 0; i < this.getPokemons().size(); i++) {
            builder.append(this.getPokemons().get(i)).append(System.lineSeparator());
        }

        builder.append("Parents:").append(System.lineSeparator());
        for (int i = 0; i < this.getParents().size(); i++) {
            builder.append(this.getParents().get(i)).append(System.lineSeparator());
        }

        builder.append("Children:").append(System.lineSeparator());
        for (int i = 0; i < this.getChildren().size(); i++) {
            builder.append(this.getChildren().get(i)).append(System.lineSeparator());
        }

        return builder.toString();
    }
}
