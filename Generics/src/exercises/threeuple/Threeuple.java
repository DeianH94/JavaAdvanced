package exercises.threeuple;

public class Threeuple<T1, T2, T3> {
    private T1 itemOne;
    private T2 itemTwo;
    private T3 itemThree;

    public Threeuple(T1 itemOne, T2 itemTwo, T3 itemThree) {
        this.setItemOne(itemOne);
        this.setItemTwo(itemTwo);
        this.setItemThree(itemThree);
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

    public T3 getItemThree() {
        return this.itemThree;
    }

    public void setItemThree(T3 itemThree) {
        this.itemThree = itemThree;
    }

    @Override
    public String toString() {
        return String.format("%s -> %s -> %s", this.getItemOne(), this.getItemTwo(), this.getItemThree());
    }
}
