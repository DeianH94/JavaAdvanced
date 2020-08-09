package exercises.comparingObjects;

public class Person implements Comparable<Person> {
    private String name;
    private int age;
    private String town;

    public Person(String name, int age, String town) {
        this.setName(name);
        this.setAge(age);
        this.setTown(town);
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

    public String getTown() {
        return this.town;
    }

    private void setTown(String town) {
        this.town = town;
    }

    @Override
    public int compareTo(Person p) {
        int result = this.getName().compareTo(p.getName());
        if (result == 0) {
            result = Integer.compare(this.getAge(), p.getAge());
        }

        if (result == 0) {
            result = this.getTown().compareTo(p.getTown());
        }

        return result;
    }
}
