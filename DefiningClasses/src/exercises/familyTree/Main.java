package exercises.familyTree;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Person> people = new ArrayList<>();
        String mainPersonInfo = scanner.nextLine();
        List<String> fullData = new ArrayList<>();
        List<String> relations = new ArrayList<>();

        String line = scanner.nextLine();
        while (!line.equalsIgnoreCase("end")) {
            if (line.contains("-")) {
                relations.add(line);
            } else {
                fullData.add(line);
            }

            line = scanner.nextLine();
        }

        for (String personData : fullData) {
            String name = personData.substring(0, personData.trim().lastIndexOf(" "));
            String birthDate = personData.substring(personData.trim().lastIndexOf(" ") + 1);
            Person person = new Person();
            person.setName(name);
            person.setBirthDate(birthDate);
            people.add(person);
        }

        for (String relation : relations) {
            String[] peopleParams = relation.split("\\s+-\\s+");
            Person parent = getOrCreatePerson(people, peopleParams[0]);
            Person child = getOrCreatePerson(people, peopleParams[1]);
            parent.addChild(child);
            child.addParent(parent);
        }

        Person personToDisplay;
        if (mainPersonInfo.contains("/")) {
            personToDisplay = people.stream()
                    .filter(p -> p.getBirthDate().equals(mainPersonInfo))
                    .findFirst()
                    .orElse(null);
        } else {
            personToDisplay = people.stream()
                    .filter(p -> p.getName().equals(mainPersonInfo))
                    .findFirst()
                    .orElse(null);
        }

        System.out.println(personToDisplay);
    }

    private static Person getOrCreatePerson(List<Person> people, String personParam) {
        Person person = null;
        if (personParam.contains("/")) {
            boolean birthdayExist = doesBirthdayExist(people, personParam);

            if (!birthdayExist) {
                person = new Person();
                person.setBirthDate(personParam);
                people.add(person);
            } else {
                for (Person p : people) {
                    if (p.getBirthDate().equals(personParam)) {
                        person = p;
                        break;
                    }
                }
            }
        } else {
            boolean nameExists = doesNameExist(people, personParam);

            if (!nameExists) {
                person = new Person();
                person.setName(personParam);
                people.add(person);
            } else {
                for (Person p : people) {
                    if (p.getName().equals(personParam)) {
                        person = p;
                        break;
                    }
                }
            }
        }

        return person;
    }

    private static boolean doesBirthdayExist(List<Person> people, String birthDate) {
        for (Person person : people) {
            if (person.getBirthDate().equals(birthDate)) {
                return true;
            }
        }

        return false;
    }

    private static boolean doesNameExist(List<Person> people, String name) {
        for (Person person : people) {
            if (person.getName().equals(name)) {
                return true;
            }
        }

        return false;
    }
}
