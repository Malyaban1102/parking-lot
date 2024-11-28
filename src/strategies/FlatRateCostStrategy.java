package strategies;

import java.util.HashMap;
import java.util.Map;

public class FlatRateCostStrategy implements CostStrategy{

    private static final Map<String, Integer> RATES = new HashMap<>();
    static {
        RATES.put("BIKE", 10);
        RATES.put("CAR", 20);
        RATES.put("TRUCK", 30);
    }

    @Override
    public double calculateCost(String vehicleType, long durationMinutes) {
        // TODO Auto-generated method stub
        int rate = RATES.getOrDefault(vehicleType.toUpperCase(), 0);
        return rate * Math.ceil(durationMinutes / 60.0);
    }
    
}
