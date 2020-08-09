package exercises.carSalesman;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Engine> engines = new ArrayList<>();
        List<Car> cars = new ArrayList<>();

        int numOfEngines = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < numOfEngines; i++) {
            Engine engine;
            String[] engineParams = scanner.nextLine().split("\\s+");
            String engineModel = engineParams[0];
            int enginePower = Integer.parseInt(engineParams[1]);
            if (engineParams.length == 4) {
                int engineDisplacement = Integer.parseInt(engineParams[2]);
                String engineEfficiency = engineParams[3];
                engine = new Engine(engineModel, enginePower, engineDisplacement, engineEfficiency);
            } else if (engineParams.length == 3) {
                if (isNumeric(engineParams[2])) {
                    int engineDisplacement = Integer.parseInt(engineParams[2]);
                    engine = new Engine(engineModel, enginePower, engineDisplacement);
                } else {
                    String engineEfficiency = engineParams[2];
                    engine = new Engine(engineModel, enginePower, engineEfficiency);
                }
            } else {
                engine = new Engine(engineModel, enginePower);
            }

            engines.add(engine);
        }

        int numOfCars = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < numOfCars; i++) {
            String[] carParams = scanner.nextLine().split("\\s+");
            Car car;
            String carModel = carParams[0];
            String engineModel = carParams[1];
            Engine engineOfCarModel = null;
            for (Engine engine : engines) {
                if (engine.getModel().equals(engineModel)) {
                    engineOfCarModel = engine;
                }
            }

            if (carParams.length == 4) {
                int carWeight = Integer.parseInt(carParams[2]);
                String carColor = carParams[3];
                car = new Car(carModel, engineOfCarModel, carWeight, carColor);
            } else if (carParams.length == 3) {
                if (isNumeric(carParams[2])) {
                    int carWeight = Integer.parseInt(carParams[2]);
                    car = new Car(carModel, engineOfCarModel, carWeight);
                } else {
                    String carColor = carParams[2];
                    car = new Car(carModel, engineOfCarModel, carColor);
                }
            } else {
                car = new Car(carModel, engineOfCarModel);
            }

            cars.add(car);
        }

        cars.forEach(System.out::println);
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
