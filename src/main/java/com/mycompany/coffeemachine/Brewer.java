package com.mycompany.coffeemachine;

public class Brewer {
    private int waterAmount;
    private int groundCoffee;

    public Brewer(int waterAmount, int groundCoffee) {
        this.waterAmount = waterAmount;
        this.groundCoffee = groundCoffee;
    }

    public Coffeecup brew(CoffeeType coffeeType, int size) throws CoffeExp {
        int coffeeAmount = coffeeType.getBeansAmount(size);
        if (coffeeAmount > groundCoffee) {
            throw new CoffeExp("Not enough ground coffee to brew");
        }

        int waterPerCup = coffeeType.getWaterAmount(size);
        int cups = waterAmount / waterPerCup;

        if (cups == 0) {
            throw new CoffeExp("Not enough water to brew");
        }

        Coffeecup coffee = new Coffeecup(size, coffeeType);
        groundCoffee -= coffeeAmount;
        waterAmount -= cups * waterPerCup;

        return coffee;
    }
}
