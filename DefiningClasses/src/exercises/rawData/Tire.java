package exercises.rawData;

public class Tire {
    private double pressure;
    private int age;

    public Tire(double pressure, int age) {
        this.setPressure(pressure);
        this.setAge(age);
    }

    public double getPressure() {
        return this.pressure;
    }

    public void setPressure(double pressure) {
        this.pressure = pressure;
    }

    public int getAge() {
        return this.age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
