package com.leanrose;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;

import com.leanrose.Battery;

// 3 test cases for battery itself
public class BatteryTest {

    // All batteries have a SellIn value
    @Test
    public void shouldHaveSellIn() {
        Battery battery = new BatteryBuilder().ordinaryBattery().toSellIn(3);
        assertThat(battery.sellIn, is(3));
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
    public void shouldDisplayWithNameAndValues() {
        Battery battery = new BatteryBuilder().ordinaryBattery().withSellIn(3).ofQuality(7);
        assertThat(battery.toString(), is("any ordinary battery, 3, 7"));
    }

}
