package exercises.catLady;

public class Cymric extends Cat {
    private double furLength;

    public Cymric(String name, double furLength) {
        super(name);
        this.setFurLength(furLength);
    }

    public double getFurLength() {
        return this.furLength;
    }

    private void setFurLength(double furLength) {
        this.furLength = furLength;
    }

    @Override
    public String toString() {
        return String.format("%s %s %.2f", this.getClass().getSimpleName(), this.getName(), this.getFurLength());
    }
}
