package com.leanrose;

import org.hamcrest.Matcher;

import static org.junit.Assert.assertThat;

public class ItemAssert {

    private final ItemGetter itemGetter;

    public ItemAssert(ItemGetter itemGetter) {
        this.itemGetter = itemGetter;
    }

    public void qualityIs(Matcher<Integer> matcher) {
        assertThat(itemGetter.getItem().quality, matcher);
    }

    public void sellInIs(Matcher<Integer> matcher) {
        assertThat(itemGetter.getItem().sellIn, matcher);
    }

}
