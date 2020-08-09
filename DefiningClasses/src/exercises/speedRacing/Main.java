package exercises.speedRacing;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, Car> cars = new LinkedHashMap<>();
        int numOfCars = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < numOfCars; i++) {
            String[] carParams = scanner.nextLine().split("\\s+");
            String model = carParams[0];
            double fuelAmount = Double.parseDouble(carParams[1]);
            double fuelCostPerKm = Double.parseDouble(carParams[2]);
            Car car = new Car(model, fuelAmount, fuelCostPerKm);
            cars.put(model, car);
        }

        String[] driveParams = scanner.nextLine().split("\\s+");
        while (!driveParams[0].equalsIgnoreCase("end")) {
            String model = driveParams[1];
            double amountOfKm = Double.parseDouble(driveParams[2]);
            Car currentCar = cars.get(model);
            if (currentCar.isCarAbleToTravelTheDistance(amountOfKm)) {
                currentCar.setDistanceTraveled(currentCar.getDistanceTraveled() + amountOfKm);
                currentCar.setFuelAmount(currentCar.getFuelAmount() - currentCar.getFuelCostPerKm() * amountOfKm);
            } else {
                System.out.println("Insufficient fuel for the drive");
            }
            driveParams = scanner.nextLine().split("\\s+");
        }

        cars.values().forEach(System.out::println);
    }
}
