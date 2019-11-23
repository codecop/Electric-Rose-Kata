package com.leanrose;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ElectricRoseTest {

    @Test
    void foo() {
        Battery[] batteries = new Battery[] { new Battery("foo", false, 1) };
        ElectricRose app = new ElectricRose(batteries);
        app.updateCharge();
        assertEquals("fixme", app.batteries[0].type);
    }
}
