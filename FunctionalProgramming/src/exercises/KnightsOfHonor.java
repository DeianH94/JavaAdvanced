package exercises;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.function.Consumer;

public class KnightsOfHonor {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String[] strings = reader.readLine().split("\\s+");

        Consumer<String> print = name -> System.out.println("Sir " + name);

        for (String string : strings) {
            print.accept(string);
        }
    }
}
