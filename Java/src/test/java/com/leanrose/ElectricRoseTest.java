package com.leanrose;

import org.junit.Test;

import static org.junit.Assert.*;

public class ElectricRoseTest {

    @Test
    public void foo() {
        Battery[] batteries = new Battery[] { new Battery("foo", 0, 0) };
        ElectricRose app = new ElectricRose(batteries);
        app.updateCharge();
        assertEquals("fixme", app.batteries[0].type);
    }
}
