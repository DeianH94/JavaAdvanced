package exercises.rawData;

public class Engine {
    private int speed;
    private int power;

    public Engine(int speed, int power) {
        this.setSpeed(speed);
        this.setPower(power);
    }

    public int getSpeed() {
        return this.speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public int getPower() {
        return this.power;
    }

    public void setPower(int power) {
        this.power = power;
    }
}
