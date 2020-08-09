package lab.serializeCustomObject;

import java.io.Serializable;

public class Cube implements Serializable {
    private String color;
    private double width;
    private double height;
    private double depth;

    public Cube(String color, double width, double height, double depth) {
        this.setColor(color);
        this.setWidth(width);
        this.setHeight(height);
        this.setDepth(depth);
    }

    public String getColor() {
        return this.color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public double getWidth() {
        return this.width;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public double getHeight() {
        return this.height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public double getDepth() {
        return this.depth;
    }

    public void setDepth(double depth) {
        this.depth = depth;
    }
}
