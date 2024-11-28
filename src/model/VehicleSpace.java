package model;

public class VehicleSpace {
    private String spaceNumber;
    private Vehicle vehicle;

    public VehicleSpace(String spaceNumber) {
        this.spaceNumber = spaceNumber;
        this.vehicle = null;
    }

    public boolean isAvailable() {
        return vehicle == null;
    }

    public void assignVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    public Vehicle releaseVehicle() {
        Vehicle temp = this.vehicle;
        this.vehicle = null;
        return temp;
    }

    public String getSpaceNumber() {
        return spaceNumber;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }
}
