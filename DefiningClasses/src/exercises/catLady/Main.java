package exercises.catLady;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Cat> cats = new ArrayList<>();

        String[] catData = scanner.nextLine().split("\\s+");
        while (!catData[0].equalsIgnoreCase("end")) {
            String catType = catData[0];
            String catName = catData[1];
            switch (catType) {
                case "Siamese":
                    double earSize = Double.parseDouble(catData[2]);
                    Cat cat = new Siamese(catName, earSize);
                    cats.add(cat);
                    break;
                case "Cymric":
                    double firLength = Double.parseDouble(catData[2]);
                    cat = new Cymric(catName, firLength);
                    cats.add(cat);
                    break;
                case "StreetExtraordinaire":
                    double decibels = Double.parseDouble(catData[2]);
                    cat = new StreetExtraordinaire(catName, decibels);
                    cats.add(cat);
                    break;
            }

            catData = scanner.nextLine().split("\\s+");
        }

        String catToFind = scanner.nextLine();

        for (Cat cat : cats) {
            if (cat.getName().equals(catToFind)) {
                System.out.println(cat);
                break;
            }
        }
    }
}
