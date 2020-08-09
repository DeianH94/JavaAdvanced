package exercises.customList;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class CustomList<T extends Comparable<T>> implements Iterable<T>{
    private List<T> data;

    public CustomList() {
        this.data = new ArrayList<>();
    }

    public void add(T element) {
        this.data.add(element);
    }

    private void checkIndex(int index) {
        if (index < 0 || index >= this.data.size()) {
            String message = String.format("Index %d out of bounds for length %d", index, this.data.size());
            throw new IndexOutOfBoundsException(message);
        }
    }

    public T get(int index) {
        this.checkIndex(index);
        return this.data.get(index);
    }

    public int size() {
        return this.data.size();
    }

    public T remove(int index) {
        this.checkIndex(index);
        return this.data.remove(index);
    }

    public void add(int index, T element) {
        checkIndex(index);
        this.data.add(element);
    }

    public void set(int index, T element) {
        this.data.set(index, element);
    }

    public boolean contains(T element) {
        for (int i = 0; i < this.data.size(); i++) {
            if (this.data.get(i).equals(element)) {
                return true;
            }
        }

        return false;
    }

    public void swap(int firstIndex, int secondIndex) {
        checkIndex(firstIndex);
        checkIndex(secondIndex);

        T temp = this.data.get(firstIndex);
        this.data.set(firstIndex, this.data.get(secondIndex));
        this.data.set(secondIndex, temp);
    }

    public int countGreaterThan(T element) {
        int count = 0;

        for (int i = 0; i < this.data.size(); i++) {
            if (element.compareTo(this.data.get(i)) < 0) {
                count++;
            }
        }

        return count;
    }

    public T getMax() {
        T max = this.data.get(0);
        for (int i = 1; i < this.data.size(); i++) {
            if (max.compareTo(this.data.get(i)) < 0) {
                max = this.data.get(i);
            }
        }

        return max;
    }

    public T getMin() {
        T min = this.data.get(0);
        for (int i = 1; i < this.data.size(); i++) {
            if (min.compareTo(this.data.get(i)) > 0) {
                min = this.data.get(i);
            }
        }

        return min;
    }

    public Iterator<T> iterator() {
        return this.data.iterator();
    }
}
