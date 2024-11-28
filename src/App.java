import model.ParkingLot;
import strategies.FlatRateCostStrategy;

public class App {
    public static void main(String[] args)  {
      ParkingLot parkingLot = new ParkingLot();
        
        // Initialize the parking lot
        parkingLot.init(2, 10); // 2 floors, 10 spaces per floor

        // Configure cost strategy
        parkingLot.configureCostStrategy(new FlatRateCostStrategy());

        // Adding vehicles
        System.out.println(parkingLot.addVehicle("CAR", "ABC123", "Blue"));
        System.out.println(parkingLot.addVehicle("CAR", "XYZ456", "Red"));

        // Display status
        parkingLot.displayStatus();

        // Remove a vehicle
        System.out.println(parkingLot.removeVehicle("ABC123"));

        // Display status again
        parkingLot.displayStatus();
    }
}
