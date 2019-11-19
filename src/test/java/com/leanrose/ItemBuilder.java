package com.leanrose;

import com.leanrose.Item;

public class ItemBuilder {

    private static class NullSetter implements ItemSetter {
        @Override
        public void setItem(@SuppressWarnings("unused") Item item) {
            // null setter does not do anything
        }
    }

    private static final int FRESH = 5;
    private static final int NO_QUALITY = 0;
    private static final int NAX_QUALITY = 50;

    private final ItemSetter itemSetter;

    private String name;
    private int sellIn = FRESH;
    private int quality = 10;

    public ItemBuilder() {
        itemSetter = new NullSetter();
    }

    public ItemBuilder(ItemSetter itemSetter) {
        this.itemSetter = itemSetter;
    }

    public ItemBuilder ordinaryItem() {
        return item("any ordinary item");
    }

    ItemBuilder item(String itemName) {
        name = itemName;
        return this;
    }

    public ItemBuilder almostExpired() {
        return withSellIn(1);
    }

    public ItemBuilder justExpired() {
        return withSellIn(0);
    }

    public ItemBuilder expired() {
        return withSellIn(-3);
    }

    public Item toSellIn(int days) {
        return withSellIn(days).item();
    }

    public ItemBuilder withSellIn(int days) {
        sellIn = days;
        return this;
    }

    public Item ofQuality(int number) {
        return withQuality(number).item();
    }

    public Item ofNoQuality() {
        return withQuality(NO_QUALITY).item();
    }

    public Item ofMaxQuality() {
        return withQuality(NAX_QUALITY).item();
    }

    private ItemBuilder withQuality(int number) {
        quality = number;
        return this;
    }

    public Item item() {
        return set(build());
    }

    private Item build() {
        return new Item(name, sellIn, quality);
    }

    private Item set(Item item) {
        itemSetter.setItem(item);
        return item;
    }

    public int initialQuality() {
        return quality;
    }

}
