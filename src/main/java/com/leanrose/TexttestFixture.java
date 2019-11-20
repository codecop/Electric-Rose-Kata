package com.leanrose;

public class TexttestFixture {
    public static void main(String[] args) {
        System.out.println("OMGHAI!");

        Battery[] batteries = new Battery[] { //
                new Battery("+5 Dexterity Vest", 10, 20), //
                new Battery("Elixir of the Mongoose", 5, 7)}; //

        GildedRose app = new GildedRose(batteries);

        int times = 2;
        if (args.length > 0) {
            times = Integer.parseInt(args[0]) + 1;
        }

        for (int i = 0; i < times; i++) {
            System.out.println("-------- usage " + i + " --------");
            System.out.println("type, usages, charge");
            for (Battery battery : batteries) {
                System.out.println(battery);
            }
            System.out.println();
            app.updateCharge();
        }
    }

}
