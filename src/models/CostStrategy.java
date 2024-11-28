package models;

import java.util.HashMap;
import java.util.Map;

import enums.VehicleType;

public class CostStrategy {
    private Map<VehicleType, Integer> rates;

    public CostStrategy() {
        rates = new HashMap<>();
    }

    public void setRate(VehicleType type, int rate) {
        rates.put(type, rate);
    }

    public int calculateCost(VehicleType type, int hours) {
        return rates.getOrDefault(type, 0) * hours;
    }
}
