package com.leanrose;

import java.util.function.Supplier;

import org.hamcrest.Matcher;

import static org.junit.Assert.assertThat;

public class BatteryAssert {

    private final Supplier<Battery> batteryGetter;

    public BatteryAssert(Supplier<Battery> batteryGetter) {
        this.batteryGetter = batteryGetter;
    }

    public void chargeIs(Matcher<Integer> matcher) {
        assertThat(batteryGetter.get().charge, matcher);
    }

    public void usagesAre(Matcher<Integer> matcher) {
        assertThat(batteryGetter.get().usages, matcher);
    }

}
