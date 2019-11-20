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
        Battery battery = new BatteryBuilder().ordinaryBattery().forUsages(3).battery();
        assertThat(battery.usages, is(3));
        // in dynamic language an assert_responds_to is probably enough
    }

    // All batteries have a Quality value
    @Test
    public void shouldHaveQuality() {
        Battery battery = new BatteryBuilder().ordinaryBattery().ofQuality(7);
        assertThat(battery.quality, is(7));
        // in dynamic language an assert_responds_to is probably enough
    }

    @Test
    public void shouldDisplayWithTypeAndValues() {
        Battery battery = new BatteryBuilder().ordinaryBattery().forUsages(3).ofQuality(7);
        assertThat(battery.toString(), is("any ordinary battery, 3, 7"));
    }

}
