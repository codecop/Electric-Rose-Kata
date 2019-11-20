package com.leanrose;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;

import com.leanrose.Battery;

// 3 test cases for battery itself
public class BatteryTest {

    // All batteries have a Usages value
    @Test
    public void shouldHaveUsages() {
        Battery battery = new BatteryBuilder().ordinaryBattery().withUsages(3).build();
        assertThat(battery.usages, is(3));
        // in dynamic language an assert_responds_to is probably enough
    }

    // All batteries have a Charge value
    @Test
    public void shouldHaveCharge() {
        Battery battery = new BatteryBuilder().ordinaryBattery().charged(7).build();
        assertThat(battery.charge, is(7));
        // in dynamic language an assert_responds_to is probably enough
    }

    @Test
    public void shouldDisplayWithTypeAndValues() {
        Battery battery = new BatteryBuilder().ordinaryBattery().withUsages(3).charged(7).build();
        assertThat(battery.toString(), is("an ordinary battery, 3, 7"));
    }

}
