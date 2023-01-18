package com.practice.problem1;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class IPurchaseServiceTest {

    /**
     * なぜかオートワイヤリングできないので、応急処置
     */
    private IPurchaseService purchaseService = new PurchaseService();

    @Test
    void buyメソッドが動作している() {
        var merchandise = new Merchandise(new MerchandiseId(101L), new Price(500));
        var merchandise1 = new Merchandise(new MerchandiseId(102L), new Price(1000));

        var stock = new Stock();
        stock.add(merchandise);
        stock.add(merchandise1);

        var price = purchaseService.buy(stock, new MerchandiseId(101L));
        assertEquals(price.getValue(), 500);
    }

    @Test
    void selectメソッドが動作している() {
        var merchandise = new Merchandise(new MerchandiseId(101L), new Price(500));
        var merchandise1 = new Merchandise(new MerchandiseId(102L), new Price(1000));

        var stock = new Stock();
        stock.add(merchandise);
        stock.add(merchandise1);

        var select = purchaseService.select(stock, new MerchandiseId(102L));
        assertEquals(select, merchandise1);
    }
}