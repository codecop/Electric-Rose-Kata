package com.leanrose;

public class TexttestFixture {
    public static void main(String[] args) {
        System.out.println("OMGHAI!");

        Battery[] batteries = new Battery[] { //
                new Battery("+5 Dexterity Vest", 10, 20), //
                new Battery("Elixir of the Mongoose", 5, 7)}; //

        GildedRose app = new GildedRose(batteries);

        int days = 2;
        if (args.length > 0) {
            days = Integer.parseInt(args[0]) + 1;
        }

        for (int i = 0; i < days; i++) {
            System.out.println("-------- day " + i + " --------");
            System.out.println("name, sellIn, quality");
            for (Battery battery : batteries) {
                System.out.println(battery);
            }
            System.out.println();
            app.updateQuality();
        }
    }

}
