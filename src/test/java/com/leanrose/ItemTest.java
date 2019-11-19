package com.leanrose;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;

import com.leanrose.Item;

// 3 test cases for item itself
public class ItemTest {

    // All items have a SellIn value
    @Test
    public void shouldHaveSellIn() {
        Item item = new ItemBuilder().ordinaryItem().toSellIn(3);
        assertThat(item.sellIn, is(3));
        // in dynamic language an assert_responds_to is probably enough
    }

    // All items have a Quality value
    @Test
    public void shouldHaveQuality() {
        Item item = new ItemBuilder().ordinaryItem().ofQuality(7);
        assertThat(item.quality, is(7));
        // in dynamic language an assert_responds_to is probably enough
    }

    @Test
    public void shouldDisplayWithNameAndValues() {
        Item item = new ItemBuilder().agedBrie().withSellIn(3).ofQuality(7);
        assertThat(item.toString(), is("Aged Brie, 3, 7"));
    }

}
