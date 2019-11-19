package com.leanrose;

import org.hamcrest.Matcher;
import org.junit.Test;

import com.leanrose.GildedRose;
import com.leanrose.Item;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.not;
import static org.hamcrest.number.OrderingComparison.greaterThan;
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

    // "Aged Brie" actually increases in Quality the older it gets
    @Test
    public void shouldIncreaseQualityOfAgedBrie() {
        int initialQuality = 17;
        create.agedBrie().ofQuality(initialQuality);

        updateQuality();

        assertThat.qualityIs(greaterThan(initialQuality));
    }

    @Test
    public void shouldIncreaseQualityOfExpiredAgedBrieTwiceAsFast() {
        int initialQuality = 21;
        create.expired().agedBrie().ofQuality(initialQuality);

        updateQuality();

        assertThat.qualityIs(equalTo(initialQuality + 2));
    }

    // boundary
    @Test
    public void shouldIncreaseQualityOfAgedBrieOnLastDayStillByOne() {
        int initialQuality = 19;
        create.almostExpired().agedBrie().ofQuality(initialQuality);

        updateQuality();

        assertThat.qualityIs(equalTo(initialQuality + 1));
    }

    // boundary
    @Test
    public void shouldIncreaseQualityOfAgedBrieOnSellDateAlreadyByTwo() {
        int initialQuality = 18;
        create.justExpired().agedBrie().ofQuality(initialQuality);

        updateQuality();

        assertThat.qualityIs(equalTo(initialQuality + 2));
    }

    // The Quality of an item is never more than 50
    @Test
    public void shouldNotIncreaseQualityOfAgedBrieAboveMax() {
        create.agedBrie().ofMaxQuality();

        updateQuality();

        assertThat.qualityIs(not(greaterThan(50)));
    }

    @Test
    public void shouldNotIncreaseQualityOfExpiredAgedBrieWithMaxQualityAboveMax() {
        create.expired().agedBrie().ofMaxQuality();

        updateQuality();

        assertThat.qualityIs(not(greaterThan(50)));
    }

    // boundary
    @Test
    public void shouldNotIncreaseQualityOfExpiredAgedBriedWithAlmostMaxQualityAboveMax() {
        create.expired().agedBrie().ofQuality(49);

        updateQuality();

        assertThat.qualityIs(not(greaterThan(50)));
        assertThat.qualityIs(maximal());
    }

    // boundary
    @Test
    public void shouldIncreaseQualityOfAgedBrieUptoMax() {
        create.agedBrie().ofQuality(49);

        updateQuality();

        assertThat.qualityIs(maximal());
    }

    // boundary
    @Test
    public void shouldIncreaseQualityOfExpiredAgedBrieUptoMax() {
        create.expired().agedBrie().ofQuality(48);

        updateQuality();

        assertThat.qualityIs(maximal());
    }

    // "Sulfuras", being a legendary item, never has to be sold or decreases in Quality
    @Test
    public void shouldNotDecreaseSellInOfSulfuras() {
        int initialSellIn = 5;
        create.sulfuras().toSellIn(initialSellIn);

        updateQuality();

        assertThat.sellInIs(equalTo(initialSellIn));
    }

    @Test
    public void shouldNotDecreaseQualityOfSulfuras() {
        create.sulfuras().item();

        updateQuality();

        assertThat.qualityIs(unchanged());
    }

    @Test
    public void shouldNotDecreaseQualityOfExpiredSulfuras() {
        int legendaryQuality = 80;
        create.expired().sulfuras().ofQuality(legendaryQuality);

        updateQuality();

        assertThat.qualityIs(equalTo(legendaryQuality));
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

    private Matcher<Integer> unchanged() {
        return equalTo(create.initialQuality());
    }

    private Matcher<Integer> maximal() {
        return equalTo(50);
    }

    private Matcher<Integer> increasedBy(int number) {
        return equalTo(create.initialQuality() + number);
    }

}
