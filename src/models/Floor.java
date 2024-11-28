package models;

import java.util.ArrayList;
import java.util.List;

import enums.VehicleType;

public class Floor {
    private int floorNumber;
    private List<VehicleSpace> spaces;

    public Floor(int floorNumber, int capacity, VehicleType type){
        this.floorNumber=floorNumber;
        spaces=new ArrayList<>();
        for (int i = 1; i <= capacity; i++) {
            spaces.add(new VehicleSpace(i, type));
        }
    }

    public boolean hasSpaceFor(VehicleType type) {
        return spaces.stream().anyMatch(space -> space.isAvailable() && space.getAllowedType() == type);
    }

    public boolean parkVehicle(Vehicle vehicle) {
        for (VehicleSpace space : spaces) {
            if (space.isAvailable() && space.getAllowedType() == vehicle.getType()) {
                space.parkVehicle(vehicle);
                return true;
            }
        }
        return false;
    }

    public Vehicle removeVehicle(String registrationNumber) {
        for (VehicleSpace space : spaces) {
            if (!space.isAvailable() && space.getVehicle().getRegistrationNumber().equals(registrationNumber)) {
                Vehicle vehicle = space.getVehicle();
                space.removeVehicle();
                return vehicle;
            }
        }
        return null;
    }

    @Override
    public String toString() {
        return "Floor " + floorNumber + ": " + spaces;
    }
}
