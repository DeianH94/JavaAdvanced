package exercises.catLady;

public class Siamese extends Cat {
    private double earSize;

    public Siamese(String name, double earSize) {
        super(name);
        this.setEarSize(earSize);
    }

    public double getEarSize() {
        return this.earSize;
    }

    private void setEarSize(double earSize) {
        this.earSize = earSize;
    }

    @Override
    public String toString() {
        return String.format("%s %s %.2f", this.getClass().getSimpleName(), this.getName(), this.getEarSize());
    }
}
