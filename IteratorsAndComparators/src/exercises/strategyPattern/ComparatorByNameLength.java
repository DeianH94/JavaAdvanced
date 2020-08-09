package exercises.strategyPattern;

import java.util.Comparator;

public class ComparatorByNameLength implements Comparator<Person> {
    @Override
    public int compare(Person person1, Person person2) {
        int result = Integer.compare(person1.getName().length(), person2.getName().length());
        if (result == 0) {
            result =  Character.compare(person1.getName().toLowerCase().charAt(0),
                    person2.getName().toLowerCase().charAt(0));
        }

        return result;
    }
}
