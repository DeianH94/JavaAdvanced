package exercises.rawData;

public class Cargo {
    private int weight;
    private String type;

    public Cargo(int weight, String type) {
        this.setWeight(weight);
        this.setType(type);
    }

    public int getWeight() {
        return this.weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public String getType() {
        return this.type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
