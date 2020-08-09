package exercises.comparingObjects;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        List<Person> people = new ArrayList<>();
        String command = reader.readLine();

        while (!command.equalsIgnoreCase("end")) {
            String[] params = command.split("\\s+");
            String name = params[0];
            int age = Integer.parseInt(params[1]);
            String town = params[2];
            Person person = new Person(name, age, town);
            people.add(person);

            command = reader.readLine();
        }

        int index = Integer.parseInt(reader.readLine());
        int numOfEquals = 0;
        int numOfNotEquals = 0;

        if (index >= people.size()) {
            System.out.println("No matches");
        } else {
            for (Person person : people) {
                int result = people.get(index).compareTo(person);
                if (result == 0) {
                    numOfEquals++;
                } else {
                    numOfNotEquals++;
                }
            }

            System.out.printf("%d %d %d%n", numOfEquals, numOfNotEquals, people.size());
        }
    }
}
