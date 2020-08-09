package exercises.equalityLogic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Set<Person> treeMap = new TreeSet<>();
        Set<Person> hashSet = new HashSet<>();

        int numOfLines = Integer.parseInt(reader.readLine());
        for (int i = 0; i < numOfLines; i++) {
            String[] params = reader.readLine().split("\\s+");
            String name = params[0];
            int age = Integer.parseInt(params[1]);
            Person person = new Person(name, age);
            treeMap.add(person);
            hashSet.add(person);
        }

        System.out.println(treeMap.size());
        System.out.println(hashSet.size());
    }
}
