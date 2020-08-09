package exercises.genericCountMethodString;

import java.util.ArrayList;
import java.util.List;

public class Box<T extends Comparable<T>> {
    private List<T> values;

    public Box() {
        values = new ArrayList<>();
    }

    public void add(T element) {
        this.values.add(element);
    }

    public int countOfGraterElements(T elementToCompare) {
        int count = 0;
        for (T value : this.values) {
            if (elementToCompare.compareTo(value) < 0) {
                count++;
            }
        }

        return count;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < this.values.size(); i++) {
            builder.append(this.values.getClass().getName())
                    .append(": ")
                    .append(this.values)
                    .append(System.lineSeparator());
        }

        return builder.toString();
    }
}
