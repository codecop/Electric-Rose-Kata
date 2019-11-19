package com.leanrose;

import org.hamcrest.Matcher;
import org.junit.Test;

import com.leanrose.GildedRose;
import com.leanrose.Item;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.not;
import static org.hamcrest.number.OrderingComparison.lessThan;

// 39 test cases for single item updates
public class GildedRoseTest {

    // At the end of each day our system lowers both values (for every item)
    @Test
    public void shouldDecreaseSellInOfOrdinaryItem() {
        int initialSellIn = 5;
        create.ordinaryItem().toSellIn(initialSellIn);

        updateQuality();

        assertThat.sellInIs(lessThan(initialSellIn));
        assertThat.sellInIs(equalTo(initialSellIn - 1));
    }

    @Test
    public void shouldDecreaseQualityOfOrdinaryItem() {
        create.ordinaryItem().item();

        updateQuality();

        assertThat.qualityIs(decreasedBy(1));
    }

    // At the end of each day our system lowers both values *for every item*
    // TODO add test that update iterates the whole array of items ;-)

    // Once the sell by date has passed, Quality degrades twice as fast
    @Test
    public void shouldDecreaseQualityOfExpiredOrdinaryItemTwiceAsFast() {
        int initialQuality = 13;
        create.expired().ordinaryItem().ofQuality(initialQuality);

        updateQuality();

        assertThat.qualityIs(equalTo(initialQuality - 2));
    }

    // boundary
    @Test
    public void shouldDecreaseQualityOfOrdinaryItemOnLastDayStillByOne() {
        int initialQuality = 9;
        create.almostExpired().ordinaryItem().ofQuality(initialQuality);

        updateQuality();

        assertThat.qualityIs(equalTo(initialQuality - 1));
    }

    // boundary
    @Test
    public void shouldDecreaseQualityOfOrdinaryItemOnSellDateAlreadyByTwo() {
        int initialQuality = 8;
        create.justExpired().ordinaryItem().ofQuality(initialQuality);

        updateQuality();

        assertThat.qualityIs(equalTo(initialQuality - 2));
    }

    // The Quality of an item is never negative
    @Test
    public void shouldNotDecreaseQualityOfOrdinaryItemBelowZero() {
        create.ordinaryItem().ofNoQuality();

        updateQuality();

        assertThat.qualityIs(not(negative()));
    }

    @Test
    public void shouldNotDecreaseQualityOfExpiredOrdinaryItemWithNoQualityBelowZero() {
        create.expired().ordinaryItem().ofNoQuality();

        updateQuality();

        assertThat.qualityIs(not(negative()));
    }

    // boundary
    @Test
    public void shouldNotDecreaseQualityOfExpiredOrdinaryItemWithOneQualityBelowZero() {
        create.expired().ordinaryItem().ofQuality(1);

        updateQuality();

        assertThat.qualityIs(not(negative()));
    }

    // boundary
    @Test
    public void shouldDecreaseQualityOfOrdinaryItemDownToZero() {
        create.ordinaryItem().ofQuality(1);

        updateQuality();

        assertThat.qualityIs(equalTo(0));
    }

    // boundary
    @Test
    public void shouldDecreaseQualityOfExpiredOrdinaryItemDownToZero() {
        create.expired().ordinaryItem().ofQuality(2);

        updateQuality();

        assertThat.qualityIs(equalTo(0));
    }

    // --- infrastructure

    private Item item;

    protected final ItemBuilder create = new ItemBuilder(new ItemSetter() {
        @Override
        public void setItem(Item item) {
            GildedRoseTest.this.item = item;
        }
    });

    protected void updateQuality() {
        GildedRose gildedRose = new GildedRose(new Item[] { item });
        gildedRose.updateQuality();
    }

    protected final ItemAssert assertThat = new ItemAssert(new ItemGetter() {
        @Override
        public Item getItem() {
            return GildedRoseTest.this.item;
        }
    });

    protected Matcher<Integer> decreasedBy(int number) {
        return increasedBy(-number);
    }

    protected Matcher<Integer> negative() {
        return lessThan(0);
    }

    private Matcher<Integer> increasedBy(int number) {
        return equalTo(create.initialQuality() + number);
    }

}
