package org.example.service;

import org.example.domain.pricing.Master;
import org.example.domain.pricing.Merchandise;
import org.example.domain.pricing.Price;
import org.junit.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PricingServiceTest {

    @Test
    public void Masterが値段をつけて商品を生成することができる() {
        var master = new Master();
        var merchandice = master.pricing(new Price(1000));
        assertEquals(merchandice.getPrice().getValue(), 1000);
    }

    @Test
    public void 値段を変えられるようにする(){
        var master = new Master();
        var merchandise = master.pricing(new Price(1000));
        merchandise = master.pricing(new Price(1500));
        assertEquals(merchandise.getPrice().getValue(), 1500);
    }

}