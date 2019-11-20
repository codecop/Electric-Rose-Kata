package com.leanrose;

import com.leanrose.Battery;

public class BatteryBuilder {

    private static class NullSetter implements BatterySetter {
        @Override
        public void setBattery(@SuppressWarnings("unused") Battery battery) {
            // null setter does not do anything
        }
    }

    private static final int FRESH = 5;
    private static final int NO_QUALITY = 0;

    private final BatterySetter batterySetter;

    private String type;
    private int usages = FRESH;
    private int quality = 10;

    public BatteryBuilder() {
        batterySetter = new NullSetter();
    }

    public BatteryBuilder(BatterySetter batterySetter) {
        this.batterySetter = batterySetter;
    }

    public BatteryBuilder ordinaryBattery() {
        return battery("any ordinary battery");
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

    public Battery ofQuality(int number) {
        return withQuality(number).battery();
    }

    public Battery ofNoQuality() {
        return withQuality(NO_QUALITY).battery();
    }

    private BatteryBuilder withQuality(int number) {
        quality = number;
        return this;
    }

    public Battery battery() {
        return set(build());
    }

    private Battery build() {
        return new Battery(type, usages, quality);
    }

    private Battery set(Battery battery) {
        batterySetter.setBattery(battery);
        return battery;
    }

    public int initialQuality() {
        return quality;
    }

}
