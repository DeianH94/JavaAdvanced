package exercises.carSalesman;

public class Car {
    private String model;
    private Engine engine;
    private int weight;
    private String color;

    public Car(String model, Engine engine) {
        this.setModel(model);
        this.setEngine(engine);
        this.setColor("n/a");
        this.setWeight(-1);
    }

    public Car(String model, Engine engine, int weight) {
        this(model, engine);
        this.setWeight(weight);
    }

    public Car(String model, Engine engine, String color) {
        this(model, engine);
        this.setColor(color);
    }

    public Car(String model, Engine engine, int weight, String color) {
        this(model, engine);
        this.setWeight(weight);
        this.setColor(color);
    }

    public String getModel() {
        return this.model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public Engine getEngine() {
        return this.engine;
    }

    public void setEngine(Engine engine) {
        this.engine = engine;
    }

    public int getWeight() {
        return this.weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public String getColor() {
        return this.color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public String toString() {
        return String.format("%s:%n" +
                "%s%n" +
                "Weight: %s%n" +
                "Color: %s",
                this.getModel() ,
                this.getEngine(),
                this.getWeight()==-1?"n/a":this.getWeight(),
                this.getColor());
    }
}
