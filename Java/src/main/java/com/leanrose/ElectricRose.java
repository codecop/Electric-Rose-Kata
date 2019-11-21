package com.leanrose;

class ElectricRose {
    Battery[] batteries;

    public ElectricRose(Battery[] batteries) {
        this.batteries = batteries;
    }

    public void updateCharge() {
        for (int i = 0; i < batteries.length; i++) {
            if (batteries[i].charge >= 0.1) {
                batteries[i].charge = Math.max(0, batteries[i].charge - 0.1);
            }

            if (batteries[i].dry) {
                if (batteries[i].charge >= 0.1) {
                    batteries[i].charge = Math.max(0, batteries[i].charge - 0.1);
                }
            }
        }
    }
}
