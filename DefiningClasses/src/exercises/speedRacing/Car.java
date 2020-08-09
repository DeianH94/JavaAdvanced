package exercises.speedRacing;

public class Car {
    private String model;
    private double fuelAmount;
    private double fuelCostPerKm;
    private double distanceTraveled;

    public Car(String model, double fuelAmount, double fuelCostPerKm) {
        this.setModel(model);
        this.setFuelAmount(fuelAmount);
        this.setFuelCostPerKm(fuelCostPerKm);
        this.setDistanceTraveled(0);
    }

    public String getModel() {
        return this.model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public double getFuelAmount() {
        return this.fuelAmount;
    }

    public void setFuelAmount(double fuelAmount) {
        this.fuelAmount = fuelAmount;
    }

    public double getFuelCostPerKm() {
        return this.fuelCostPerKm;
    }

    public void setFuelCostPerKm(double fuelCostPerKm) {
        this.fuelCostPerKm = fuelCostPerKm;
    }

    public double getDistanceTraveled() {
        return this.distanceTraveled;
    }

    public void setDistanceTraveled(double distanceTraveled) {
        this.distanceTraveled = distanceTraveled;
    }

    public boolean isCarAbleToTravelTheDistance(double moveAmountOfKm) {
        return this.getFuelAmount() / this.getFuelCostPerKm() >= moveAmountOfKm;
    }

    @Override
    public String toString() {
        return String.format("%s %.2f %.0f", this.getModel(), this.getFuelAmount(), this.getDistanceTraveled());
    }
}
