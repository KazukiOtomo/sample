package com.practice.sample;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class PurchaseTest {

    final Stock stock;
    final IPurchaseService purchaseService;

    public PurchaseTest(Stock stock, IPurchaseService purchaseService) {
        this.stock = stock;
        this.purchaseService = purchaseService;
    }

    // 全てのテストケースよりも一番先に走るメソッドです
    @BeforeEach
    void setUp() {
        var merchandise = new Merchandise(new MerchandiseId(101L), new Price(500));
        var merchandise1 = new Merchandise(new MerchandiseId(102L), new Price(1000));

        stock.add(merchandise);
        stock.add(merchandise1);
    }

    @Test
    void buyメソッドが動作している() {
        // 以下、動作しているか確かめるようなテスト
    }

    @Test
    void selectメソッドが動作している() {
        // 以下、動作しているか確かめるようなテスト
    }
}
