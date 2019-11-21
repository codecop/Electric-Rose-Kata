package com.leanrose;

class ElectricRose {
    Battery[] batteries;

    public ElectricRose(Battery[] batteries) {
        this.batteries = batteries;
    }

    public void updateCharge() {
        for (int i = 0; i < batteries.length; i++) {
            if (batteries[i].charge > 0) {
                batteries[i].charge = batteries[i].charge - 1;
            }

            if (batteries[i].dry) {
                if (batteries[i].charge > 0) {
                    batteries[i].charge = batteries[i].charge - 1;
                }
            }
        }
    }
}
