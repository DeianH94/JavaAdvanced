package exercises.catLady;

public class Cat {
    private String name;

    public Cat(String name) {
        this.setName(name);
    }

    public String getName() {
        return this.name;
    }

    private void setName(String name) {
        this.name = name;
    }
}
