package exercises.listyIterator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ListyIterator<T> {
    private static final String EMPTY_COLLECTION_EXCEPTION_MESSAGE = "Invalid Operation!";
    private static final int DEFAULT_INDEX = 0;

    private List<T> collection;
    private int index;

    public ListyIterator(T... strings) {
        this.collection = new ArrayList<>();
        this.index = 0;

        Collections.addAll(this.collection, strings);
    }

    public boolean hasNext() {
        return this.index + 1 < this.collection.size();
    }

    public boolean move() {
        if (hasNext()) {
            this.index++;
            return true;
        }

        return false;
    }

    public void print() {
        if (this.collection.size() == 0) {
            throw new IllegalArgumentException(EMPTY_COLLECTION_EXCEPTION_MESSAGE);
        } else {
            System.out.println(this.collection.get(this.index));
        }
    }
}
