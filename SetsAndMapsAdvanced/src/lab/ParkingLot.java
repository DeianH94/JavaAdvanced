package lab;

import java.util.*;

public class ParkingLot {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Set<String> parkingLot = new LinkedHashSet<>();

        String command = scanner.nextLine();
        while (!command.equalsIgnoreCase("end")) {
            String[] carParams = command.split(",\\s+");
            String direction = carParams[0];
            String licencePlate = carParams[1];

            if (direction.equalsIgnoreCase("in")) {
                parkingLot.add(licencePlate);
            } else if (direction.equalsIgnoreCase("out")) {
                parkingLot.remove(licencePlate);
            }

            command = scanner.nextLine();
        }

        if (parkingLot.isEmpty()) {
            System.out.println("Parking Lot is Empty");
        } else {
            parkingLot.forEach(System.out::println);
        }
    }
}
