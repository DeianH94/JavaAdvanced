package exercises;

import java.util.NoSuchElementException;
import java.util.function.Consumer;

public class CustomStack<T> {
    private static final int INITIAL_CAPACITY = 4;
    private T[] items;
    private int size;
    private int capacity;

    public CustomStack() {
        this.capacity = INITIAL_CAPACITY;
        this.items = (T[]) new Object[this.capacity];
    }

    public int getSize() {
        return this.size;
    }

    private void resize() {
        this.capacity *= 2;
        T[] copy = (T[]) new Object[this.capacity];

        System.arraycopy(this.items, 0, copy, 0, this.items.length);
        this.items = copy;
    }

    public void push(T element) {
        if (this.size == this.capacity) {
            this.resize();
        }

        this.items[this.size++] = element;
    }

    public T pop() {
        this.checkEmpty();

        T element = this.items[this.size - 1];
        this.size--;
        return element;
    }

    private void checkEmpty() {
        if (this.size <= 0) {
            throw new NoSuchElementException("CustomStack is empty");
        }
    }

    public T peek() {
        this.checkEmpty();

        return this.items[this.size - 1];
    }

    public void forEach(Consumer<T> consumer) {
        for (int i = 0; i < this.size; i++) {
            consumer.accept(this.items[i]);
        }
    }
}
