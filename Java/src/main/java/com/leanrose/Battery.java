package com.leanrose;

public class Battery {

    public String type;

    public boolean dry;

    public double charge;

    public Battery(String type, boolean dry, double charge) {
        this.type = type;
        this.dry = dry;
        this.charge = charge;
    }

    @Override
    public String toString() {
        return this.type + ", " + this.dry + ", " + this.charge;
    }
}
