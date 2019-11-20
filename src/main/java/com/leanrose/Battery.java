package com.leanrose;

public class Battery {

    public String type;

    public int usages;

    public int quality;

    public Battery(String type, int usages, int quality) {
        this.type = type;
        this.usages = usages;
        this.quality = quality;
    }

    @Override
    public String toString() {
        return this.type + ", " + this.usages + ", " + this.quality;
    }
}
