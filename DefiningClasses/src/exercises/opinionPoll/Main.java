package exercises.opinionPoll;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Person> people = new ArrayList<>();
        int numOfPeople = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < numOfPeople; i++) {
            String[] personParam = scanner.nextLine().split("\\s+");
            String name = personParam[0];
            int age = Integer.parseInt(personParam[1]);
            Person person = new Person(name, age);
            people.add(person);
        }

        people.stream()
                .filter(p -> p.getAge() > 30)
                .sorted(Comparator.comparing(Person::getName))
                .forEach(System.out::println);
    }
}
