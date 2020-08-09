package exercises.strategyPattern;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Set;
import java.util.TreeSet;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Set<Person> peopleSortedByName = new TreeSet<>(new ComparatorByNameLength());
        Set<Person> peopleSortedByAge = new TreeSet<>(new ComparatorByAge());

        int numOfLines = Integer.parseInt(reader.readLine());
        for (int i = 0; i < numOfLines; i++) {
            String[] params = reader.readLine().split("\\s+");
            String name = params[0];
            int age = Integer.parseInt(params[1]);
            Person person = new Person(name, age);
            peopleSortedByName.add(person);
            peopleSortedByAge.add(person);
        }

        peopleSortedByName.forEach(System.out::println);
        peopleSortedByAge.forEach(System.out::println);
    }
}
