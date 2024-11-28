package model;

import java.time.LocalDateTime;

public class Vehicle {
    private String type;
    private String registrationNumber;
    private String color;
    private LocalDateTime entryTime;

    public Vehicle(String type, String registrationNumber, String color) {
        this.type = type;
        this.registrationNumber = registrationNumber;
        this.color = color;
        this.entryTime = LocalDateTime.now();
    }

    public String getType() {
        return type;
    }

    public String getRegistrationNumber() {
        return registrationNumber;
    }

    public long getParkingDuration() {
        return java.time.Duration.between(entryTime, LocalDateTime.now()).toMinutes();
    }
}
