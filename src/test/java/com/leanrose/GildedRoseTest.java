package com.leanrose;

import org.hamcrest.Matcher;
import org.junit.Test;

import com.leanrose.GildedRose;
import com.leanrose.Battery;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.not;
import static org.hamcrest.number.OrderingComparison.lessThan;

public class GildedRoseTest {

    // After each usage, our system lowers both values (for every battery)
    @Test
    public void shouldDecreaseUsagesOfOrdinaryBattery() {
        int initialUsages = 5;
        create.ordinaryBattery().forUsages(initialUsages).battery();

        updateQuality();

        assertThat.usagesAre(lessThan(initialUsages));
        assertThat.usagesAre(equalTo(initialUsages - 1));
    }

    @Test
    public void shouldDecreaseQualityOfOrdinaryBattery() {
        create.ordinaryBattery().battery();

        updateQuality();

        assertThat.qualityIs(decreasedBy(1));
    }

    // After each usage, our system lowers both values *for every battery*
    // TODO add test that update iterates the whole array of batteries ;-)

    // Once the sell by date has passed, Quality degrades twice as fast
    @Test
    public void shouldDecreaseQualityOfExpiredOrdinaryBatteryTwiceAsFast() {
        int initialQuality = 13;
        create.expired().ordinaryBattery().ofQuality(initialQuality);

        updateQuality();

        assertThat.qualityIs(equalTo(initialQuality - 2));
    }

    // boundary
    @Test
    public void shouldDecreaseQualityOfOrdinaryBatteryOnUsageStillByOne() {
        int initialQuality = 9;
        create.almostExpired().ordinaryBattery().ofQuality(initialQuality);

        updateQuality();

        assertThat.qualityIs(equalTo(initialQuality - 1));
    }

    // boundary
    @Test
    public void shouldDecreaseQualityOfOrdinaryBatteryOnSellDateAlreadyByTwo() {
        int initialQuality = 8;
        create.justExpired().ordinaryBattery().ofQuality(initialQuality);

        updateQuality();

        assertThat.qualityIs(equalTo(initialQuality - 2));
    }

    // The Quality of a battery is never negative
    @Test
    public void shouldNotDecreaseQualityOfOrdinaryBatteryBelowZero() {
        create.ordinaryBattery().ofNoQuality();

        updateQuality();

        assertThat.qualityIs(not(negative()));
    }

    @Test
    public void shouldNotDecreaseQualityOfExpiredOrdinaryBatteryWithNoQualityBelowZero() {
        create.expired().ordinaryBattery().ofNoQuality();

        updateQuality();

        assertThat.qualityIs(not(negative()));
    }

    // boundary
    @Test
    public void shouldNotDecreaseQualityOfExpiredOrdinaryBatteryWithOneQualityBelowZero() {
        create.expired().ordinaryBattery().ofQuality(1);

        updateQuality();

        assertThat.qualityIs(not(negative()));
    }

    // boundary
    @Test
    public void shouldDecreaseQualityOfOrdinaryBatteryDownToZero() {
        create.ordinaryBattery().ofQuality(1);

        updateQuality();

        assertThat.qualityIs(equalTo(0));
    }

    // boundary
    @Test
    public void shouldDecreaseQualityOfExpiredOrdinaryBatteryDownToZero() {
        create.expired().ordinaryBattery().ofQuality(2);

        updateQuality();

        assertThat.qualityIs(equalTo(0));
    }

    // --- infrastructure

    private Battery battery;

    private final BatteryBuilder create = new BatteryBuilder(new BatterySetter() {
        @Override
        public void setBattery(Battery battery) {
            GildedRoseTest.this.battery = battery;
        }
    });

    private void updateQuality() {
        GildedRose gildedRose = new GildedRose(new Battery[] { battery });
        gildedRose.updateQuality();
    }

    private final BatteryAssert assertThat = new BatteryAssert(new BatteryGetter() {
        @Override
        public Battery getBattery() {
            return GildedRoseTest.this.battery;
        }
    });

    private Matcher<Integer> decreasedBy(int number) {
        return increasedBy(-number);
    }

    private Matcher<Integer> negative() {
        return lessThan(0);
    }

    private Matcher<Integer> increasedBy(int number) {
        return equalTo(create.initialQuality() + number);
    }

}
