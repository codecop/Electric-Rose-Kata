package com.leanrose;

import org.hamcrest.Matcher;

import static org.junit.Assert.assertThat;

public class BatteryAssert {

    private final BatteryGetter batteryGetter;

    public BatteryAssert(BatteryGetter batteryGetter) {
        this.batteryGetter = batteryGetter;
    }

    public void qualityIs(Matcher<Integer> matcher) {
        assertThat(batteryGetter.getBattery().quality, matcher);
    }

    public void usagesAre(Matcher<Integer> matcher) {
        assertThat(batteryGetter.getBattery().usages, matcher);
    }

}
