package com.mycompany.coffeemachine;

import java.util.HashMap;
import java.util.Map;

public class CoffeeMachine {
    private final int WATER_CAPACITY;
    private final int BEANS_CAPACITY;
    public int waterLevel;
    public int beansLevel;
    private boolean isCleaningNeeded;
    private int cupsServedSinceCleaning;
    private final Map<String, CoffeeType> coffeeTypes;

    public CoffeeMachine(int waterCapacity, int beansCapacity) {
        this.WATER_CAPACITY = waterCapacity;
        this.BEANS_CAPACITY = beansCapacity;
        this.waterLevel = waterCapacity;
        this.beansLevel = beansCapacity;
        this.isCleaningNeeded = false;
        this.cupsServedSinceCleaning = 0;
        this.coffeeTypes = new HashMap<>();
        
        this.coffeeTypes.put("Espresso-Single", new CoffeeType(30, 7, "Espresso-Single",80,250));
        this.coffeeTypes.put("Espresso-Double", new CoffeeType(60, 14, "Espresso-Double",160,500));
        this.coffeeTypes.put("Americano-Single", new CoffeeType(170, 7, "Americano-Single",60,150));
        this.coffeeTypes.put("Americano-Double", new CoffeeType(220, 14, "Americano-Double",120,300));
    }

    public String getInfo() {
        String info = "Water Level: " + waterLevel + " ml\n";
        info += "Beans Level: " + beansLevel + " g\n";
        info += "Cleaning Needed: " + isCleaningNeeded + "\n";
        info += "Cups served since cleaning: " + cupsServedSinceCleaning + "\n";
        return info;
    }

    public void fillWater(int waterAmount) throws CoffeExp {
        if (waterLevel + waterAmount > WATER_CAPACITY) {
            throw new CoffeExp("Water level exceeds capacity");
        }
        waterLevel += waterAmount;
    }

    public void fillBeans(int beansAmount) throws CoffeExp {
        if (beansLevel + beansAmount > BEANS_CAPACITY) {
            throw new CoffeExp("Beans level exceeds capacity");
        }
        beansLevel += beansAmount;
    }

    public CoffeeType getCoffeeType(String coffeeType) {
        return coffeeTypes.get(coffeeType);
    }

    public Coffeecup serveCoffee(String coffeeType, int grindLevel, int size) throws CoffeExp {
        CoffeeType selectedCoffee = getCoffeeType(coffeeType);
        if (selectedCoffee == null) {
            throw new CoffeExp("Invalid coffee type selected");
        }
        int waterAmount = selectedCoffee.getWaterAmount(size);
        int beansAmount = selectedCoffee.getBeansAmount(size);
        if (waterLevel < waterAmount || beansLevel < beansAmount) {
            throw new CoffeExp("Insufficient water or beans");
        }
        Grinder grinder = new Grinder(grindLevel);
        grinder.grindBeans(beansAmount);
        Brewer brewer = new Brewer(waterAmount, grinder.getGroundCoffee());
        Coffeecup cup = brewer.brew(selectedCoffee,size);
       
        waterLevel -= waterAmount;
        beansLevel -= beansAmount;
        cupsServedSinceCleaning++;
        if (cupsServedSinceCleaning == 10) {
            isCleaningNeeded = true;
            cupsServedSinceCleaning = 0;
            
        }
        
        return cup;
    }

    public boolean isCleaningNeeded() {
        return isCleaningNeeded;
    }

    public void clean() {
        isCleaningNeeded = false;
       
    }
}
