package com.leanrose;

class GildedRose {
    Battery[] batteries;

    public GildedRose(Battery[] batteries) {
        this.batteries = batteries;
    }

    public void updateCharge() {
        for (int i = 0; i < batteries.length; i++) {
            if (batteries[i].charge > 0) {
                batteries[i].charge = batteries[i].charge - 1;
            }

            batteries[i].usages = batteries[i].usages - 1;

            if (batteries[i].usages < 0) {
                if (batteries[i].charge > 0) {
                    batteries[i].charge = batteries[i].charge - 1;
                }
            }
        }
    }
}
