package exercises.google;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, Person> peopleMap = new HashMap<>();

        String[] personParams = scanner.nextLine().split("\\s+");
        while (!personParams[0].equalsIgnoreCase("end")) {
            String personName = personParams[0];
            if (!peopleMap.containsKey(personName)) {
                Person person = new Person(personName);
                peopleMap.put(personName, person);
            }

            String dataType = personParams[1];
            switch (dataType.toLowerCase()) {
                case "company":
                    String companyName = personParams[2];
                    String position = personParams[3];
                    double salary = Double.parseDouble(personParams[4]);
                    Company company = new Company(companyName, position, salary);
                    peopleMap.get(personName).setCompany(company);
                    break;
                case "car":
                    String model = personParams[2];
                    int speed = Integer.parseInt(personParams[3]);
                    Car car = new Car(model, speed);
                    peopleMap.get(personName).setCar(car);
                    break;
                case "pokemon":
                    String pokemonName = personParams[2];
                    String pokemonType = personParams[3];
                    Pokemon pokemon = new Pokemon(pokemonName, pokemonType);
                    peopleMap.get(personName).addPokemon(pokemon);
                    break;
                case "parents":
                    String parentName = personParams[2];
                    String parentBirthday = personParams[3];
                    Parent parent = new Parent(parentName, parentBirthday);
                    peopleMap.get(personName).addParent(parent);
                    break;
                case "children":
                    String childName = personParams[2];
                    String childBirthDay = personParams[3];
                    Child child = new Child(childName, childBirthDay);
                    peopleMap.get(personName).addChild(child);
                    break;
            }

            personParams = scanner.nextLine().split("\\s+");
        }

        String personToFind = scanner.nextLine();
        System.out.println(peopleMap.get(personToFind));
    }
}
