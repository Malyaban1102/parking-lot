package models;

import enums.VehicleType;

public class Vehicle {
    private String registrationNumber;
    private String color;
    private VehicleType type;

    public Vehicle(String registrationNumber, String color, VehicleType type){
        this.registrationNumber=registrationNumber;
        this.color=color;
        this.type=type;
    }

    public String getRegistrationNumber(){
        return registrationNumber;
    }

    public VehicleType getType(){
        return type;
    }

    @Override
    public String toString(){
        return String.format("Vehicle[Type=%s,RegNo=%s,Color=%s]",type,registrationNumber,color);
    }
}
