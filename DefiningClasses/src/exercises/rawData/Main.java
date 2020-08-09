package exercises.rawData;

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
            String model = carParams[0];
            int engineSpeed = Integer.parseInt(carParams[1]);
            int enginePower = Integer.parseInt(carParams[2]);
            int cargoWeight = Integer.parseInt(carParams[3]);
            String cargoType = carParams[4];
            double tireOnePressure = Double.parseDouble(carParams[5]);
            int tireOneAge = Integer.parseInt(carParams[6]);
            double tireTwoPressure = Double.parseDouble(carParams[7]);
            int tireTwoAge = Integer.parseInt(carParams[8]);
            double tireThreePressure = Double.parseDouble(carParams[9]);
            int tireThreeAge = Integer.parseInt(carParams[10]);
            double tireFourPressure = Double.parseDouble(carParams[11]);
            int tireFourAge = Integer.parseInt(carParams[12]);

            Engine engine = new Engine(engineSpeed, enginePower);
            Cargo cargo = new Cargo(cargoWeight, cargoType);
            Tire tireOne = new Tire(tireOnePressure, tireOneAge);
            Tire tireTwo = new Tire(tireTwoPressure, tireTwoAge);
            Tire tireThree = new Tire(tireThreePressure, tireThreeAge);
            Tire tireFour = new Tire(tireFourPressure, tireFourAge);
            Tire[] tires = new Tire[] {tireOne, tireTwo, tireThree, tireFour};

            Car car = new Car(model, engine, cargo, tires);
            cars.add(car);
        }

        String command= scanner.nextLine();
        if (command.equalsIgnoreCase("flamable")) {
            cars.stream()
                    .filter(c -> c.getCargo().getType().equalsIgnoreCase("flamable"))
                    .filter(c -> c.getEngine().getPower() > 250)
                    .forEach(System.out::println);
        } else if (command.equalsIgnoreCase("fragile")) {
            cars.stream()
                    .filter(c -> c.getCargo().getType().equalsIgnoreCase("fragile"))
                    .filter(c -> {
                        for (Tire tire : c.getTyres()) {
                            if (tire.getPressure() < 1) {
                                return true;
                            }
                        }

                        return false;
                    }).forEach(System.out::println);
        }
    }
}
