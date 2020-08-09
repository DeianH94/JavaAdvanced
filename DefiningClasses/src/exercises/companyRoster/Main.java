package exercises.companyRoster;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Department> departments = new ArrayList<>();
        int namOfEmployees = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < namOfEmployees; i++) {
            String[] employeeInfo = scanner.nextLine().split("\\s+");
            String department = employeeInfo[3];

            Employee employee = createEmployee(employeeInfo);

            createDepartmentIfItDoesNotExist(departments, department);

            for (Department singleDepartment : departments) {
                if (singleDepartment.getName().equals(department)) {
                    singleDepartment.addEmployee(employee);
                }
            }
        }

        double highestAverageSalary = 0;
        String highestSalaryDepartmentName = "";
        for (Department department : departments) {
            double averageSalary = 0;
            for (int i = 0; i < department.getEmployees().size(); i++) {
                averageSalary += department.getEmployees().get(i).getSalary();
            }

            averageSalary /= department.getEmployees().size();
            if (averageSalary > highestAverageSalary) {
                highestAverageSalary = averageSalary;
                highestSalaryDepartmentName = department.getName();
            }
        }

        System.out.println("Highest Average Salary: " + highestSalaryDepartmentName);
        for (Department department : departments) {
            if (department.getName().equals(highestSalaryDepartmentName)) {
                department.getEmployees()
                        .stream()
                        .sorted(Comparator.comparing(Employee::getSalary).reversed())
                        .forEach(System.out::println);
                break;
            }
        }
    }

    private static Employee createEmployee(String[] employeeInfo) {
        String name = employeeInfo[0];
        double salary = Double.parseDouble(employeeInfo[1]);
        String position = employeeInfo[2];

        Employee employee;

        if (employeeInfo.length == 6) {
            String email = employeeInfo[4];
            int age = Integer.parseInt(employeeInfo[5]);
            employee = new Employee(name, salary, position, email, age);
        } else if (employeeInfo.length == 5) {
            if (isNumeric(employeeInfo[4])) {
                int age = Integer.parseInt(employeeInfo[4]);
                employee = new Employee(name, salary, position, age);
            } else {
                String email = employeeInfo[4];
                employee = new Employee(name, salary, position, email);
            }

        } else {
            employee = new Employee(name, salary, position);
        }

        return employee;
    }

    private static void createDepartmentIfItDoesNotExist(List<Department> departments, String departmentToCheck) {
        boolean departmentExist = false;
        for (Department department : departments) {
            if (department.getName().equals(departmentToCheck)) {
                departmentExist = true;
                break;
            }
        }

        if (!departmentExist) {
            Department newDepartment = new Department(departmentToCheck);
            departments.add(newDepartment);
        }
    }

    public static boolean isNumeric(String strNum) {
        if (strNum == null) {
            return false;
        }

        try {
            double d = Double.parseDouble(strNum);
        } catch (NumberFormatException nfe) {
            return false;
        }

        return true;
    }
}
