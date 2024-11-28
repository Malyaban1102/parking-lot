import enums.VehicleType;
import models.ParkingLot;
import models.Vehicle;

public class App {
    public static void main(String[] args)  {
       ParkingLot parkingLot = new ParkingLot();

        // Initialize parking lot
        parkingLot.init(2, 2, VehicleType.CAR);
        parkingLot.configureCostStrategy(VehicleType.CAR, 20);

        // Add vehicles
        Vehicle car1 = new Vehicle("ABC123", "Red", VehicleType.CAR);
        Vehicle car2 = new Vehicle("XYZ456", "Blue", VehicleType.CAR);

        parkingLot.parkVehicle(car1);
        parkingLot.parkVehicle(car2);

        // Display status
        parkingLot.displayStatus();

        // Remove vehicle
        parkingLot.removeVehicle("ABC123");

        // Display updated status
        parkingLot.displayStatus();

        // Calculate cost
        int cost = parkingLot.calculateCost(VehicleType.CAR, 5);
        System.out.println("Cost for 5 hours: " + cost);
    }
}
