package exercises.carSalesman;

public class Engine {
    private String model;
    private int power;
    private int displacement;
    private String efficiency;

    public Engine(String model, int power) {
        this.setModel(model);
        this.setPower(power);
        this.setDisplacement(-1);
        this.setEfficiency("n/a");
    }

    public Engine(String model, int power, int displacement) {
        this(model, power);
        this.setDisplacement(displacement);
    }

    public Engine(String model, int power, String efficiency) {
        this(model, power);
        this.setEfficiency(efficiency);
    }

    public Engine(String model, int power, int displacement, String efficiency) {
        this(model, power);
        this.setDisplacement(displacement);
        this.setEfficiency(efficiency);
    }

    public String getModel() {
        return this.model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getPower() {
        return this.power;
    }

    public void setPower(int power) {
        this.power = power;
    }

    public int getDisplacement() {
        return this.displacement;
    }

    public void setDisplacement(int displacement) {
        this.displacement = displacement;
    }

    public String getEfficiency() {
        return this.efficiency;
    }

    public void setEfficiency(String efficiency) {
        this.efficiency = efficiency;
    }

    @Override
    public String toString() {
        return String.format("%s:%n" +
                "Power: %d%n" +
                "Displacement: %s%n" +
                "Efficiency: %s",
                this.getModel(),
                this.getPower(),
                this.getDisplacement()==-1?"n/a":this.getDisplacement(),
                this.getEfficiency());
    }
}
