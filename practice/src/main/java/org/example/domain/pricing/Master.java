package org.example.domain.pricing;

public class Master {

    // 引数で与えられた価格に変更する
    public Merchandise pricing(Price price) {
        return new Merchandise(price);
    }

}
