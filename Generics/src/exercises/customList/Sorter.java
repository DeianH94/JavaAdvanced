package exercises.customList;

public class Sorter {
    public static <T extends Comparable<T>> void sort(CustomList<T> list) {
        T temp;
        for (int i = 1; i < list.size(); i++) {
            for (int j = i; j > 0; j--) {
                if (list.get(j).compareTo(list.get(j - 1)) < 0) {
                    temp = list.get(j);
                    list.set(j, list.get(j - 1));
                    list.set(j - 1, temp);
                }
            }
        }
    }
}
