package model;

import java.util.HashMap;
import java.util.Map;

public class Floor {
    private int floorNumber;
    private Map<String, VehicleSpace> vehicleSpaces;

    public Floor(int floorNumber, int capacity) {
        this.floorNumber = floorNumber;
        this.vehicleSpaces = new HashMap<>();
        for (int i = 1; i <= capacity; i++) {
            vehicleSpaces.put("S" + i, new VehicleSpace("S" + i));
        }
    }

    public String addVehicle(Vehicle vehicle) {
        for (VehicleSpace space : vehicleSpaces.values()) {
            if (space.isAvailable()) {
                space.assignVehicle(vehicle);
                return space.getSpaceNumber();
            }
        }
        return null;
    }

    public Vehicle removeVehicle(String registration) {
        for (VehicleSpace space : vehicleSpaces.values()) {
            if (!space.isAvailable() && space.getVehicle().getRegistrationNumber().equals(registration)) {
                Vehicle vehicle = space.releaseVehicle();
                return vehicle;
            }
        }
        return null;
    }

    public void displayStatus() {
        long occupied = vehicleSpaces.values().stream().filter(space -> !space.isAvailable()).count();
        System.out.println("Floor " + floorNumber + ": " + occupied + " occupied, " +
                (vehicleSpaces.size() - occupied) + " available.");
    }
}
