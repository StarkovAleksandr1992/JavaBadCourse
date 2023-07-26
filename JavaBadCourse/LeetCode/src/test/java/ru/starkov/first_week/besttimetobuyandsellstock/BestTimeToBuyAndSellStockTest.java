package ru.starkov.first_week.besttimetobuyandsellstock;

import org.junit.jupiter.api.Test;
import ru.starkov.first_week.besttimetobuyandsellstock.BestTimeToBuyAndSellStock;

import static org.junit.jupiter.api.Assertions.assertEquals;

class BestTimeToBuyAndSellStockTest {

    @Test
    void maxProfitIsExist() {
        int[] prices = {7, 1, 5, 3, 6, 4};
        assertEquals(5, BestTimeToBuyAndSellStock.maxProfit(prices));
    }

    @Test
    void maxProfitNotExist() {
        int[] prices = {7, 6, 5, 4, 3, 2, 1};
        assertEquals(0, BestTimeToBuyAndSellStock.maxProfit(prices));
    }
}