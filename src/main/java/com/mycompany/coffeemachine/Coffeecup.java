package com.mycompany.coffeemachine;

public class Coffeecup {
    private CoffeeType coffeeType;
    private int size;

    public Coffeecup(int size, CoffeeType coffeeType) {
        this.size = size;
        this.coffeeType = coffeeType;
    }

    public int getSize() {
        return this.size;
    }

    public String getCoffeeType() {
        return this.coffeeType.getInfo();
    }


    public String getInfo() {
        String info = "";
        info += "Size: " + size + "\n";
        info += coffeeType.getInfo() + "\n";
        return info;
    }
}
