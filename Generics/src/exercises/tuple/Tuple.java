package exercises.tuple;

public class Tuple<T1, T2> {
    private T1 itemOne;
    private T2 itemTwo;

    public Tuple(T1 itemOne, T2 itemTwo) {
        this.setItemOne(itemOne);
        this.setItemTwo(itemTwo);
    }

    public T1 getItemOne() {
        return this.itemOne;
    }

    public void setItemOne(T1 itemOne) {
        this.itemOne = itemOne;
    }

    public T2 getItemTwo() {
        return this.itemTwo;
    }

    public void setItemTwo(T2 itemTwo) {
        this.itemTwo = itemTwo;
    }

    @Override
    public String toString() {
        return String.format("%s -> %s", this.getItemOne(), this.getItemTwo());
    }
}
