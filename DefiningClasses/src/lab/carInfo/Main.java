package lab.carInfo;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Car> cars = new ArrayList<>();
        int numOfCars = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < numOfCars; i++) {
            String[] carParams = scanner.nextLine().split("\\s+");
            String brand = carParams[0];
            String model = carParams[1];
            int horsepower = Integer.parseInt(carParams[2]);
            Car car = new Car();
            car.setBrand(brand);
            car.setModel(model);
            car.setHorsepower(horsepower);
            cars.add(car);
        }

        for (Car car : cars) {
            System.out.println(car.carInfo());
        }
    }
}
