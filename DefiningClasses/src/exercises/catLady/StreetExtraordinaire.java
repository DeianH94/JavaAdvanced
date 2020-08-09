package exercises.catLady;

public class StreetExtraordinaire extends Cat {
    private double decibels;

    public StreetExtraordinaire(String name, double decibels) {
        super(name);
        this.setDecibels(decibels);
    }

    public double getDecibels() {
        return this.decibels;
    }

    private void setDecibels(double decibels) {
        this.decibels = decibels;
    }

    @Override
    public String toString() {
        return String.format("%s %s %.2f", this.getClass().getSimpleName(), this.getName(), this.getDecibels());
    }
}
