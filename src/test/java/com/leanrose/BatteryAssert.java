package com.leanrose;

import org.hamcrest.Matcher;

import static org.junit.Assert.assertThat;

public class BatteryAssert {

    private final BatteryGetter batteryGetter;

    public BatteryAssert(BatteryGetter batteryGetter) {
        this.batteryGetter = batteryGetter;
    }

    public void chargeIs(Matcher<Integer> matcher) {
        assertThat(batteryGetter.getBattery().charge, matcher);
    }

    public void usagesAre(Matcher<Integer> matcher) {
        assertThat(batteryGetter.getBattery().usages, matcher);
    }

}
