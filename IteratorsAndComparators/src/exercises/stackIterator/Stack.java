package exercises.stackIterator;

import java.util.Iterator;
import java.util.function.Consumer;

public class Stack<T> implements Iterable<T> {
    private Node<T> top;

    public Stack() {

    }

    public void push(T element) {
        Node<T> newNode = new Node<>(element);
        newNode.prev = this.top;
        this.top = newNode;
    }

    public T pop() {
        if (this.top == null) {
            throw new IndexOutOfBoundsException("No elements");
        }
        
        T element = this.top.element;
        Node<T> prev = this.top.prev;
        this.top.prev = null;
        this.top = prev;
        return element;
    }

    @Override
    public Iterator<T> iterator() {
        return new StackIterator<>(this.top);
    }

    @Override
    public void forEach(Consumer<? super T> action) {
        for (T element : this) {
            action.accept(element);
        }
    }

    private static class Node<T> {
        T element;
        Node<T> prev;

        public Node(T element) {
            this.element = element;
        }
    }

    private static class StackIterator<T> implements Iterator<T> {

        private Node<T> current;

        StackIterator(Node<T> current) {
            this.current = current;
        }

        @Override
        public boolean hasNext() {
            return this.current != null;
        }

        @Override
        public T next() {
            T element = this.current.element;
            this.current = this.current.prev;
            return element;
        }

        @Override
        public void remove() {

        }
    }
}
