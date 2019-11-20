package com.leanrose;

public class Battery {

    public String name;

    public int sellIn;

    public int quality;

    public Battery(String name, int sellIn, int quality) {
        this.name = name;
        this.sellIn = sellIn;
        this.quality = quality;
    }

    @Override
    public String toString() {
        return this.name + ", " + this.sellIn + ", " + this.quality;
    }
}
