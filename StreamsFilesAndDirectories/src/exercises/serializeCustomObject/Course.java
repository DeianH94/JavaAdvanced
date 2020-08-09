package exercises.serializeCustomObject;

import java.io.Serializable;

public class Course implements Serializable {
    private String name;
    private int numOfPeople;

    public Course(String name, int numOfPeople) {
        this.setName(name);
        this.setNumOfPeople(numOfPeople);
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNumOfPeople() {
        return this.numOfPeople;
    }

    public void setNumOfPeople(int numOfPeople) {
        this.numOfPeople = numOfPeople;
    }
}
