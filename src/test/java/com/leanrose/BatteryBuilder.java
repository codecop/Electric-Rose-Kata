package com.leanrose;

import com.leanrose.Battery;

public class BatteryBuilder {

    private static class NullSetter implements BatterySetter {
        @Override
        public void setBattery(@SuppressWarnings("unused") Battery battery) {
            // null setter does not do anything
        }
    }

    private static final int NEW = 5;
    private static final int EMPTY = 0;

    private final BatterySetter batterySetter;

    private String type;
    private int usages = NEW;
    private int charge = 10;

    public BatteryBuilder() {
        batterySetter = new NullSetter();
    }

    public BatteryBuilder(BatterySetter batterySetter) {
        this.batterySetter = batterySetter;
    }

    public BatteryBuilder ordinaryBattery() {
        return battery("an ordinary battery");
    }

    BatteryBuilder battery(String batteryType) {
        type = batteryType;
        return this;
    }

    public BatteryBuilder almostExpired() {
        return forUsages(1);
    }

    public BatteryBuilder justExpired() {
        return forUsages(0);
    }

    public BatteryBuilder expired() {
        return forUsages(-3);
    }

    public BatteryBuilder forUsages(int times) {
        usages = times;
        return this;
    }

    public Battery ofCharge(int number) {
        return withCharge(number).battery();
    }

    public Battery ofNoCharge() {
        return withCharge(EMPTY).battery();
    }

    private BatteryBuilder withCharge(int number) {
        charge = number;
        return this;
    }

    public Battery battery() {
        return set(build());
    }

    private Battery build() {
        return new Battery(type, usages, charge);
    }

    private Battery set(Battery battery) {
        batterySetter.setBattery(battery);
        return battery;
    }

    public int initialCharge() {
        return charge;
    }

}
