package org.example.domain.pricing;

import org.junit.Test;

public class MerchandiseTest {

    @Test(expected = IllegalArgumentException.class)
    public void 異常な値段の商品が生成されない() {
        var merchandise = new Merchandise(new Price(-1000));
    }

}