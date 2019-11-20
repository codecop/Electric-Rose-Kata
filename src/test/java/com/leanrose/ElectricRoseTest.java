package com.leanrose;

import org.hamcrest.Matcher;
import org.junit.Test;

import com.leanrose.ElectricRose;
import com.leanrose.Battery;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.not;
import static org.hamcrest.number.OrderingComparison.lessThan;

public class ElectricRoseTest {

    // After each usage, our system lowers both values (for every battery)
    @Test
    public void shouldDecreaseUsagesOfOrdinaryBattery() {
        int initialUsages = 5;
        create.ordinaryBattery().withUsages(initialUsages);

        updateCharge();

        assertThat.usagesAre(lessThan(initialUsages));
        assertThat.usagesAre(equalTo(initialUsages - 1));
    }

    @Test
    public void shouldDecreaseChargeOfOrdinaryBattery() {
        create.ordinaryBattery();

        updateCharge();

        assertThat.chargeIs(decreasedBy(1));
    }

    // After each usage, our system lowers both values *for every battery*
    // TODO add test that update iterates the whole array of batteries ;-)

    // Once the number of usages has passed, Charge degrades twice as fast
    @Test
    public void shouldDecreaseChargeOfExpiredOrdinaryBatteryTwiceAsFast() {
        int initialCharge = 13;
        create.expired().ordinaryBattery().charged(initialCharge);

        updateCharge();

        assertThat.chargeIs(equalTo(initialCharge - 2));
    }

    // boundary
    @Test
    public void shouldDecreaseChargeOfOrdinaryBatteryOnLastUsageStillByOne() {
        int initialCharge = 9;
        create.almostExpired().ordinaryBattery().charged(initialCharge);

        updateCharge();

        assertThat.chargeIs(equalTo(initialCharge - 1));
    }

    // boundary
    @Test
    public void shouldDecreaseChargeOfOrdinaryBatteryOnZeroUsagesAlreadyByTwo() {
        int initialCharge = 8;
        create.justExpired().ordinaryBattery().charged(initialCharge);

        updateCharge();

        assertThat.chargeIs(equalTo(initialCharge - 2));
    }

    // The Charge of a battery is never negative
    @Test
    public void shouldNotDecreaseChargeOfOrdinaryBatteryBelowZero() {
        create.empty().ordinaryBattery();

        updateCharge();

        assertThat.chargeIs(not(negative()));
    }

    @Test
    public void shouldNotDecreaseChargeOfExpiredEmptyOrdinaryBatteryBelowZero() {
        create.expired().and().empty().ordinaryBattery();

        updateCharge();

        assertThat.chargeIs(not(negative()));
    }

    // boundary
    @Test
    public void shouldNotDecreaseChargeOfExpiredOrdinaryBatteryWithOneChargeBelowZero() {
        create.expired().ordinaryBattery().charged(1);

        updateCharge();

        assertThat.chargeIs(not(negative()));
    }

    // boundary
    @Test
    public void shouldDecreaseChargeOfOrdinaryBatteryDownToZero() {
        create.ordinaryBattery().charged(1);

        updateCharge();

        assertThat.chargeIs(equalTo(0));
    }

    // boundary
    @Test
    public void shouldDecreaseChargeOfExpiredOrdinaryBatteryDownToZero() {
        create.expired().ordinaryBattery().charged(2);

        updateCharge();

        assertThat.chargeIs(equalTo(0));
    }

    // --- infrastructure

    private final BatteryBuilder create = new BatteryBuilder();

    private Battery battery;

    private void updateCharge() {
        battery = create.build();
        ElectricRose electricRose = new ElectricRose(new Battery[] { battery });
        electricRose.updateCharge();
    }

    private final BatteryAssert assertThat = new BatteryAssert(() -> battery);

    private Matcher<Integer> decreasedBy(int number) {
        return equalTo(create.initialCharge() - number);
    }

    private Matcher<Integer> negative() {
        return lessThan(0);
    }

}
