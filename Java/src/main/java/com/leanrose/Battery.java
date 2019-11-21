package com.leanrose;

public class Battery {

    public String type;

    public int usages;

    public int charge;

    public Battery(String type, int usages, int charge) {
        this.type = type;
        this.usages = usages;
        this.charge = charge;
    }

    @Override
    public String toString() {
        return this.type + ", " + this.usages + ", " + this.charge;
    }
}
