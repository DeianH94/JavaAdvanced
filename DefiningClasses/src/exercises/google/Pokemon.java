package exercises.google;

public class Pokemon {
    private String name;
    private String type;

    public Pokemon(String name, String type) {
        this.setName(name);
        this.setType(type);
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return this.type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return this.getName() + " " + this.getType();
    }
}
