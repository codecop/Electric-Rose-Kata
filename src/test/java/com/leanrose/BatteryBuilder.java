package com.leanrose;

import com.leanrose.Battery;

public class BatteryBuilder {

    private static final int NEW = 5;
    private static final int EMPTY = 0;

    private String type;
    private int usages = NEW;
    private int charge = 10;

    public BatteryBuilder ordinaryBattery() {
        return battery("an ordinary battery");
    }

    BatteryBuilder battery(String batteryType) {
        type = batteryType;
        return this;
    }

    public BatteryBuilder almostExpired() {
        return withUsages(1);
    }

    public BatteryBuilder justExpired() {
        return withUsages(0);
    }

    public BatteryBuilder expired() {
        return withUsages(-3);
    }

    public BatteryBuilder withUsages(int times) {
        usages = times;
        return this;
    }

    public BatteryBuilder empty() {
        return charged(EMPTY);
    }

    public BatteryBuilder charged(int electricity) {
        charge = electricity;
        return this;
    }

    public Battery build() {
        return new Battery(type, usages, charge);
    }

    public int initialCharge() {
        return charge;
    }

    public BatteryBuilder and() {
        return this;
    }

}
