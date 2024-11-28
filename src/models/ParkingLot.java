package models;

import java.util.ArrayList;
import java.util.List;

import enums.VehicleType;

public class ParkingLot {
    private List<Floor> floors;
    private CostStrategy costStrategy;

    public ParkingLot() {
        floors = new ArrayList<>();
        costStrategy = new CostStrategy();
    }

    public void init(int floorsCount, int spacesPerFloor, VehicleType type) {
        for (int i = 1; i <= floorsCount; i++) {
            floors.add(new Floor(i, spacesPerFloor, type));
        }
    }

    public boolean parkVehicle(Vehicle vehicle) {
        for (Floor floor : floors) {
            if (floor.parkVehicle(vehicle)) {
                return true;
            }
        }
        return false;
    }

    public Vehicle removeVehicle(String registrationNumber) {
        for (Floor floor : floors) {
            Vehicle vehicle = floor.removeVehicle(registrationNumber);
            if (vehicle != null) {
                return vehicle;
            }
        }
        return null;
    }

    public void configureCostStrategy(VehicleType type, int rate) {
        costStrategy.setRate(type, rate);
    }

    public int calculateCost(VehicleType type, int hours) {
        return costStrategy.calculateCost(type, hours);
    }

    public void displayStatus() {
        for (Floor floor : floors) {
            System.out.println(floor);
        }
    }
}
