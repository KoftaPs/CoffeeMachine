
package com.mycompany.coffeemachine;

public class Grinder {
    private int grindLevel;
    private int groundCoffee;

    public Grinder(int grindLevel) {
        this.grindLevel = grindLevel;
        this.groundCoffee = 0;
    }

    public void grindBeans(int beansAmount) {
        this.groundCoffee = beansAmount / grindLevel;
    }

    public int getGroundCoffee() {
        return groundCoffee;
    }
}
