package lab;

import java.util.*;

public class AverageStudentsGrades {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<String, List<Double>> students = new TreeMap<>();

        int numOfGrades = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < numOfGrades; i++) {
            String[] gradeData = scanner.nextLine().split("\\s+");
            String studentName = gradeData[0];
            double studentGrade = Double.parseDouble(gradeData[1]);
            students.putIfAbsent(studentName, new ArrayList<>());
            students.get(studentName).add(studentGrade);
        }

        students.forEach((key, value) -> {
            System.out.print(key + " -> ");
            double sum = 0;

            for (double grade : value) {
                sum += grade;
                System.out.printf("%.2f ", grade);
            }

            System.out.print(String.format("(avg: %.2f)%n", sum / value.size()));
        });
    }
}
