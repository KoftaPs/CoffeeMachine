
package com.mycompany.coffeemachine;

public class CoffeeType {
    private final int waterAmount;
    private final int beansAmount;
    private final int calories;
    private final int caffeine;
    private final String name;

    public CoffeeType(int waterAmount, int beansAmount, String name,int calories,int caffeine) {
        this.waterAmount = waterAmount;
        this.beansAmount = beansAmount;
        this.calories = calories;
        this.caffeine = caffeine;
        this.name = name;
    }

    public int getWaterAmount(int size) {
        return waterAmount * size;
    }

    public int getBeansAmount(int size) {
        return beansAmount * size;
    }

    public String getName() {
        return name;
    }
    
     public int getCalories() {
        return calories;
    }

    public int getCaffeine() {
        return caffeine;
    }
    public String getInfo() {
    return "Coffee type: " + name + "\nWater amount: " + waterAmount + " ml\nBeans amount: "
            + beansAmount + " g"+"\nCalories: " + calories + "\nCaffeine: " + caffeine + "mg";
    
}

}
