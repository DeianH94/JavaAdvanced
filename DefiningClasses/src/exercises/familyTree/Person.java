package exercises.familyTree;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class Person {
    private String name;
    private String birthDate;
    private List<Person> parents;
    private List<Person> children;

    public Person(String name, String birthDate) {
        this.name = name;
        this.birthDate = birthDate;
        this.parents = new ArrayList<>();
        this.children = new ArrayList<>();
    }

    public Person() {
        this.setName("");
        this.setBirthDate("");
        this.parents = new ArrayList<>();
        this.children = new ArrayList<>();
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBirthDate() {
        return this.birthDate;
    }

    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }

    public List<Person> getParents() {
        return this.parents;
    }

    public void addParent(Person person) {
        this.parents.add(person);
    }

    public List<Person> getChildren() {
        return this.children;
    }

    public void addChild(Person person) {
        this.children.add(person);
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append(this.getName()).append(" ").append(this.getBirthDate()).append(System.lineSeparator());
        builder.append("Parents:").append(System.lineSeparator());
        this.getParents().forEach(p -> builder.append(p.getName())
                .append(" ")
                .append(p.getBirthDate())
                .append(System.lineSeparator()));

        builder.append("Children:").append(System.lineSeparator());
        this.getChildren().forEach(c -> builder.append(c.getName())
                .append(" ")
                .append(c.getBirthDate())
                .append(System.lineSeparator()));

        return builder.toString();
    }
}
