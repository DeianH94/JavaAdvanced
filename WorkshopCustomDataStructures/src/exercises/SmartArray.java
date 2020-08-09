package exercises;

import java.util.function.Consumer;

public class SmartArray<T> {
    private static final int INITIAL_CAPACITY = 4;
    private T[] data;
    private int size;
    private int capacity;

    public SmartArray() {
        this.data = (T[]) new Object[INITIAL_CAPACITY];
        this.capacity = INITIAL_CAPACITY;
    }

    private void resize() {
        this.capacity *= 2;
        T[] copy = (T[]) new Object[this.capacity];

        System.arraycopy(this.data, 0, copy, 0, this.data.length);
        this.data = copy;
    }

    public void add(T element) {
        if (this.size == this.capacity) {
            this.resize();
        }

        this.data[this.size++] = element;
    }

    private void checkIndex(int index) {
        if (index < 0 || index >= this.size) {
            String message = String.format("Index %d out of bounds for length %d", index, this.size);
            throw new IndexOutOfBoundsException(message);
        }
    }

    public T get(int index) {
        this.checkIndex(index);
        return this.data[index];
    }

    private void shift(int index) {
        for (int i = index; i < this.size - 1; i++) {
            this.data[i] = this.data[i + 1];
        }

        this.data[this.size - 1] = null;
    }

    private void shrink() {
        this.capacity /= 2;
        T[] copy = (T[]) new Object[this.capacity];

        for (int i = 0; i < this.size; i++) {
            copy[i] = this.data[i];
        }

        this.data = copy;
    }

    public T remove(int index) {
        this.checkIndex(index);

        T element = this.data[index];
        this.shift(index);
        this.size--;

        if (this.size <= this.capacity / 4) {
            shrink();
        }

        return element;
    }

    private void shiftRight(int index) {
        for (int i = this.size - 1; i > index; i--) {
            this.data[i] = this.data[i - 1];
        }
    }

    public void add(int index, T element) {
        checkIndex(index);

        if (index == this.size - 1) {
            this.add(this.data[this.size - 1]);
            this.data[this.size - 2] = element;
        } else {
            this.size++;
            this.shiftRight(index);
            this.data[index] = element;
        }
    }

    public boolean contains(T element) {
        for (int i = 0; i < this.size; i++) {
            if (this.data[i].equals(element)) {
                return true;
            }
        }

        return false;
    }

    public void forEach(Consumer<T> consumer) {
        for (int i = 0; i < this.size; i++) {
            consumer.accept(this.data[i]);
        }
    }
}
