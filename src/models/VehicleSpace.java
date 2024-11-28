package models;

import enums.VehicleType;

public class VehicleSpace {
    private int spaceNumber;
    private boolean available;
    private Vehicle vehicle;
    private VehicleType allowedType;

    public VehicleSpace(int spaceNumber, VehicleType allowedType){
        this.spaceNumber=spaceNumber;
        this.available=true;
        this.allowedType=allowedType;
    }

    public boolean isAvailable(){
        return available;
    }

    public void parkVehicle(Vehicle vehicle){
        this.vehicle=vehicle;
        this.available=false;
    }

    public void removeVehicle(){
        this.vehicle=null;
        this.available=true;
    }

    public Vehicle getVehicle(){
        return vehicle;
    }

    public VehicleType getAllowedType(){
        return allowedType;
    }

    @Override
    public String toString(){
        return available?"Available":vehicle.toString();
    }
}
