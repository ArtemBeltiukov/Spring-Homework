package org.shop.inject;

import org.shop.config.InjectRandomInt;

public class InjectInt {
    @InjectRandomInt(min = 5, max = 10)
    private int avg;

    public int getAvg() {
        return avg;
    }
}
