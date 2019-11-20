package com.leanrose;

class GildedRose {
    Battery[] batteries;

    public GildedRose(Battery[] batteries) {
        this.batteries = batteries;
    }

    public void updateQuality() {
        for (int i = 0; i < batteries.length; i++) {
            if (batteries[i].quality > 0) {
                batteries[i].quality = batteries[i].quality - 1;
            }

            batteries[i].usages = batteries[i].usages - 1;

            if (batteries[i].usages < 0) {
                if (batteries[i].quality > 0) {
                    batteries[i].quality = batteries[i].quality - 1;
                }
            }
        }
    }
}
