package exercises.equalityLogic;

import java.util.Objects;

public class Person implements Comparable<Person> {
    private String name;
    private int age;

    public Person(String name, int age) {
        this.setName(name);
        this.setAge(age);
    }

    public String getName() {
        return this.name;
    }

    private void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return this.age;
    }

    private void setAge(int age) {
        this.age = age;
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }

        if (other.getClass().getSimpleName().equals(Person.class.getSimpleName())) {
            Person otherPerson = (Person) other;
            return this.getName().equals(otherPerson.getName()) && this.getAge() == otherPerson.getAge();
        }

        return false;
    }

    @Override
    public String toString() {
        return this.getName() + " " + this.getAge();
    }

    @Override
    public int compareTo(Person other) {
        int result = this.getName().compareTo(other.getName());
        if (result == 0) {
            result = this.getAge() - other.getAge();
        }

        return result;
    }

    @Override
    public int hashCode() {
        return (this.getName().hashCode() + Integer.hashCode(this.getAge())) * 73;
    }
}
