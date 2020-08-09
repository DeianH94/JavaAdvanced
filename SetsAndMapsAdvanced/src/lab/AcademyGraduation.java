package lab;

import java.text.DecimalFormat;
import java.util.*;
import java.util.stream.Collectors;

public class AcademyGraduation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, List<Double>> graduationList = new TreeMap<>();
        int numOfStudents = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < numOfStudents; i++) {
            String studentName = scanner.nextLine();
            List<Double> grades = Arrays.stream(scanner.nextLine().split("\\s+"))
                            .map(Double::parseDouble)
                            .collect(Collectors.toList());
            graduationList.put(studentName, grades);
        }

        for (var student : graduationList.entrySet()) {
            double averageGrade = 0;
            for (int i = 0; i < student.getValue().size(); i++) {
                averageGrade += student.getValue().get(i);
            }

            averageGrade /= student.getValue().size();
            DecimalFormat format = new DecimalFormat("#.#########################");
            System.out.printf("%s is graduated with %s%n", student.getKey(), format.format(averageGrade));
        }
    }
}
