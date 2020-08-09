package lab;

import java.util.NoSuchElementException;
import java.util.function.Consumer;

public class DoublyLinkedList<T> {
    private class ListNode {
        private T item;
        private ListNode next;
        private ListNode previous;


        public ListNode(T item) {
            this.item = item;
        }
    }

    private ListNode head;
    private ListNode tail;
    private int size;

    public void addFirst(T element) {
        ListNode newHead = new ListNode(element);
        if (this.size == 0) {
            this.head = this.tail = newHead;
        } else {
            newHead.next = this.head;
            this.head.previous = newHead;
            this.head = newHead;
        }

        this.size++;
    }

    public void addLast(T element) {
        ListNode newTail = new ListNode(element);
        if (this.size == 0) {
            this.head = this.tail = newTail;
        } else {
            newTail.previous = this.tail;
            this.tail.next = newTail;
            this.tail = newTail;
        }

        this.size++;
    }

    private void checkIndex(int index) {
        if (index < 0 || index >= this.size) {
            String message = String.format("Index: %d Size: %d", index, this.size);
            throw new IndexOutOfBoundsException(message);
        }
    }

    public T get(int index) {
        this.checkIndex(index);
        if (index <= this.size / 2) {
            ListNode firstNode = this.head;

            for (int i = 0; i < index; i++) {
                firstNode = firstNode.next;
            }

            return firstNode.item;
        } else {
            ListNode lastNode = this.tail;
            for (int i = this.size - 1; i > index; i--) {
                lastNode = lastNode.previous;
            }

            return lastNode.item;
        }
    }

    private void checkSize() {
        if (this.size <= 0) {
            throw new NoSuchElementException("The list is empty");
        }
    }

    public T removeFirst() {
        this.checkSize();

        T firstItem = this.head.item;
        this.head = this.head.next;

        if (this.head == null) {
            this.tail = null;
        } else {
            this.head.previous = null;
        }

        this.size--;
        return firstItem;
    }

    public T removeLast() {
        this.checkSize();

        T lastItem = this.tail.item;
        this.tail = this.tail.previous;

        if (this.tail == null) {
            this.head = null;
        } else {
            this.tail.previous = null;
        }

        this.size--;
        return lastItem;
    }

    public void forEach(Consumer<T> consumer) {
        ListNode currentNode = this.head;

        while (currentNode != null) {
            consumer.accept(currentNode.item);
            currentNode = currentNode.next;
        }
    }

    public T[] toArray() {
        T[] array = (T[]) new Object[this.size];
        int counter = 0;
        ListNode currentNode = this.head;

        while (currentNode != null) {
            array[counter++]  = currentNode.item;
            currentNode = currentNode.next;
        }

        return array;
    }
}
