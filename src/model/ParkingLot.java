package model;

import java.util.ArrayList;
import java.util.List;

import strategies.CostStrategy;

public class ParkingLot {
    private List<Floor> floors;
    private CostStrategy costStrategy;

    public ParkingLot() {
        this.floors = new ArrayList<>();
    }

    public void init(int numberOfFloors, int spacesPerFloor) {
        for (int i = 1; i <= numberOfFloors; i++) {
            floors.add(new Floor(i, spacesPerFloor));
        }
        System.out.println("Initialized parking lot with " + numberOfFloors + " floors.");
    }

    public void configureCostStrategy(CostStrategy strategy) {
        this.costStrategy = strategy;
        System.out.println("Cost strategy configured.");
    }

    public String addVehicle(String type, String registration, String color) {
        for (Floor floor : floors) {
            String token = floor.addVehicle(new Vehicle(type, registration, color));
            if (token != null) {
                return "Vehicle added. Token: " + token;
            }
        }
        return "Parking lot is full for vehicle type: " + type;
    }

    public String removeVehicle(String registration) {
        for (Floor floor : floors) {
            Vehicle vehicle = floor.removeVehicle(registration);
            if (vehicle != null) {
                double cost = costStrategy.calculateCost(vehicle.getType(), vehicle.getParkingDuration());
                return "Vehicle removed. Total cost: " + cost;
            }
        }
        return "Vehicle not found.";
    }

    public void displayStatus() {
        for (Floor floor : floors) {
            floor.displayStatus();
        }
    }
}
